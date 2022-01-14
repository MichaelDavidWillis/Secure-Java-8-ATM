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

import javax.swing.JPanel;

import common.Note;

/**
* {@code NoteHolder} class represents an object that can store and retrieve
* {@code Note} objects.
*
* @version 0.4
* @author Michael David Willis
*/

class NoteHolder extends JPanel  {

	NoteHolder(Note type, int position) {
		
		setBounds(15, position, 450, 20);
		setBackground(Color.black);
	}
}
