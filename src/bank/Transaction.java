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
* {@code Transactions} class is an abstract class that represents the
* essential parts of a transaction.
*
* @version 0.3
* @author Michael David Willis
*/

abstract class Transaction {

	double availableOrTotal;
	double amountEnd;
	
	int amount;
	
	abstract boolean calculate();
	
	void populateTransaction(double availableOrTotal, int amount) {
		this.availableOrTotal = availableOrTotal;
		this.amount = amount;
	}
}
