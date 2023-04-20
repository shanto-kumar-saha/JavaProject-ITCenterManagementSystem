package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PurchaseRepo implements IPurchaseRepo
{
	DatabaseConnection dbc;
	
	public PurchaseRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Purchase e)
	{
		String query = "INSERT INTO purchase VALUES ('"+e.getPurchaseId()+"','"+e.getCourseId()+"','"+e.getStudentId()+"','"+e.getStudentName()+"', "+e.getAmount()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateInDB(Purchase e)
	{
		String query = "UPDATE purchase SET courseId ='"+e.getCourseId()+"', studentId = '"+e.getStudentId()+"', studentName = '"+e.getStudentName()+"', amount = "+e.getAmount()+" WHERE purchaseId='"+e.getPurchaseId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Purchase searchPurchase(String purchaseId)
	{
		Purchase emp = null;
		String query = "SELECT `courseId`, `studentId`, `studentName`,`amount` FROM `purchase` WHERE `purchaseId`='"+purchaseId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String courseId = dbc.result.getString("courseId");
				String studentId = dbc.result.getString("studentId");
				String studentName = dbc.result.getString("studentName");
				double amount = dbc.result.getDouble("amount");
				
				
				emp = new Purchase();
				emp.setPurchaseId(purchaseId);
				emp.setCourseId(courseId);
				emp.setStudentId(studentId);
				emp.setStudentName(studentName);
				emp.setAmount(amount);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllPurchase()
	{
		ArrayList<Purchase> ar = new ArrayList<Purchase>();
		String query = "SELECT * FROM Purchase;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String purchaseId = dbc.result.getString("purchaseId");
				String courseId = dbc.result.getString("courseId");
				String studentId = dbc.result.getString("studentId");
				String studentName = dbc.result.getString("studentName");
				double amount = dbc.result.getDouble("amount");
				
				Purchase e = new Purchase(purchaseId,courseId,studentId,studentName,amount);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			
			data[i][0] = ((Purchase)obj[i]).getPurchaseId();
			data[i][1] = ((Purchase)obj[i]).getCourseId();
			data[i][2] = ((Purchase)obj[i]).getStudentId();
			data[i][3] = ((Purchase)obj[i]).getStudentName();
			data[i][4] = (((Purchase)obj[i]).getAmount())+"";
			
		}
		return data;
	}
}




