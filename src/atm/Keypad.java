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

import common.PanelHelper;

/**
* {@code Keypad} class represents the ATM keypad.
*
* @version 0.4
* @author Michael David Willis
*/

class Keypad implements KeypadButtons, PanelHelper {
	private String userinput = "";
	BCheck BC = new BCheck();
	BClear BC1 = new BClear();
	
	final JButton[] allButtons = {B1, B2, B3, B4, B5, B6, B7, B8, B9, BClear, B0, BEnter};

	JPanel addKeypad() {
		JPanel panel = new JPanel();
		panel.setSize(160, 160);
		panel.setLocation(50, 190);
		panel.setBackground(Color.gray);
		panel.setLayout(new FlowLayout());
		for (JButton button : allButtons) {
			panel.add(button);
		}

		return panel;
	}
		
	void addKeypadListeners() {
		for (JButton button : allButtons) {
			
			if 		(button == this.BClear) button.addActionListener(BC1);
			else if (button == this.BEnter) continue;
			else							button.addActionListener(BC);
		}
	}
	
	void removeActionListenersFromAll() {
		for (JButton button : allButtons) {
			removeActionListeners(button);
		}
	}

	String userinput() {
		return userinput;
	}

	void resetUserinput() {
		userinput = "";
	}
	
	class BCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			userinput += b.getText();
			
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
