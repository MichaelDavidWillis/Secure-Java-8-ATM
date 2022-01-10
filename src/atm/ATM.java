/*
 * Copyright (C) 2021 Michael David Willis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.ReadOnlyAccount;
import main.Init;

/**
* {@code ATM} class represents the ATM and handles operations between it's subject parts.
*
* @version 0.3
* @author Michael David Willis
*/

public class ATM extends ATMFrame {
	
	private Screen screen = new Screen();
	private Keypad keypad = new Keypad();
	Dispenser dispenser = new Dispenser();
	CardReader cardReader = new CardReader();
	private ReadOnlyAccount account;
	private ATM atm = this;
	//********************************************************************************
	public ATM() {
		super();
		screen.createScreen();		
		screen.welcomeScreen();
		
		addToFrame(screen);
		addToFrame(keypad.addKeypad());
		addToFrame(cardReader.createCardReader());
		addToFrame(dispenser);
		
		JButton cardInsert = cardReader.getButton();
		cardInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!cardReader.cardIn) {
					cardEntered();
				}
			}
		});
	}
	/////////////////////////////////////////////////////////////////////////////////
	private void cardEntered() {
		if (cardReader.cardEntered(new user.CreditCard("Customer 1", 12_345_679, 12345))) {
			screen.loginScreen();
			keypad.addKeypadListeners();
			KeypadButtons.BEnter.addActionListener(new ActionListener() {

		// set actions for when PIN number is input and the "Enter" button pressed.
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Authenticating User...");
					keypad.removeActionListenersFromAll();
					account = Init.bankA.authenticate(atm, cardReader.card.accountNumber, 
							Integer.parseInt(Screen.Inputfield.getText()));
					if(account != null) {
						System.out.println("User Authenticated...");
						screen.userScreen(account);
						removeActionListeners(KeypadButtons.BEnter);
						KeypadListeners.addTransactionKeypad(atm ,screen);
					} else {
						System.out.println("User Not Authenticated...");
						returnCard();
					}
				}
			});
		} else {
			System.out.println("Card Not Authenticated...");
			returnCard();
		}
	}

	void returnCard() {
		account = null;
		if (cardReader.cardIn) {
			cardReader.cardReturned();
			keypad.resetUserinput();
			Screen.Inputfield.setText("");
			screen.welcomeScreen();
			keypad.removeActionListenersFromAll();
			System.out.println("Card returned.");
		}
	}
	
	void makeTranasction(boolean type) {
		if (Init.bankA.makeTransaction(this, account.getKey(), type)) {
			removeActionListeners(KeypadButtons.B1);
			removeActionListeners(KeypadButtons.B3);
			
			if (type) {
				screen.withdrawalScreen();
				KeypadListeners.addWithdrawalKeypad(atm ,screen);
				
			} else {
				screen.depositScreen();
				KeypadListeners.addDepositKeypad(atm ,screen);
			}
		}
	}
	
	boolean finalizeTransaction(int amount) {
		return Init.bankA.finalizeTransaction(atm, account.getKey(), true, amount);
	}
	
	void moneyNotTaken(int amount) {
		Init.bankA.moneyNotTaken(atm, account.getKey(), amount);
	}
}
