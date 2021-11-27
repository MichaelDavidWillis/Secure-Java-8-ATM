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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import bank.Authenticator;

/**
* {@code Dispenser} class represents the cash dispenser of the ATM 
*
* @version 0.2
* @author Michael David Willis
*/

class Dispenser extends JPanel {

	int DepositSlots;
	int cashStored;
	
	// Constructor
	
	Dispenser() {
		DepositSlots = 10;
		cashStored = 1000;
		
		setBounds(60, 370, 255, 40);
		setBackground(Color.black);
	}
	
	// Methods
	
	void dispenseMoney(int amount, Authenticator authenticate, Screen screen) {
		
		setBackground(Color.red);
		
		Timer timeToTakeCash = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.black);
				System.out.println("Unsuccessful dispensation...");
				authenticate.authenticateTransaction(false);
				authenticate.finalizeTransaction(false, amount);
				System.out.println("£" + amount + " returned to account...");
				screen.userScreen(
						authenticate.getAvailableBalance(),
						authenticate.getTotalBalance());
			}
		});
		
		timeToTakeCash.setRepeats(false);
		timeToTakeCash.start();
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timeToTakeCash.stop();
				setBackground(Color.black);
				System.out.println("Cash taken");
				System.out.println("£" + amount + " dispensed...");
				cashStored -= amount;
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	void collectMoney() {
		setBackground(Color.white);
	}
}
