package atm;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
* {@code ATMLogger} class represents an object that handles all logging for an
* {@code ATM} object.
*
* @version 0.4
* @author Michael David Willis
*/

class ATMLogger {
	static ResourceBundle Logging = ResourceBundle.getBundle("atm.resources.logging");
	
	static void log(String toLog) {
		try {
			System.out.println(Logging.getString(toLog));
		} catch (Exception e) {
			System.out.println(Logging.getString("error"));
		}
	}
	
	static void log(String toLog, String format) {
		try {
			System.out.println(MessageFormat.format(Logging.getString(toLog), format));
		} catch (Exception e) {
			System.out.println(Logging.getString("error"));
		}
	}
}
