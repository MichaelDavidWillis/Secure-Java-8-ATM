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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Init;

/**
* {@code CardSelector} interface extends the {@code MouseListener} interface
* and adds default implementations for user mouse interactions.
*
* @version 0.4
* @author Michael David Willis
*/

interface CardSelector extends MouseListener {

	@Override
	public default void mouseClicked(MouseEvent e) {
		CardSlot slot = (CardSlot) e.getSource();
		Init.wallet.setCard(slot.card);
		System.out.println("Selected card ");
		slot.setBackground(Color.YELLOW);
		slot.repaint();
	}

	@Override
	public default void mousePressed(MouseEvent e) {}

	@Override
	public default void mouseReleased(MouseEvent e) {}

	@Override
	public default void mouseEntered(MouseEvent e) {
		CardSlot slot = (CardSlot) e.getSource();
		if (slot.card != null) {
			slot.setBackground(Color.CYAN);
			slot.repaint();
		}
	}

	@Override
	public default void mouseExited(MouseEvent e) {
		CardSlot slot = (CardSlot) e.getSource();
		if (slot.card != null) {
			slot.setBackground(slot.card.colour);
			slot.repaint();
		}
	}
	

}
