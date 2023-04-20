package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StudentFrame extends JFrame implements ActionListener
{
	private JLabel stdIdLabel, stdNameLabel, crsNameLabel, crsIdLabel;
	private JTextField stdIdTF, stdNameTF, crsNameTF, crsIdTF;
	private JButton loadBtn, insertBtn,updateBtn, refreshBtn, getAllBtn, backBtn,logoutBtn;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;
	
	private User user;
	private StudentRepo er;
	
	
	
	public StudentFrame(User user)
	{
		super("StudentFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new StudentRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"studentId", "studentName", "courseName", "courseId"};
		
		stdTable = new JTable(data,head);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(350, 100, 400, 150);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		
		stdIdLabel = new JLabel("SID :");
		stdIdLabel.setBounds(100,100,100,30);
		panel.add(stdIdLabel);
		
		stdIdTF = new JTextField();
		stdIdTF.setBounds(220,100,100,30);
		panel.add(stdIdTF);
		
		stdNameLabel = new JLabel("SName :");
		stdNameLabel.setBounds(100,150,100,30);
		panel.add(stdNameLabel);
		
		stdNameTF = new JTextField();
		stdNameTF.setBounds(220,150,100,30);
		panel.add(stdNameTF);
		
		crsIdLabel = new JLabel("CID: ");
		crsIdLabel.setBounds(100,200,100,30);
		panel.add(crsIdLabel);
		
		crsIdTF = new JTextField();
		crsIdTF.setBounds(220,200,100,30);
		panel.add(crsIdTF);
		
		crsNameLabel = new JLabel("CNAME: ");
		crsNameLabel.setBounds(100,250,100,30);
		panel.add(crsNameLabel);
		
		crsNameTF = new JTextField();
		crsNameTF.setBounds(220,250,100,30);
		panel.add(crsNameTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(700, 350, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!stdIdTF.getText().equals("") || !stdIdTF.getText().equals(null))
			{
				Student e = er.searchStudent(stdIdTF.getText());
				if(e!= null)
				{
					stdNameTF.setText(e.getStudentName());
					crsIdTF.setText(e.getCourseId());
					crsNameTF.setText(e.getCourseName());
					
					stdIdTF.setEnabled(false);
					stdNameTF.setEnabled(true);
					crsIdTF.setEnabled(false);
					crsNameTF.setEnabled(false);
					
					
					refreshBtn.setEnabled(true);
					updateBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Student e = new Student();
			CourseRepo yr = new CourseRepo();
			Course course = yr.searchCourse(crsIdTF.getText());
			User u = new User();
			UserRepo ur = new UserRepo();
			if(course !=null){
			try{
			
		
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			int y = rd.nextInt(99999)+10000;
			try{
			
			e.setStudentId(y+"");
			e.setStudentName(stdNameTF.getText());
			e.setCourseId(crsIdTF.getText());
			e.setCourseName(crsNameTF.getText());
			
			u.setUserId(y+"");
			u.setPassword(x+"");
			
			
			
				u.setStatus(2);
			
			
			
			er.insertInDB(e);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+y+"and Password: "+x);
			}
			catch(Exception ro)
			{
			    JOptionPane.showMessageDialog(this, "operation halted");
			}
			stdIdTF.setText("");
			stdNameTF.setText("");
			crsIdTF.setText("");
			crsNameTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		catch(Exception ro)
		{
			JOptionPane.showMessageDialog(this, "operation halted");
		}
			}
		
		else{
			JOptionPane.showMessageDialog(this, "Course Not Found");
		}
		
		
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			stdIdTF.setText("");
			stdNameTF.setText("");
			crsIdTF.setText("");
			crsNameTF.setText("");
			
			stdIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			refreshBtn.setEnabled(false);
			updateBtn.setEnabled(false);
		}
		
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllStudent();
			String head[] = {"studentId", "studentName", "courseName", "courseId"};
			
			panel.remove(stdTableSP);
			
			stdTable = new JTable(data,head);
			stdTable.setEnabled(false);
			stdTableSP = new JScrollPane(stdTable);
			stdTableSP.setBounds(350, 100, 400, 150);
			panel.add(stdTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame eh = new LoginFrame();
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}
