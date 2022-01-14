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

package user;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import common.PanelHelper;

/**
* {@code WalletFrame} class represents the GUI JFrame of the Wallet object.
*
* @version 0.4
* @author Michael David Willis
*/

class WalletFrame  extends JFrame implements PanelHelper {

	static JPanel cashPanel = new JPanel();
	static JPanel cardsPanel = new JPanel();
	static JPanel buttonsPanel = new JPanel();
	
	GridLayout layout = new GridLayout(3, 0);
	
	WalletFrame() {
		super("User Wallet");
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(100, 80, 20));
		this.setSize(500, 300);
		
		this.setLayout(null);
		this.setVisible(true);
		
		this.setIconImage(new ImageIcon("images/atm-logo.png").getImage());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
