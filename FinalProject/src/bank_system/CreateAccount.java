/**
 * 
 */
package bank_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author MALAV PATEL 213
 *
 */
public class CreateAccount {

	/**
	 * @param args
	 */
	//@Malav Patel 213
	//Class Variables 
		int account_Number;
		String first_Name;
		String last_Name;
		String address;
		Date date_Of_Birth;
		String occupation;
		String account_Type;
		double account_Balance;
		//@Malav Patel 213
		//getter and setter methods
		public int getaccount_Number() 
		{
			return account_Number;
		}
		public void setaccount_Number(int account_Number)
		{
			this.account_Number = account_Number;
		}
		public String getfirst_Name()
		{
			return first_Name;
		}
		public void setfirst_Name(String first_Name)
		{
			this.first_Name = first_Name;
		}
		public String getlast_Name()
		{
			return last_Name;
		}
		public void setlast_Name(String last_Name)
		{
			this.last_Name = last_Name;
		}
		public String getaddress()
		{
			return address;
		}
		public void setaddress(String address)
		{
			this.address = address;
		}
		public Date getdate_Of_Birth()
		{
			return date_Of_Birth;
		}
		public void setdate_Of_Birth(Date date_Of_Birth)
		{
			this.date_Of_Birth = date_Of_Birth;
		}
		public String getoccupation()
		{
			return occupation;
		}
		public void setoccupation(String occupation)
		{
			this.occupation = occupation;
		}
		public String getaccount_Type()
		{
			return account_Type;
		}
		public void setaccount_Type(String account_Type)
		{
			this.account_Type = account_Type;
		}
		public double getaccount_Balance()
		{
			return account_Balance;
		}
		public void setaccount_Balance(double account_Balance)
		{
			this.account_Balance = account_Balance;
		}
		
		//Create Account Method
		public void create_Account() throws IOException
		{
			//@sukhdeep shabla-729 
			//Create Account and Store files
			Random R = new Random();
			first_Name = JOptionPane.showInputDialog("Enter your First name:");
			last_Name = JOptionPane.showInputDialog("Enter your Last name:");
			address = JOptionPane.showInputDialog("Enter your address:");
			date_Of_Birth = Date.valueOf(JOptionPane.showInputDialog("Enter date of birth in yyyy-mm-dd format:"));
			occupation = JOptionPane.showInputDialog("Enter your occupation:");
			account_Type = JOptionPane.showInputDialog("Select Account type:\n1. Savings\n2. Checking\n3. Money Market:");
			account_Number = R.nextInt(Integer.MAX_VALUE);
			account_Balance = 0;
					
			//Use of Set Methods
			setaccount_Number(account_Number);
			setfirst_Name(first_Name);
			setlast_Name(last_Name);
			setaddress(address);
			setdate_Of_Birth(date_Of_Birth);
			setoccupation(occupation);
			setaccount_Type(account_Type);
			
			//@mahima mulani-508

			//Write those data into Excel file
			//Create a file object with file path of existing Excel file as parameter
			//Note:- Change path according to your convenience and put given "Client_Data.xlsx" file in that path's folder. Lastly keep the path same in all class files!
			File file = new File("C:\\Users\\HP\\Desktop\\MAD_3463_4\\Final Project\\Bank_System\\Client_Data.xlsx");
			
			//Create FileInputStream object to get the information of the file
			FileInputStream fip = new FileInputStream(file);
			
			//Get the workbook instance for XLSX file
			XSSFWorkbook workbook = new XSSFWorkbook(fip);
			
			//Ensure if file exists or not!
			if(file.isFile() && file.exists())
			{
				System.out.println("Client_Data.xslx exists and opened.");
			}
			
			//Open Sheet 0
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//Get the last Row count
			int rowCount = sheet.getLastRowNum();
			
			//create a row
			XSSFRow row = sheet.createRow(++rowCount);
			
			//Set column to 0
			int coulmnCount = 0;
			
			//Create Cell
			XSSFCell cell;
			
			//Creation Helper for date formats
			CreationHelper creationHelper = workbook.getCreationHelper();
			
			//Add Each values into cell
			cell = row.createCell(coulmnCount);
			cell.setCellValue((Integer) account_Number);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((String) first_Name);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((String) last_Name);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((String) address);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue( date_Of_Birth);
			
			//Set Date of Birth in yyyy-mm-dd format
			CellStyle style = workbook.createCellStyle();
			style.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
			cell.setCellStyle(style);
			
			//Continue to write other fields
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((String) occupation);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((String) account_Type);
			cell = row.createCell(++coulmnCount);
			cell.setCellValue((Double) account_Balance);
			
			//Close input stream
			fip.close();
			
			//Open FileOutputStream to write data
			//Note:- Change path according to your convenience and put given "Client_Data.xlsx" file in that path's folder. Lastly keep the path same in all class files!
			FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\HP\\\\Desktop\\\\MAD_3463_4\\\\Final Project\\\\Bank_System\\\\Client_Data.xlsx");
			workbook.write(fos);
			
			//close output stream and workbook
			fos.close();
			workbook.close();
			System.out.println("File Written Successfully");
		}
	
}
	