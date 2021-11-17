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

public class CreditCard {
	public String name;
	public int accountNumber;
	private int bankCode = 12345;
	
	public CreditCard(String name, int accountNumber, int bankCode) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.bankCode = bankCode;
	}
	
	public int verifyBankCode() {
		return bankCode;
	}
}
