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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Screen extends JPanel{	

	static JLabel LabelOne = new JLabel();
	static JLabel LabelTwo = new JLabel();
	JLabel withdrawLabel = new JLabel();
	JLabel depositLabel = new JLabel();
	JLabel cancelLabel = new JLabel();
	static JTextField Inputfield = new JTextField();

	JLabel label20 = new JLabel("1 = £20");
	JLabel label40 = new JLabel("3 = £40");
	JLabel label60 = new JLabel("4 = £60");
	JLabel label80 = new JLabel("6 = £80");
	JLabel label100 = new JLabel("7 = £100");
	JLabel label200 = new JLabel("9 = £200");
	
	static JPanel top = new JPanel();
	static JPanel bottom = new JPanel();
	
	GridLayout layout = new GridLayout(0, 2);
	
	void createScreen() {
		
		setBounds(50, 20, 285, 150);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Inputfield.setEditable(false);
	}
	
	void clearScreen() {
		
		LabelOne.setText("");
		LabelOne.setVisible(false);
		LabelTwo.setText("");
		LabelTwo.setVisible(false);
		
		Inputfield.setVisible(false);
		
		cancelLabel.setVisible(false);
		depositLabel.setVisible(false);
		withdrawLabel.setVisible(false);
		
		label20.setVisible(false);
		label40.setVisible(false);
		label60.setVisible(false);
		label80.setVisible(false);
		label100.setVisible(false);
		label200.setVisible(false);
		
		removeAll();
		
		top = new JPanel();
		bottom = new JPanel();
		top.setAlignmentY(TOP_ALIGNMENT);
		bottom.setAlignmentY(BOTTOM_ALIGNMENT);
		top.setVisible(true);
		bottom.setVisible(true);
		
		add(top);
		add(bottom);
	}
	
	void welcomeScreen() {
		clearScreen();
				
		LabelOne.setText("Welcome");
		LabelOne.setAlignmentX(Component.CENTER_ALIGNMENT);
		LabelOne.setFont(new Font("Monospaced", Font.PLAIN, 18));
		LabelOne.setVisible(true);
		
		top.add(LabelOne);
		
		LabelTwo.setText("Please insert your Card");
		LabelTwo.setAlignmentX(Component.CENTER_ALIGNMENT);		
		LabelTwo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		LabelTwo.setVisible(true);
		
		bottom.add(LabelTwo);
	}
	
	void loginScreen() {
		clearScreen();
		
		LabelOne.setText("Please enter your PIN");
		LabelOne.setAlignmentX(Component.CENTER_ALIGNMENT);		
		LabelOne.setFont(new Font("Monospaced", Font.PLAIN, 18));
		LabelOne.setVisible(true);
		
		top.add(LabelOne);
		
		Inputfield.setPreferredSize(new Dimension(100, 20));
		Inputfield.setVisible(true);
		
		bottom.add(Inputfield);
	}
	
	void userScreen(double available, double total) {
		clearScreen();
		LabelOne.setText("Total Balance : " + total);
		LabelTwo.setText("Available Balance : " + available);
		
		LabelOne.setVisible(true);
		LabelTwo.setVisible(true);
		
		withdrawLabel.setText("1 - Withdrawal");
		withdrawLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		withdrawLabel.setVisible(true);
		withdrawLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		depositLabel.setText("3 - Deposit");
		depositLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		depositLabel.setVisible(true);
		depositLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		cancelLabel.setText("Clear - Cancel");
		cancelLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		cancelLabel.setVisible(true);
		cancelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		top.add(LabelOne);
		top.add(LabelTwo);
		
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
		bottom.add(withdrawLabel);
		bottom.add(depositLabel);
		bottom.add(cancelLabel);
	}
	
	void withdrawalScreen() {
		clearScreen();
		label20.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label40.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label60.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label80.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label100.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label200.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		label20.setHorizontalAlignment(JLabel.CENTER);
		label40.setHorizontalAlignment(JLabel.CENTER);
		label60.setHorizontalAlignment(JLabel.CENTER);
		label80.setHorizontalAlignment(JLabel.CENTER);
		label100.setHorizontalAlignment(JLabel.CENTER);
		label200.setHorizontalAlignment(JLabel.CENTER);

		LabelOne.setText("Please select an amount");
		LabelOne.setVisible(true);
		top.add(LabelOne);
		
		label20.setVisible(true);
		label40.setVisible(true);
		label60.setVisible(true);
		label80.setVisible(true);
		label100.setVisible(true);
		label200.setVisible(true);
		
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
		
		LabelOne.setText("Currently unavailable");
		LabelOne.setVisible(true);
		top.add(LabelOne);
	}
	
	void takeMoneyScreen() {
		clearScreen();
		
		LabelTwo.setText("Please take your money promptly");
		LabelTwo.setVisible(true);
		top.add(LabelTwo);
	}
}