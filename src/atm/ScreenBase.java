package atm;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* {@code ScreenBase} class represents an object that extends {@code JPanel}
* and meant to be extended by a {@code Screen} object and handles the basic
* operations needed to display information to the user.
*
* @version 0.4
* @author Michael David Willis
*/

class ScreenBase extends JPanel {

	Locale locale = new Locale("en", "GB");
	ResourceBundle messages = ResourceBundle.getBundle("atm.resources.messages", locale);
	
	JLabel labelOne = new JLabel();
	JLabel labelTwo = new JLabel();
	JLabel labelThree = new JLabel();
	JLabel withdrawLabel = new JLabel();
	JLabel depositLabel = new JLabel();
	JLabel cancelLabel = new JLabel();
	static JTextField Inputfield = new JTextField();

	JLabel label20 = new JLabel();
	JLabel label40 = new JLabel();
	JLabel label60 = new JLabel();
	JLabel label80 = new JLabel();
	JLabel label100 = new JLabel();
	JLabel label200 = new JLabel();
	
	static JPanel top = new JPanel();
	static JPanel bottom = new JPanel();
	
	GridLayout layout = new GridLayout(0, 2);
	
	void createScreen() {
		
		setBounds(50, 20, 285, 150);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Inputfield.setEditable(false);
	}
	
	void addLabel(JLabel label, String text, int position, int size) {
		label.setText(messages.getString(text));
		switch (position) {
		case 1 : 
			label.setAlignmentX(Component.LEFT_ALIGNMENT);
			break;
		case 2 : default:
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			break;
		case 3 : 
			label.setAlignmentX(Component.RIGHT_ALIGNMENT);
			break;
		}
		label.setFont(new Font("Monospaced", Font.PLAIN, size));
		label.setVisible(true);
		repaint();
	}
	
	void addLabel(JLabel label, String text, int position, int size, String format) {
		addLabel(label, text, position, size);
		label.setText(MessageFormat.format(messages.getString(text), format));
	}
	
	void clearScreen() {
		
		labelOne.setText("");
		labelOne.setVisible(false);
		labelTwo.setText("");
		labelTwo.setVisible(false);
		labelThree.setText("");
		labelThree.setVisible(false);
		
		Inputfield.setVisible(false);

		cancelLabel.setText("");
		cancelLabel.setVisible(false);
		depositLabel.setText("");
		depositLabel.setVisible(false);
		withdrawLabel.setText("");
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
}
