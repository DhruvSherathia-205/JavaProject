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
	// @Sukhdeep (780)
	// @Mahima (508)
	
	void transactions()
	{
		//2.Perform Transactions
		//Verify your account first
		//Create File Instance

		File file = new File("C:\\Users\\HP\\Desktop\\MAD_3463_4\\Final Project\\Bank_System\\Client_Data.xlsx");
			
		//Obtaining File Input Stream
		FileInputStream fin = new FileInputStream(file);
			
		//Creating a workbook instance of xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//Get the last Row count
		int rowCount = sheet.getLastRowNum();
		
		//Set column to 0
		int coulmnCount = 0;
				
		//Create Cell
		XSSFCell cell;
		
		/*cell = sheet.getRow(1).getCell(1);
		String first_Name = (String) cell.getStringCellValue();
		System.out.println(first_Name);
		cell = sheet.getRow(1).getCell(1);
		first_Name = cell.getStringCellValue();
		System.out.println(first_Name);
		System.out.println(first_Name);
		cell = sheet.getRow(1).getCell(2);
		String last_Name = (String) cell.getStringCellValue();
		System.out.println(last_Name);
		cell = sheet.getRow(1).getCell(3);
		String address = (String) cell.getStringCellValue();
		System.out.println(address);
		cell = sheet.getRow(1).getCell(7);
		double amount2 = (double) cell.getNumericCellValue();
		System.out.println(amount2);*/
		//Take user's account number
		int acc_Number = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number:"));
		
		//Attribute to verify if account exist or not
		int acc_Number2;
		
		
		//Verify that whether the account number is in file or not!
		int i = 1;
		boolean flag = true;
		
		//Do while to check the accounts
		do
		{
			//Check with each row i and column 0 for field account_Number
			cell = sheet.getRow(i).getCell(coulmnCount);
			
			//Convert the field to numeric data
			acc_Number2 = (int) cell.getNumericCellValue();
			
			//Check the numbers
			if(acc_Number2 == acc_Number)
			{
				JOptionPane.showMessageDialog(null, "Account Exists!");
				operations(acc_Number,i,fin,workbook,sheet,cell);
				flag = false;
			}
			i++;
		}while(i<=rowCount && flag == true);
		
		//If the following expression is true then account does not exist
		if(i==rowCount && flag == true)
		{
			JOptionPane.showMessageDialog(null, "Account Does Not Exists!");
		}
		
		//fin and workbook close
		fin.close();
		workbook.close();
	}
	
	void operations(int account_Number, int row_Number, FileInputStream fin, XSSFWorkbook workbook, XSSFSheet sheet, XSSFCell cell) throws IOException
	{
		//Choose from the available lists
		int userChoice;
		
		//double amount and amount2 for transactions
		double amount, amount2;
		//Open FileOutputStream to write data
				FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\HP\\\\Desktop\\\\MAD_3463_4\\\\Final Project\\\\Bank_System\\\\Client_Data.xlsx");
		
		userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:\n1.Deposit\n2.Withdraw\n3.Display\n4.Transfer Money\n5.Edit Information"));
		switch(userChoice)
		{
		case 1: //Deposit - money to deposit
			amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be deposit:"));
			cell = sheet.getRow(row_Number).getCell(7);
			amount2 = (double) cell.getNumericCellValue();
			amount = amount + amount2;
			cell.setCellValue( (Double) amount);
			
			//Save by writing data
			workbook.write(fos);
			JOptionPane.showMessageDialog(null, amount+" has been deposited to account: "+account_Number);
			fos.close();
			workbook.close();
			break;
	case 2: //Withdraw
			break;
	case 3: //Display
			break;
	case 4: //Transfer Money
			break;
	case 5: //Edit Information		}
	}
	}
}

	