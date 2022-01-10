This is a work in early progress and I hope to expand much of what I have done so far.
To access the account enter the pin 1111, I later intend to have a user wallet with 
several cards and money for depositing.

version 0.3 -
	- major code clean up and divided the code to make it more readable and modifiable.
	- Authenticator class moved from package atm to package bank.
	- several new classes added:
		- package atm:
			- ATMFrame - handles JFrame initialization.
			- KeypadListeners - handles ActionListeners on keypad buttons.
		- package bank:
			- Bank - handles calls to and from ATM objects.
			- TransactionOperations - handles operations of transactions and changes to accounts.
		- package common:
			- ReadOnlyAccount - an immutable object sent to ATM to display account information.
	- Interface KeypadButtons added to store the keypad JButton objects.
	
version 0.2 -
	- fixed "trailing else" problem in ATM.java before calls to the "returnCard()" method.
	- cleaned up code for button initialization in the Keypad class.
	- Simulating reclaiming cash if it is not taken by the user:
		- when cash is dispensed a 10 second timer starts, the dispenser will turn red and 
	  	  will need to be clicked to take cash. When the timer is up, if the dispenser has
	  	  not been clicked, the cash will be deposited back into the user's account as
	  	  unavailable money, until verification of the deposit box.
	- new prompt screen to prompt user to take money on dispensation.

version 0.1 -
	- Only Withdrawals are fully implemented with information being printed to console.
	- Only one Credit Card able to be used which is automatically entered on pushing the 
	button located at the Cardreader panel, PIN for credit card is 1111.
