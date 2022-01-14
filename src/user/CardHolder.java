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
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
* {@code CardHolder} class represents an object that can hold {@code CardSlot}
* objects for user interaction.
*
* @version 0.4
* @author Michael David Willis
*/

class CardHolder extends JPanel  {

	CardSlot a;
	CardSlot b;
	CardSlot c;
	
	CardHolder(int x, int y){
		setBounds(x, y, 150, 130);
		setBackground(Color.BLUE);
		this.setVisible(true);
		this.setLayout(new GridLayout(3, 0));
		
		this.add(a = new CardSlot(x, y));
		this.add(b = new CardSlot(x, y + 45));
		this.add(c = new CardSlot(x, y + 90));
		refresh();
	}
	
	void refresh() {
		if (a.card != null) a.setBackground(a.card.colour);
		if (b.card != null)b.setBackground(b.card.colour);
		if (c.card != null)c.setBackground(c.card.colour);
		repaint();
	}
}
