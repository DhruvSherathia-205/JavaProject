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
	
	void transactions() throws IOException
	{
		// @Sukhdeep (780)
		// @Mahima (508)
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
		// @Sukhdeep (780)
		// @Mahima (508)
		//Choose from the available lists
		int userChoice;
		
		//double amount and amount2 for transactions
		double amount, amount2;
		//Open FileOutputStream to write data
				FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\HP\\\\Desktop\\\\MAD_3463_4\\\\Final Project\\\\Bank_System\\\\Client_Data.xlsx");
		
		userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:\n1.Deposit\n2.Withdraw\n3.Display\n4.Transfer Money\n5.Edit Information"));
		switch(userChoice)
		{
			case 1:	// @Sukhdeep (780)
					// @Mahima (508)
					//Deposit - money to deposit
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
			case 2: //@ Swapnil Desai 010
					//Withdraw
					cell = sheet.getRow(row_Number).getCell(7);
					amount2 = (double) cell.getNumericCellValue();
					if(amount2==0)
					{
						JOptionPane.showMessageDialog(null, "Your Account is Empty.");
					}
					else
					{
						amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to withdraw:"));
						if(amount>amount2)
						{
							JOptionPane.showMessageDialog(null, "Please Enter valid amount of money!");
						}
						else
						{
							amount = amount2-amount;
							cell.setCellValue( (Double) amount);
						
							//Save by writing data
							workbook.write(fos);
							JOptionPane.showMessageDialog(null, amount+" has been withdraw from account: "+account_Number);
						}
					}
					fos.close();
					workbook.close();
					break;
			case 3: //@ Swapnil Desai 010
					//Display
					int acc_no;
					String fname,lname,address,occupation,account_Type,date_Of_Birth;
					java.util.Date date;
					double acc_Amount;
					/*//Creation Helper for date formats
					CreationHelper creationHelper = workbook.getCreationHelper();*/
					cell = sheet.getRow(row_Number).getCell(0);
					acc_no = (int) cell.getNumericCellValue();
					cell = sheet.getRow(row_Number).getCell(1);
					fname = (String) cell.getStringCellValue();
					cell = sheet.getRow(row_Number).getCell(2);
					lname = (String) cell.getStringCellValue();
					cell = sheet.getRow(row_Number).getCell(3);
					address = (String) cell.getStringCellValue();
					cell = sheet.getRow(row_Number).getCell(4);
					/*//Set Date of Birth in yyyy-mm-dd format
					CellStyle style = workbook.createCellStyle();
					style.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
					cell.setCellStyle(style);*/
					date = cell.getDateCellValue();
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
					date_Of_Birth = df.format(date);
					cell = sheet.getRow(row_Number).getCell(5);
					occupation = (String) cell.getStringCellValue();
					cell = sheet.getRow(row_Number).getCell(6);
					account_Type = (String) cell.getStringCellValue();
					cell = sheet.getRow(row_Number).getCell(7);
					acc_Amount = (double) cell.getNumericCellValue();
					String printable = "---The Account Details---\n"+"Account Number:"+acc_no+"\nFirst Name:"+fname+"\nLast Name:"+lname+"\nAddress:"+address+"\nDate of Birth:"+date_Of_Birth+"\nOccupation:"+occupation+"\nAccount Type:"+account_Type+"\nAmount:"+acc_Amount;
					JOptionPane.showMessageDialog(null, printable);
					//Save by writing data
					workbook.write(fos);
					fos.close();
					workbook.close();
					break;
			case 4: //@ Swapnil Desai 010
					//Transfer Money
					//Do while to check the accounts
					int coulmnCount = 0,i = 1;
					boolean flag = true;
					int rowCount = sheet.getLastRowNum();
					
					int acc_Number = Integer.parseInt(JOptionPane.showInputDialog("Enter your account number:"));
					
					//Attribute to verify if account exist or not
					int acc_Number2;
					do
					{
						//Check with each row i and column 0 for field account_Number
						cell = sheet.getRow(i).getCell(coulmnCount);
						
						//Convert the field to numeric data
						acc_Number2 = (int) cell.getNumericCellValue();
						
						//Check the numbers
						if(acc_Number == account_Number)
						{
							JOptionPane.showMessageDialog(null, "Account Exists!");
							flag = false;
						}
						i++;
					}while(i<=rowCount && flag == true);
					
					//If the following expression is true then account does not exist
					if(i==rowCount && flag == true)
					{
						JOptionPane.showMessageDialog(null, "Account Does Not Exists!");
						break;
					}
					
					//Transfer the amount to the account
					amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be Transfer:"));
					//Go to the last row
					i = i - 1;
					cell = sheet.getRow(i).getCell(7);
					amount2 = (double) cell.getNumericCellValue();
					amount = amount + amount2;
					cell.setCellValue( (Double) amount);
					
					//Save by writing data
					workbook.write(fos);
					JOptionPane.showMessageDialog(null, amount+" has been transferred to account: "+acc_Number);
					fos.close();
					workbook.close();
					break;
			case 5: //Edit Information				
					//@Malav Patel 213
					//@Dhruv Sherathia 205
					//Variable to store which information to edit
					int choice = Integer.parseInt(JOptionPane.showInputDialog("Which Information you'd like to edit!\n1.First Name\n2.Last Name\n3.Address\4.Date of Birth\n5.Occupation\n6.Stop"));
					do
					{
						switch(choice)
						{
							case 1: //Edit First Name
									//@Malav Patel 213
									String new_name = JOptionPane.showInputDialog("Enter the new first name:");
									cell = sheet.getRow(row_Number).getCell(1);
									cell.setCellValue(new_name);
									//Save by writing data
									workbook.write(fos);
									fos.close();
									workbook.close();
									break;
							case 2: //Edit Last Name
									//@Malav Patel 213
									String new_last = JOptionPane.showInputDialog("Enter the new last name:");
									cell = sheet.getRow(row_Number).getCell(2);
									cell.setCellValue(new_last);
									//Save by writing data
									workbook.write(fos);
									fos.close();
									workbook.close();
									break;
							case 3: //Edit Address
									//@Dhruv Sherathia 205
									String new_address = JOptionPane.showInputDialog("Enter the new Address:");
									cell = sheet.getRow(row_Number).getCell(3);
									cell.setCellValue(new_address);
									//Save by writing data
									workbook.write(fos);
									fos.close();
									workbook.close();
									break;

							case 4: //Edit birth date
									//@Swapnil Desai 010
									//@Malav Patel 213
									//@Dhruv Sherathia 205
									cell = sheet.getRow(row_Number).getCell(4);
									java.util.Date old_date = cell.getDateCellValue();
									DateFormat new_df = new SimpleDateFormat("yyyy/MM/dd");
									String new_date = new_df.format(old_date);
									java.sql.Date new_Date_Of_Birth = java.sql.Date.valueOf(new_date);
									//Set Date of Birth in yyyy-mm-dd format
									//Creation Helper for date formats
									cell.setCellValue(new_Date_Of_Birth);
									CreationHelper creationHelper = workbook.getCreationHelper();
									CellStyle style = workbook.createCellStyle();
									style.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
									cell.setCellStyle(style);
									//Save by writing data
									workbook.write(fos);
									fos.close();
									workbook.close();
									break;
							case 5: //Edit Occupation
									//@Dhruv Sherathia 205
									String new_occupation = JOptionPane.showInputDialog("Enter the new occupation:");
									cell = sheet.getRow(row_Number).getCell(5);
									cell.setCellValue(new_occupation);
									//Save by writing data
									workbook.write(fos);
									fos.close();
									workbook.close();
									break;		
									
							default:break;
						}
						
					}while(choice!=6);
					
		}
	}
}

	