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

import javax.swing.JButton;
import javax.swing.JPanel;

import user.CreditCard;

/**
* {@code CardReader} class represents the credit card reader of the ATM and verifies
*  the card before any ATM actions are made.
*
* @version 0.2
* @author Michael David Willis
*/

class CardReader {

	JPanel reader = new JPanel();
	JButton cardInsert = new JButton();
	public boolean cardIn = false;
	private int bankCode = 12345;
	CreditCard card;
	
	// constructor
	CardReader() {
		reader.setBounds(240, 190, 75, 100);
		reader.setBackground(Color.gray);
		
		reader.add(cardInsert);
	}
	
	JPanel createCardReader() {
		return reader;
	}
	
	boolean cardEntered(CreditCard card) {
		cardIn = true;
		
		System.out.println("Checking card...");
		
		if(card.verifyBankCode() == bankCode) {
			this.card = card;
			
			System.out.println("Card verified...");
			
			return true;
		}
		cardReturned();
		return false;
	}
	
	void cardReturned() {
		card = null;
		cardIn = false;
	}
	
	JButton getButton() {
		return cardInsert;
	}
}
