package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CourseRepo implements ICourseRepo
{
	DatabaseConnection dbc;
	
	public CourseRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Course e)
	{
		String query = "INSERT INTO course VALUES ('"+e.getCourseId()+"','"+e.getCourseName()+"','"+e.getCourseFee()+"','"+e.getDuration()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	/*public void deleteFromDB(String empId)
	{
		String query = "DELETE from employee WHERE empId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Employee e)
	{
		String query = "UPDATE employee SET name='"+e.getName()+"', designation = '"+e.getDesignation()+"', salary = "+e.getSalary()+"  WHERE empId='"+e.getEmpId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}*/
	public Course searchCourse(String courseId)
	{
		Course emp = null;
		String query = "SELECT `courseName`, `courseFee`, `duration` FROM `course` WHERE `courseId`='"+courseId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String courseName = dbc.result.getString("courseName");
				double courseFee = dbc.result.getDouble("courseFee");
				String duration = dbc.result.getString("duration");
				
				
				emp = new Course();
				emp.setCourseId(courseId);
				emp.setCourseName(courseName);
				emp.setCourseFee(courseFee);
				emp.setDuration(duration);
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllCourse()
	{
		ArrayList<Course> ar = new ArrayList<Course>();
		String query = "SELECT * FROM course;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String courseId = dbc.result.getString("courseId");
				String courseName = dbc.result.getString("coursename");
				double courseFee = dbc.result.getDouble("courseFee");
				String duration = dbc.result.getString("duration");
				
			
				
				Course e = new Course(courseId,courseName,courseFee,duration);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Course)obj[i]).getCourseId();
			data[i][1] = ((Course)obj[i]).getCourseName();
			data[i][2] = (((Course)obj[i]).getCourseFee())+"";
			data[i][3] = ((Course)obj[i]).getDuration();
			
		}
		return data;
	}
}

