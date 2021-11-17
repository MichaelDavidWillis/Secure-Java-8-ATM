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

final class Account {
	private String name;
	private String accountNumber;
	private String pin;
	private String availableBalance;
	private String unavailableBalance;
	
	// constructor
	Account(String name, String accountNumber, String pin, 
			String unavailableBalance, String availableBalance){
		this.name = name;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.availableBalance = availableBalance;
		this.unavailableBalance = unavailableBalance;
	}
	
	// getters
	String getName() {
		return new String(name);
	}
	
	Integer getPin() {
		return Integer.parseInt(pin);
	}
	
	Integer getAccountNumber() {
		return Integer.parseInt(accountNumber);
	}
	
	Double getTotalBalance() {
		return Double.parseDouble(availableBalance) 
				+ Double.parseDouble(unavailableBalance);
	}
	
	Double getAvailableBalance() {
		return Double.parseDouble(availableBalance);
	}
	
	// setters
	void setPin(Integer pin) throws Exception {
		this.pin = Integer.toString(pin);
	}
	
	void changeBalance(Double newBalance, boolean isWithdrawal) throws Exception {
		if (isWithdrawal) {
			this.availableBalance = Double.toString(newBalance);
		} else {
			this.unavailableBalance = Double.toString(newBalance);
		}
	}
}