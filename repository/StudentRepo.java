package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class StudentRepo implements IStudentRepo
{
	DatabaseConnection dbc;
	
	public StudentRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Student e)
	{
		String query = "INSERT INTO student VALUES ('"+e.getStudentId()+"','"+e.getStudentName()+"','"+e.getCourseName()+"','"+e.getCourseId()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}

	public void updateInDB(Student e)
	{
		String query = "UPDATE student SET studentName = '"+e.getStudentName()+"', courseName = '"+e.getCourseName()+"', courseId = "+e.getCourseId()+"  WHERE studentId='"+e.getStudentId()+"';"; 
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Student searchStudent(String studentId)
	{
		Student stu = null;
		String query = "SELECT `studentName`, `courseName`, `courseId` FROM `student` WHERE `studentId`='"+studentId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String studentName = dbc.result.getString("studentName");
				String courseName = dbc.result.getString("courseName");
				String courseId = dbc.result.getString("courseId");
				
				
				
				
				stu = new Student();
				stu.setStudentId(studentId);
				stu.setStudentName(studentName);
				stu.setCourseId(courseId);
				stu.setCourseName(courseName);
				
			
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return stu;
	}
	public String[][] getAllStudent()
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		String query = "SELECT * FROM student;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String studentId = dbc.result.getString("studentId");
				String studentName = dbc.result.getString("studentName");
				String courseName= dbc.result.getString("courseName");
				String courseId= dbc.result.getString("courseId");
				
			
				
				Student e = new Student(studentId,studentName,courseId,courseName);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Student)obj[i]).getStudentId();
			data[i][1] = ((Student)obj[i]).getStudentName();
			data[i][2] = (((Student)obj[i]).getCourseName());
			data[i][3] = ((Student)obj[i]).getCourseId();
			
			
		}
		return data;
	}
}