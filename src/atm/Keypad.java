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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class Keypad {
	private String userinput = "";
	public final JButton B1 = new JButton("1");
	public final JButton B2 = new JButton("2");
	public final JButton B3 = new JButton("3");
	public final JButton B4 = new JButton("4");
	public final JButton B5 = new JButton("5");
	public final JButton B6 = new JButton("6");
	public final JButton B7 = new JButton("7");
	public final JButton B8 = new JButton("8");
	public final JButton B9 = new JButton("9");
	public final JButton B0 = new JButton("0");
	public final JButton BClear = new JButton("Clear");
	public final JButton BEnter = new JButton("Enter");
	BCheck BC = new BCheck();
	BClear BC1 = new BClear();

	JPanel addkeypad() {
		JPanel panel = new JPanel();
		panel.setSize(160, 160);
		panel.setLocation(50, 190);
		panel.setBackground(Color.gray);
		panel.setLayout(new FlowLayout());
		panel.add(B1);
		panel.add(B2);
		panel.add(B3);
		panel.add(B4);
		panel.add(B5);
		panel.add(B6);
		panel.add(B7);
		panel.add(B8);
		panel.add(B9);
		panel.add(BClear);
		panel.add(B0);
		panel.add(BEnter);

		return panel;
	}
		
	void addkeypadlisteners() {
		this.B1.addActionListener(BC);
		this.B2.addActionListener(BC);
		this.B3.addActionListener(BC);
		this.B4.addActionListener(BC);
		this.B5.addActionListener(BC);
		this.B6.addActionListener(BC);
		this.B7.addActionListener(BC);
		this.B8.addActionListener(BC);
		this.B9.addActionListener(BC);
		this.B0.addActionListener(BC);
		this.BClear.addActionListener(BC1);
	}
	
	void clearkeypadlisteners() {
		this.B1.removeActionListener(BC);
		this.B2.removeActionListener(BC);
		this.B3.removeActionListener(BC);
		this.B4.removeActionListener(BC);
		this.B5.removeActionListener(BC);
		this.B6.removeActionListener(BC);
		this.B7.removeActionListener(BC);
		this.B8.removeActionListener(BC);
		this.B9.removeActionListener(BC);
		this.B0.removeActionListener(BC);
		this.BClear.removeActionListener(BC1);
	}

	String userinput() {
		return userinput;
	}

	void resetuserinput() {
		userinput = "";
	}
	
	class BCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			userinput += b.getText();
			
			System.out.println("button " + userinput);
			
			// update the text field using the user's input.
			Screen.Inputfield.setText(userinput);
			Screen.Inputfield.repaint();

		}
	}

	class BClear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Clear the input field.
			userinput = "";
			Screen.Inputfield.setText(userinput);
		}
	}
}
