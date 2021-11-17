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

final class TransactionFactory {

	Transactions createTransaction(boolean isWithdrawal) {
		if (isWithdrawal) {
			System.out.println("Withdrawal in progress...");
			return new Withdrawal();
		} else {
			System.out.println("Deposit in progress...");
			return new Deposit();
		}
	}
	
	private final class Deposit extends Transactions {

		@Override
		boolean calculate() {
			amountEnd = availableOrTotal + amount;
			return true;
		}
	}
	
	private final class Withdrawal extends Transactions {

		@Override
		boolean calculate() {
			if (sufficientFunds()) {
				System.out.println("Sufficient Funds...");
				amountEnd = availableOrTotal - amount;
				return true;
			} else {
				System.out.println("Insufficient Funds...");
				return false;
			}
		}
		
		private boolean sufficientFunds() {
			return availableOrTotal - amount >= 0 ? true : false;			
		}
	}
}
