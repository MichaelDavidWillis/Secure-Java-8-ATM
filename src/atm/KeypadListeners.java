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

/**
* {@code KeypadListeners} class holds methods for changing the 
* {@code ActionListener}'s on {@code Keypad} buttons.
*
* @version 0.4
* @author Michael David Willis
*/

final class KeypadListeners {

	static void addTransactionKeypad(ATM atm, Screen screen) {
		KeypadButtons.B1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atm.makeTranasction(true);
				screen.withdrawalScreen();
			}
		});
		KeypadButtons.B3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atm.makeTranasction(false);
				screen.depositScreen();
			}
		});
		KeypadButtons.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (atm.cardReader.cardIn) atm.returnCard();
				atm.nullAccount();
				screen.welcomeScreen();
			}
		});
	}
	
	static void addWithdrawalKeypad(ATM atm, Screen screen) {
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B1, 20);
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B3, 40);
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B4, 60);
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B6, 80);
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B7, 100);
		addWithdrawalButtonListener(atm, screen, KeypadButtons.B9, 200);
		
		KeypadButtons.B0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : Custom amount
			}
		});
		KeypadButtons.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atm.returnCard();
				atm.nullAccount();
				screen.welcomeScreen();
			}
		});
	}
	
	static void addDepositKeypad(ATM atm, Screen screen) {
		KeypadButtons.BEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : Finished entering cash
			}
		});
		
		KeypadButtons.BClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				atm.returnCard();
				atm.nullAccount();
				screen.welcomeScreen();
			}
		});
	}
	
	static void addWithdrawalButtonListener(ATM atm, Screen screen, JButton button, int amount) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (atm.finalizeTransaction(amount)) {
					atm.returnCard();
					screen.takeMoneyScreen();
					atm.dispenser.dispenseMoney(atm, amount, screen);
				} else {
					atm.returnCard();
				}
			}
		});
	}
}
