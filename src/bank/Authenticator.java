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

// Passes information in and out of package
public final class Authenticator {
	
	private Database database = new Database();
	private TransactionFactory factory = new TransactionFactory();
	private Account account = null;
	private Transactions transaction = null;
	
	// methods
	public boolean authenticateUser(int accountNumber, int pin) {
		if (validateAccountNumber(accountNumber) && validatePin(pin)) {
			account = database.getAccount(accountNumber, pin);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean authenticateTransaction(boolean isWithdrawal){
		if (this.account != null) {
			transaction = factory.createTransaction(isWithdrawal);
			System.out.println("Transaction created...");
			return true;
		}
		System.out.println("Transaction cancelled...");
		cancelTransaction();
		return false;
	}
	
	public boolean finalizeTransaction(boolean isWithdrawal, int amount) {
		if (this.account != null && this.transaction != null) {
			if (isWithdrawal) {
				transaction.populateTransaction(getAvailableBalance(), amount);
			} else {
				transaction.populateTransaction(getTotalBalance(), amount);
			}
			System.out.println("Calculating transaction...");
			if (transaction.calculate()) {
				try {
					System.out.println("Transaction in progress...");
					account.changeBalance(transaction.amountEnd, true);
				} catch (Exception e) {
					System.out.println("Cancelling transaction...");
					cancelTransaction();
					return false;
				}
				System.out.println("Transaction complete...");
				account = null;
				transaction = null;
				return true;
			} else {
				// TODO : insufficient funds screen
				System.out.println("Cancelling transaction...");
				cancelTransaction();
				return false;
			}
		} else {
			System.out.println("Cancelling transaction...");
			cancelTransaction();
			return false;
		}
	}
	
	void cancelTransaction() {
		System.out.println("Transaction cancelled...");
		this.account = null;
		this.transaction = null;
	}
	
	// validators - other validation methods can be added here,
	// this is merely to show the concept being used.
	
	private boolean validateAccountNumber(Integer accountNumber) {
		System.out.println("Validating Account Number ...");
		return accountNumber.toString().length() == 8 ? true : false;
	}
	
	private boolean validatePin(Integer pin) {
		System.out.println("Validating PIN Number ...");
		return pin.toString().length() == 4 ? true : false;
	}
		
	// Getters
	
	public double getAvailableBalance() {
		return Double.parseDouble(account.getAvailableBalance().toString());
	}
	
	public double getTotalBalance() {
		return Double.parseDouble(account.getTotalBalance().toString());
	}

	public void clear() {
		if (account != null || transaction != null) cancelTransaction();
	}
}
