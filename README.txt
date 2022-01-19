This is a work in progress and I hope to expand much of what I have done so far.

This app launches 2 JFrames, one to display a simulated ATM and another to simulate
a User's Wallet.
Currently the Wallet only has 2 Credit Cards (Red - pin = 1111 & Blue - pin = 2222).
Users can select which card to use and access the appropriate account.

Public classes of packages :
	atm 	- 	ATM.java
	bank 	- 	Bank.java
	common 	- 	all .java files
	user 	- 	Wallet.java

----------------------------------------------------------------------------------------------------

I later plan to :
	- implement a means of storing and depositing money to and from the
		ATM and Wallet objects.
	- More Cards with the ability to add Cards from a Bank Frame.
	- A Bank Frame to add new accounts and create new Cards.
	- Improve security (PIN handling, hashCodes, exception handling).
	- All logging to be done to files stored in program folders rather than just to console.
	- Documentation comments with proper tags of params and returns for each method.
	- Once I am happy with the app I intend to migrate to Java 9, introducing modules, with
		further migrations to Java 11 and Java 16 to follow.

----------------------------------------------------------------------------------------------------

version 0.5 -
	- Language selection implemented, current options - English, Welsh.
	- static JLabels in Screen class made non-static.

version 0.4 - 
	- Taken many "hard-coded" strings out of the program into .properties files, with
		resource bundles being used to better implement language conversion later.
	- General code clean up, in the Screen class in particular.
	- User Wallet JFrame added to choose between cards and later store bank notes.
	- User Wallet JFrame now handles the exiting of the program instead of the ATM Frame.
	- CreditCard class moved to package common.
	- Added to package atm :
		- ATMLogger - handles all ATM logging, currently simply printing to console.
		- ScreenBase - initiates and holds elements used by the Screen object.
		- resources - folder to hold property files used by the ATM.
	- Added to package common :
		- Note - Abstract class representing a bank note.
		- NoteTen - representing a £10 bank note.
		- NoteTwenty - representing a £20 bank note.
		- PanelHelper - interface with simple helper methods to handle JPanels.
	- Added to package user :
		- WalletFrame - similar to the ATMFrame class
		- Wallet - represents a User's Wallet that can be interacted with to select a 
			Card to use on an ATM.
		- CardSelector - interface to extend MouseListener interface.
		- CardHolder - represents 3 card slots to store Cards.
		- CardSlot - represents a wallet card slot that can store one card. 
		- NoteHolder - represents a wallet note holder to store bank notes.

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
