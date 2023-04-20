package entity;

import java.lang.*;

public class Student
{
	private String studentId;
	private String studentName;
	private String courseName;
	private String courseId;
	
	
	public Student(){}
	public Student(String studentId, String studentName, String courseId, String courseName)
	{
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		
	}
	
	public void setStudentId(String studentId){this.studentId = studentId;}
	public void setStudentName(String studentName){this.studentName = studentName;}
	public void setCourseName(String courseName){this.courseName = courseName;}
	public void setCourseId(String courseId){this.courseId = courseId;}
     
	 
	 
	public String getStudentId(){return studentId ;}
	public String getStudentName(){return studentName ;}
	public String getCourseName(){return courseName;}
	public String getCourseId(){return courseId = courseId;}
	
	
}