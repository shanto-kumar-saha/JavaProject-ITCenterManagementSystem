package interfaces;

import java.lang.*;

import entity.*;

public interface ICourseRepo
{
	public void insertInDB(Course c);
	public Course searchCourse(String courseId);
	public Object[][] getAllCourse();
}