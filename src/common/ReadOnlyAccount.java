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
* {@code ReadOnlyAccount} class represents an immutable read-only version
* of an {@code Account} object that can safely be return to an ATM object
* to display it's given information to the user.
*
* @version 0.3
* @author Michael David Willis
*/

public final class ReadOnlyAccount {
	private final String name;
	private final double availableBalance;
	private final double totalBalance;
	private final long uniqueKey;
	
	public ReadOnlyAccount(String name, Double availableBalance, Double totalBalance, long uniqueKey){
		this.name = name;
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
		this.uniqueKey = uniqueKey;
	}
	
	public final String getName() {
		return name;
	}
	
	public final double getTotalBalance() {
		return totalBalance;
	}
	
	public final double getAvailableBalance() {
		return availableBalance;
	}
	
	public final Long getKey() {
		return uniqueKey;
	}
}
