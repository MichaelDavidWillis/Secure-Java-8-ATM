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

import atm.ATM;
import common.ReadOnlyAccount;

/**
* {@code Bank} class represents a bank object.
*
* @version 0.3
* @author Michael David Willis
*/

public class Bank {

	public String name;
	private Database database;
	private int securityCode;
	//************************************************************************
	public Bank(String name, int securityCode) {
		this.name = name;
		this.securityCode = securityCode;
		database = new Database();
	}
	//////////////////////////////////////////////////////////////////////////
	public ReadOnlyAccount authenticate(ATM atm, int accountNumber, int pin) {
		if(!verifyATM(atm)) return null;
		Account account = Authenticator.authenticateUser(accountNumber, pin, database);
		if(account == null) return null;
		
		Long uniqueKey = Long.valueOf((long) (account.hashCode() * Math.random() * 10));
		TransactionOperations.addToAccounts(uniqueKey, account);
		return new ReadOnlyAccount(account.getName(), account.getAvailableBalance(), account.getTotalBalance(), uniqueKey);
	}
	
	public boolean makeTransaction(ATM atm, Long uniqueKey, boolean isWithdrawal) {
		if(!verifyATM(atm)) return false;
		return TransactionOperations.createTransaction(uniqueKey, isWithdrawal);
	}
	
	public boolean finalizeTransaction(ATM atm, Long uniqueKey, boolean isWithdrawal, int amount) {
		if(!verifyATM(atm)) return false;
		return TransactionOperations.finalizeTransaction(uniqueKey, isWithdrawal, amount);
	}
	
	public void moneyNotTaken(ATM atm, long uniqueKey, int amount) {
		if(verifyATM(atm)) {
			System.out.println("Unsuccessful dispensation...");
			TransactionOperations.createTransaction(uniqueKey, false);
			TransactionOperations.finalizeTransaction(uniqueKey, false, amount);
			System.out.println("£" + amount + " returned to account...");
		}
	}
	
	private boolean verifyATM(ATM atm) {
		// TODO: verify ATM
		return true;
	}
}
