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

package user;

import java.awt.Color;

import common.CreditCard;
import common.Note;
import common.NoteTen;
import common.NoteTwenty;

/**
* {@code Wallet} class represents the Wallet object and handles user interactions for
* selection of the {@code CreditCard}.
*
* @version 0.4
* @author Michael David Willis
*/

public class Wallet extends WalletFrame implements CardSelector {
	private CreditCard selectedCard;
	private NoteHolder holder20 = new NoteHolder((Note) new NoteTwenty((long) 123456, 20), 15);
	private NoteHolder holder10 = new NoteHolder((Note) new NoteTen((long) 987654, 10), 45);
	private CardHolder left = new CardHolder(45, 80);
	private CardHolder right = new CardHolder(285, 80);
	
	public Wallet() {
		super();
		addToFrame(this, holder10);
		addToFrame(this, holder20);
		addToFrame(this, left);
		addToFrame(this, right);
		
		left.a.card = new CreditCard("Customer 1", 12_345_679, 12345, Color.RED);
		left.b.card = new CreditCard("Customer 2", 12_345_680, 12345, Color.BLUE);
		left.refresh();
		
		left.a.addMouseListener(new CardSelector() {});
		left.b.addMouseListener(new CardSelector() {});
	}
	
	public CreditCard getSelected() {
		return selectedCard;
	}
	
	void setCard(CreditCard card) {
		this.selectedCard = card;
	}
}
