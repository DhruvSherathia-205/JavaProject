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
 * @author MALAV PATEL
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
		///getter and setter methods
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
			//Create Account and Store files
		}
	}