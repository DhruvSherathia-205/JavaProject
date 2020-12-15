/**
 * 
 */
package bank_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Swapnil Desai 010
 *
 */
public class Transactions 
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings({ "resource" })
	void transactions()
	{
		//2.Perform Transactions
		//Verify your account first
		//Create File Instance
		
	}
	void operations()
	{

		
		//Choose from the available lists
		int userChoice;
		
		//double amount and amount2 for transactions
		double amount, amount2;
		
		userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:\n1.Deposit\n2.Withdraw\n3.Display\n4.Transfer Money\n5.Edit Information"));
		switch(userChoice)
		{
			case 1: //Deposit - money to deposit
					break;
			case 2: //Withdraw
					break;
			case 3: //Display
					break;
			case 4: //Transfer Money
					break;
			case 5: //Edit Information
		}
	}
}