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

import javax.swing.JButton;

/**
* {@code KeypadButtons} interface represents the buttons that make up 
* a keypad and is meant to be implemented by a {@code Keypad} object.
*
* @version 0.3
* @author Michael David Willis
*/

public interface KeypadButtons {

	public final JButton B1 = new JButton("1");
	public final JButton B2 = new JButton("2");
	public final JButton B3 = new JButton("3");
	public final JButton B4 = new JButton("4");
	public final JButton B5 = new JButton("5");
	public final JButton B6 = new JButton("6");
	public final JButton B7 = new JButton("7");
	public final JButton B8 = new JButton("8");
	public final JButton B9 = new JButton("9");
	public final JButton B0 = new JButton("0");
	public final JButton BClear = new JButton("Clear");
	public final JButton BEnter = new JButton("Enter");
	
}
