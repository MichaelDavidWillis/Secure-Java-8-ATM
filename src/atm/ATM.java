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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import bank.Authenticator;
import user.CreditCard;

/**
* {@code ATM} class represents the ATM and handles operations between all other objects.
*
* @version 0.2
* @author Michael David Willis
*/

public class ATM extends JFrame {
	private Screen screen = new Screen();
	private Keypad keypad = new Keypad();
	private Dispenser dispenser = new Dispenser();
	private CardReader cardReader = new CardReader();
	private JFrame atm = new JFrame("ATM");
	private Authenticator authenticate = new Authenticator();
	
	public ATM() {

		atm.setResizable(false);
		atm.getContentPane().setBackground(Color.darkGray);
		atm.setSize(400, 500);
		
		screen.createScreen();		
		screen.welcomeScreen();
		
		atm.add(screen);
		atm.add(keypad.addKeypad());
		atm.add(cardReader.createCardReader());
		atm.add(dispenser);
		
		JButton cardInserted = cardReader.getButton();
		cardInserted.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!cardReader.cardIn) {
					cardEntered();
				}
			}			
		});
		
		atm.setLayout(null);
		atm.setVisible(true);
		
		atm.setIconImage(new ImageIcon("images/atm-logo.png").getImage());
		atm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void cardEntered() {
		if (cardReader.cardEntered(new CreditCard("Customer 1", 12_345_679, 12345))) {
			screen.loginScreen();
			keypad.addKeypadListeners();
			keypad.BEnter.addActionListener(new ActionListener() {

		// set actions for when PIN number is input and the "Enter" button pressed.
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Authenticating User...");
					keypad.clearKeypadListeners();
					
					if(authenticate.authenticateUser(
							cardReader.card.accountNumber, 
							Integer.parseInt(Screen.Inputfield.getText()))) {
						System.out.println("User Authenticated...");
						screen.userScreen(
								authenticate.getAvailableBalance(), 
								authenticate.getTotalBalance());
						removeActionListeners(keypad.BEnter);
						addTransactionKeypad();
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
	
	private void makeTranasction(boolean type) {
		if (authenticate.authenticateUser(cardReader.card.accountNumber, 
							Integer.parseInt(Screen.Inputfield.getText()))
				&& authenticate.authenticateTransaction(type)) {
			if (type) {
				removeActionListeners(keypad.B1);
				removeActionListeners(keypad.B3);
				screen.withdrawalScreen();
				addWithdrawalKeypad();
				
			} else {
				removeActionListeners(keypad.B1);
				removeActionListeners(keypad.B3);
				screen.depositScreen();
				
			}
		}
	}
	
	private void returnCard() {
		if (cardReader.cardIn) {	
			authenticate.clear();
			cardReader.cardReturned();
			keypad.resetUserinput();
			Screen.Inputfield.setText("");
			screen.welcomeScreen();
			keypad.removeActionListenersFromAll();
	
			System.out.println("Card returned.");
		}
	}
	
	private void removeActionListeners(JButton button) {
		for (ActionListener al : button.getActionListeners()) {
			button.removeActionListener(al);
		}
	}
	
	private void addTransactionKeypad() {
		keypad.B1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				makeTranasction(true);
				screen.withdrawalScreen();
			}
		});
		keypad.B3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				makeTranasction(false);
				screen.depositScreen();
			}
		});
		keypad.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cardReader.cardIn) returnCard();
				screen.welcomeScreen();
			}
		});
	}
	
	private void addWithdrawalKeypad() {
		keypad.B1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 20)) {
					dispenser.dispenseMoney(20, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
					returnCard();
				}
			}
		});
		keypad.B3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 40)) {
					dispenser.dispenseMoney(40, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
					returnCard();
				}
			}
		});
		keypad.B4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 60)) {
					dispenser.dispenseMoney(60, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
					returnCard();
				}
			}
		});
		keypad.B6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 80)) {
					dispenser.dispenseMoney(80, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
					returnCard();
				}
			}
		});
		keypad.B7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 100)) {
					dispenser.dispenseMoney(100, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
	  				returnCard();
				}
			}
		});
		keypad.B9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (authenticate.finalizeTransaction(true, 200)) {
					dispenser.dispenseMoney(200, authenticate, screen);
					screen.takeMoneyScreen();
				} else {
					returnCard();
				}
			}
		});
		keypad.B0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : Custom amount
			}
		});
		keypad.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				returnCard();
				screen.welcomeScreen();
			}
		});
	}
	
	private void addDepositKeypad() {
		keypad.BEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : Finished entering cash
			}
		});
		
		keypad.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				returnCard();
				screen.welcomeScreen();
			}
		});
	}
}
