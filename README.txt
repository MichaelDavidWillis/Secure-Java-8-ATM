This is a work in early progress and I hope to expand much of what I have done so far.

version 0.1 -
	- Only Withdrawals are fully implemented with information being printed to console.
	- Only one Credit Card able to be used which is automatically entered on pushing the 
	button located at the Cardreader panel, PIN for credit card is 1111.
	
version 0.2 -
	- fixed "trailing else" problem in ATM.java before calls to the "returnCard()" method.
	- cleaned up code for button initialization in the Keypad class.
	- Simulating reclaiming cash if it is not taken by the user
		- when cash is dispensed a 10 second timer starts, the dispenser will turn red and 
	  	  will need to be clicked to take cash. When the timer is up, if the dispenser has
	  	  not been clicked, the cash will be deposited back into the user's account as
	  	  unavailable money, until verification of the deposit box.
	- new prompt screen to prompt user to take money on dispensation.