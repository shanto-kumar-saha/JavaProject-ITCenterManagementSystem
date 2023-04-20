package entity;

import java.lang.*;

public class Purchase
{
	private String purchaseId;
	private String courseId;
	private String studentId;
	private String studentName;
	private double amount;
	
	
	public Purchase(){}
	public Purchase(String purchaseId, String courseId, String studentId, String studentName, double amount)
	{
		this.purchaseId = purchaseId;
		this.courseId=courseId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.amount=amount;
	}
	
	public void setPurchaseId(String purchaseId){this.purchaseId = purchaseId;}
	public void setCourseId(String courseId){this.courseId = courseId;}
	public void setStudentId(String studentId){this.studentId= studentId;}
	public void setStudentName(String studentName){this.studentName = studentName;}
	public void setAmount(double amount){this.amount = amount;}
	
	
	public String getPurchaseId(){return purchaseId;}
	public String getCourseId(){return courseId;}
	public String getStudentId() {return studentId;}
	public String getStudentName() {return studentName;}
	public double getAmount() {return amount;}
	
}