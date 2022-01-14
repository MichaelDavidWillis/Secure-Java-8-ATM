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

/**
* {@code NoteTen} are objects that simulate a £10 bank note.
*
* @version 0.4
* @author Michael David Willis
*/

public class NoteTen extends Note {

	public int value;
	
	public NoteTen(Long serialNumber, int value) {
		super(serialNumber);
		this.value = value;
	}

}