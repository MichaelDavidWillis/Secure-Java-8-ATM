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

package common;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
* {@code PanelHelper} interface is meant to more easily handle
* JPanel and button objects.
*
* @version 0.4
* @author Michael David Willis
*/

public interface PanelHelper {

	default void addToFrame(JFrame frame, Component c) {
		frame.add(c);
		frame.setVisible(true);
		frame.repaint();
	}
	
	default void removeActionListeners(JButton button) {
		for (ActionListener al : button.getActionListeners()) {
			button.removeActionListener(al);
		}
	}
}
