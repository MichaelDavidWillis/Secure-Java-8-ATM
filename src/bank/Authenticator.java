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

package bank;

/**
* {@code Authenticator} class represents the object that handles {@code Account}
* authentification from {@code ATM} objects to the {@code Bank} object.
*
* @version 0.3
* @author Michael David Willis
*/

public final class Authenticator {
	
	public static Account authenticateUser(int accountNumber, int pin, Database database) {
		if (validateAccountNumber(accountNumber) && validatePin(pin)) {
			return database.getAccount(accountNumber, pin);
		} else {
			return null;
		}
	}
	
	// validators
	
	private static boolean validateAccountNumber(Integer accountNumber) {
		System.out.println("Validating Account Number ...");
		return accountNumber.toString().length() == 8 ? true : false;
	}
	
	private static boolean validatePin(Integer pin) {
		System.out.println("Validating PIN Number ...");
		return pin.toString().length() == 4 ? true : false;
	}
}
