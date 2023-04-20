package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class PurchaseFrame extends JFrame implements ActionListener
{
	private JLabel pIdLabel, cIdLabel, stdIdLabel, stdNameLabel, amountLabel;
	private JTextField pIdTF, cIdTF, stdIdTF, stdNameTF, amountTF;
	private JButton loadBtn, insertBtn, updateBtn, refreshBtn, getAllBtn, backBtn,logoutBtn;
	private JPanel panel;
	private JTable pTable;
	private JScrollPane pTableSP;
	
	//private User user;
	private PurchaseRepo er;
	
	
	public PurchaseFrame()
	{
		super("PurchaseFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.user = user;
		
		er = new PurchaseRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"pId", "courseId", "studentId", "studentName", "amount"};
		
		pTable = new JTable(data,head);
		pTableSP = new JScrollPane(pTable);
		pTableSP.setBounds(350, 100, 400, 150);
		pTable.setEnabled(false);
		panel.add(pTableSP);
		
		pIdLabel = new JLabel("PID :");
		pIdLabel.setBounds(100,100,100,30);
		panel.add(pIdLabel);
		
		pIdTF = new JTextField();
		pIdTF.setBounds(220,100,100,30);
		panel.add(pIdTF);
		
		cIdLabel = new JLabel("CID :");
		cIdLabel.setBounds(100,150,100,30);
		panel.add(cIdLabel);
		
		cIdTF = new JTextField();
		stdIdTF.setBounds(220,150,100,30);
		panel.add(stdIdTF);
		
		stdIdLabel = new JLabel("SID: ");
		stdIdLabel.setBounds(100,200,100,30);
		panel.add(stdIdLabel);
		
		stdIdTF = new JTextField();
		stdIdTF.setBounds(220,200,100,30);
		panel.add(stdIdTF);
		
		stdNameLabel = new JLabel("SName: ");
		stdNameLabel.setBounds(100,250,100,30);
		panel.add(stdNameLabel);
		
		stdNameTF = new JTextField();
		stdNameTF.setBounds(220,250,100,30);
		panel.add(stdNameTF);
		
		amountLabel = new JLabel("Amount: ");
		amountLabel.setBounds(100,300,100,30);
		panel.add(amountLabel);
		
		amountTF = new JTextField();
		amountTF.setBounds(220,300,100,30);
		panel.add(amountTF);
		
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
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
          try{
		if(command.equals(loadBtn.getText()))
		{   try{
			if(!pIdTF.getText().equals("") || !pIdTF.getText().equals(null))
			{
				Purchase e = er.searchPurchase(pIdTF.getText());
				if(e!= null)
				{
					cIdTF.setText(e.getCourseId());
					stdIdTF.setText(e.getStudentId());
					stdNameTF.setText(e.getStudentName());
					amountTF.setText(e.getAmount()+"");
					
					
					pIdTF.setEnabled(false);
					cIdTF.setEnabled(true);
					stdIdTF.setEnabled(true);
					stdNameTF.setEnabled(true);
					amountTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
		}}
		catch(Exception ax)
		{
		}
		}
		
	
		else if(command.equals(insertBtn.getText()))
		{
			Purchase p = new Purchase();
			CourseRepo yr = new CourseRepo();
			Course course = yr.searchCourse(cIdTF.getText());
			StudentRepo ur = new StudentRepo();
			Student e = ur.searchStudent(stdIdTF.getText());
			if(course !=null && e != null){
			try{
			try{
			
			p.setPurchaseId(pIdTF.getText());
			p.setCourseId(cIdTF.getText());
			p.setStudentId(stdIdTF.getText());
			p.setStudentName(stdNameTF.getText());
			p.setAmount(Double.parseDouble(amountTF.getText()));
			
	
			er.insertInDB(p);
			
			JOptionPane.showMessageDialog(this, "Inserted");
			}
			catch(Exception ro)
			{
			    JOptionPane.showMessageDialog(this, "operation halted");
			}
			pIdTF.setText("");
			cIdTF.setText("");
			stdIdTF.setText("");
			stdNameTF.setText("");
			amountTF.setText("");
			
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
			JOptionPane.showMessageDialog(this, "Course or Student Not Found");
		}
		
		
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			pIdTF.setText("");
			cIdTF.setText("");
			stdIdTF.setText("");
			stdNameTF.setText("");
			amountTF.setText("");
			
			pIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Purchase e = new Purchase();
			
			try{
			e.setPurchaseId(pIdTF.getText());
			e.setCourseId(cIdTF.getText());
			e.setStudentId(stdIdTF.getText());
			e.setStudentName(stdNameTF.getText());
			e.setAmount(Double.parseDouble(amountTF.getText()));
			
			
			er.updateInDB(e);
			
			
			JOptionPane.showMessageDialog(this, "Updated");
			}
			catch(Exception ro)
			{
				JOptionPane.showMessageDialog(this, "operation halted");
			}
			
			pIdTF.setText("");
			cIdTF.setText("");
			stdIdTF.setText("");
			stdNameTF.setText("");
			amountTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			pIdTF.setEnabled(true);
			cIdTF.setEnabled(true);
			stdIdTF.setEnabled(true);
			stdNameTF.setEnabled(true);
			amountTF.setEnabled(true);
		}
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllPurchase();
			String head[] = {"pId", "courseId", "studentId", "studentName", "amount"};
			
			panel.remove(pTableSP);
			
			pTable = new JTable(data,head);
			pTable.setEnabled(false);
			pTableSP = new JScrollPane(pTable);
			pTableSP.setBounds(350, 100, 400, 150);
			panel.add(pTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		/*else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}*/
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame eh = new LoginFrame();
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		  }
		  
		  catch(Exception ax)
		  {
			  
		  }
		
	}
}