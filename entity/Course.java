package entity;

import java.lang.*;

public class Course
{
	private String courseId;
	private String courseName;
	private double courseFee;
	private String duration;
	
	
	public Course(){}
	public Course(String courseId, String courseName, double courseFee, String duration)
	{
		this.courseId = courseId;
		this.courseName=courseName;
		this.courseFee=courseFee;
		this.duration=duration;
	}
	
	public void setCourseId(String courseId){this.courseId = courseId;}
	public void setCourseName(String courseName){this.courseName = courseName;}
	public void setCourseFee(double courseFee){this.courseFee = courseFee;}
	public void setDuration(String duration){this.duration = duration;}
	
	
	public String getCourseId(){return courseId;}
	public String getCourseName(){return courseName;}
	public double getCourseFee() {return courseFee;}
	public String getDuration() {return duration;}
}