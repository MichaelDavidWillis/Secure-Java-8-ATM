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
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
* {@code ATMFrame} class represents the GUI JFrame of the ATM object. 
*
* @version 0.3
* @author Michael David Willis
*/

abstract class ATMFrame extends JFrame {
	
	public ATMFrame() {
		super();
		this.setResizable(false);
		this.getContentPane().setBackground(Color.darkGray);
		this.setSize(400, 500);
		
		this.setLayout(null);
		this.setVisible(true);
		
		this.setIconImage(new ImageIcon("images/atm-logo.png").getImage());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void addToFrame(Component c) {
		this.add(c);
		this.setVisible(true);
		this.repaint();
	}
	
	void removeActionListeners(JButton button) {
		for (ActionListener al : button.getActionListeners()) {
			button.removeActionListener(al);
		}
	}
	
	
	
	
}
