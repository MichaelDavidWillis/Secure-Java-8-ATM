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

import java.awt.Color;

/**
* {@code CreditCard} class represents an object to be used with a {@code ATM}
* object.
*
* @version 0.4
* @author Michael David Willis
*/

public class CreditCard {
	public String name;
	public int accountNumber;
	private int bankCode;
	public Color colour;
	
	public CreditCard(String name, int accountNumber, int bankCode, Color colour) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.bankCode = bankCode;
		this.colour = colour;
	}
	
	public int verifyBankCode() {
		return bankCode;
	}
}
