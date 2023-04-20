package interfaces;

import java.lang.*;

import entity.*;

public interface IStudentRepo
{
	public void insertInDB(Student e);
	//public void deleteFromDB(String studentId);
	public void updateInDB(Student e);
	public Student searchStudent(String studentId);
	public String[][] getAllStudent();
}