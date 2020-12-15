/**
 * 
 */
package bank_system;



//public class JavaProject {

	/**
	 * @param args
	 */

import java.io.IOException;
import javax.swing.JOptionPane;

	/**
	 * @author Dhruv Sherathia 205
	 *
	 */
	public class Bank_Account 
	{

		/**
		 * @param args
		 * @throws IOException 
		 */
		public static void main(String[] args) throws IOException 
		{
			//Provide 2 choices
			//1. Create Account
			//2. Use Transactions - deposit, withdraw, display
			//Take user input for operation
			int userChoice;
			do
			{
				userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice\n1.Create Account\n2.Perform Transactions\n3.quit"));
				switch(userChoice)
				{
					//@ Swapnil Desai 010
					case 1: //create account
							break;
					case 2: //perform transactions
							break;
					case 3: //Quit
							break;
					default:
				}
			}while(userChoice!=3);
			//Write Files when account creation
			//read files and locate information for transactions like account_number
			//
		}

	}
