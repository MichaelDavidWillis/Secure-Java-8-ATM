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

import java.util.HashMap;
import java.util.Map;

/**
* {@code TransactionOperations} class handles {@code Transaction} object operations
* between an ATM object and the bank's {@code Account}'s.
*
* @version 0.3
* @author Michael David Willis
*/

class TransactionOperations {

	private final static Map<Long, Account> accountsAccessed = new HashMap<>();
	private final static Map<Long, Transaction> transactionsInProgress = new HashMap<>();
	
	private static TransactionFactory factory = new TransactionFactory();
	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	static void addToAccounts(Long uniqueKey, Account account) {
		accountsAccessed.put(uniqueKey, account);
	}
	
	static void addToTransactions(Long uniqueKey, Transaction transaction) {
		transactionsInProgress.put(uniqueKey, transaction);
	}
	
	static boolean createTransaction(long uniqueKey, boolean isWithdrawal) {
		if (accountsAccessed.containsKey(uniqueKey)) {
			transactionsInProgress.put(uniqueKey, factory.createTransaction(isWithdrawal));
			System.out.println("Transaction created...");
			return true;
		}
		System.out.println("Transaction cancelled...");
		cancelTransaction(uniqueKey);
		return false;
	}
	
	private static void cancelTransaction(Long uniqueKey) {
		transactionsInProgress.remove(uniqueKey);
		System.out.println("Transaction cancelled...");
	}

	static void clear(Long uniqueKey) {
		accountsAccessed.remove(uniqueKey);
		transactionsInProgress.remove(uniqueKey);
	}
	
	static boolean finalizeTransaction(long uniqueKey, boolean isWithdrawal, int amount) {
		if (accountsAccessed.containsKey(uniqueKey) && transactionsInProgress.containsKey(uniqueKey)) {
			Account account = accountsAccessed.get(uniqueKey);
			Transaction transaction = transactionsInProgress.get(uniqueKey);
			if (isWithdrawal) {
				transaction.populateTransaction(account.getAvailableBalance(), amount);
			} else {
				transaction.populateTransaction(account.getTotalBalance(), amount);
			}
			System.out.println("Calculating transaction...");
			if (transaction.calculate()) {
				try {
					System.out.println("Transaction in progress...");
					account.changeBalance(transaction.amountEnd, isWithdrawal);
				} catch (Exception e) {
					System.out.println("Cancelling transaction...");
					cancelTransaction(uniqueKey);
					return false;
				}
				System.out.println("£" + amount + " " + ((isWithdrawal) ? "withdrawn" : "deposited"));
				System.out.println("Transaction complete...");
				transactionsInProgress.remove(uniqueKey);
				return true;
			} else {
				// TODO : insufficient funds screen
				System.out.println("Insufficient funds...");
				cancelTransaction(uniqueKey);
				return false;
			}
		} else {
			System.out.println("Cancelling transaction...");
			cancelTransaction(uniqueKey);
			return false;
		}
	}
}
