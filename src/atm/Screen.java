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

package atm;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import common.ReadOnlyAccount;

/**
* {@code Screen} class represents the ATM screen.
*
* @version 0.4
* @author Michael David Willis
*/

class Screen extends ScreenBase{
	
	void welcomeScreen() {
		clearScreen();
		addLabel(labelOne, "greet", 2, 18);
		addLabel(labelTwo, "insert", 2, 14);
		addLabel(depositLabel, "en", 1, 14);
		addLabel(withdrawLabel, "cy", 3, 14);

		top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));
		top.add(labelOne);
		top.add(Box.createRigidArea(new Dimension(20, 20)));
		top.add(labelTwo);
		top.add(Box.createRigidArea(new Dimension(20, 20)));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
		bottom.add(depositLabel);
		bottom.add(Box.createRigidArea(new Dimension(20, 20)));
		bottom.add(withdrawLabel);
	}
	
	void loginScreen() {
		clearScreen();
		addLabel(labelOne, "pin", 2, 18);
		Inputfield.setPreferredSize(new Dimension(100, 20));
		Inputfield.setVisible(true);
		
		top.add(labelOne);
		bottom.add(Inputfield);
	}
	
	void userScreen(ReadOnlyAccount account) {
		clearScreen();
		addLabel(labelOne, "greetUser", 2, 18, account.getName());
		addLabel(labelTwo, "total", 2, 14, account.getTotalBalance());
		addLabel(labelThree, "available", 2, 14, account.getAvailableBalance());
		addLabel(withdrawLabel, "withdraw", 2, 14);
		addLabel(depositLabel, "deposit", 2, 14);
		addLabel(cancelLabel, "clear", 2, 14);
		
		top.add(labelOne);
		top.add(labelTwo);
		top.add(labelThree);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
		bottom.add(withdrawLabel);
		bottom.add(depositLabel);
		bottom.add(cancelLabel);
	}
	
	void withdrawalScreen() {
		clearScreen();
		addLabel(label20, "20", 2, 14);
		addLabel(label40, "40", 2, 14);
		addLabel(label60, "60", 2, 14);
		addLabel(label80, "80", 2, 14);
		addLabel(label100, "100", 2, 14);
		addLabel(label200, "200", 2, 14);
		addLabel(labelOne, "select", 2, 18);
		label20.setHorizontalAlignment(JLabel.CENTER);
		label40.setHorizontalAlignment(JLabel.CENTER);
		label60.setHorizontalAlignment(JLabel.CENTER);
		label80.setHorizontalAlignment(JLabel.CENTER);
		label100.setHorizontalAlignment(JLabel.CENTER);
		label200.setHorizontalAlignment(JLabel.CENTER);

		top.add(labelOne);
		bottom.add(label20);
		bottom.add(label40);
		bottom.add(label60);
		bottom.add(label80);
		bottom.add(label100);
		bottom.add(label200);
		bottom.setLayout(layout);
	}
	
	void depositScreen() {
		clearScreen();
		addLabel(labelOne, "na", 2, 18);
		top.add(labelOne);
	}
	
	void takeMoneyScreen() {
		clearScreen();
		addLabel(labelTwo, "prompt", 2, 14);
		top.add(labelTwo);
	}
}