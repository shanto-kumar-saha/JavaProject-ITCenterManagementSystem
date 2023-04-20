package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CourseFrame extends JFrame implements ActionListener
{
	private JLabel crsIdLabel, crsNameLabel, crsFeeLabel, crsdurationLabel;
	private JTextField crsIdTF, crsNameTF, crsFeeTF, crsdurationTF;
	private JButton loadBtn, insertBtn, refreshBtn, getAllBtn, backBtn,logoutBtn;
	private JPanel panel;
	private JTable crsTable;
	private JScrollPane crsTableSP;
	
	private User user;
	private CourseRepo er;
	
	
	
	public CourseFrame(User user)
	{
		super("CourseFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new CourseRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"courseId", "courseName", "courseFee", "duration"};
		
		crsTable = new JTable(data,head);
		crsTableSP = new JScrollPane(crsTable);
		crsTableSP.setBounds(350, 100, 400, 150);
		crsTable.setEnabled(false);
		panel.add(crsTableSP);
		
		crsIdLabel = new JLabel("ID :");
		crsIdLabel.setBounds(100,100,100,30);
		panel.add(crsIdLabel);
		
		crsIdTF = new JTextField();
		crsIdTF.setBounds(220,100,100,30);
		panel.add(crsIdTF);
		
		crsNameLabel = new JLabel("Name :");
		crsNameLabel.setBounds(100,150,100,30);
		panel.add(crsNameLabel);
		
		crsNameTF = new JTextField();
		crsNameTF.setBounds(220,150,100,30);
		panel.add(crsNameTF);
		
		crsFeeLabel = new JLabel("Fee: ");
		crsFeeLabel.setBounds(100,200,100,30);
		panel.add(crsFeeLabel);
		
		crsFeeTF = new JTextField();
		crsFeeTF.setBounds(220,200,100,30);
		panel.add(crsFeeTF);
		
		crsdurationLabel = new JLabel("Duration: ");
		crsdurationLabel.setBounds(100,250,100,30);
		panel.add(crsdurationLabel);
		
		crsdurationTF = new JTextField();
		crsdurationTF.setBounds(220,250,100,30);
		panel.add(crsdurationTF);
		
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
			if(!crsIdTF.getText().equals("") || !crsIdTF.getText().equals(null))
			{
				Course e = er.searchCourse(crsIdTF.getText());
				if(e!= null)
				{
					crsNameTF.setText(e.getCourseName());
					crsFeeTF.setText(e.getCourseFee()+"");
					crsdurationTF.setText(e.getDuration());
					
					crsIdTF.setEnabled(false);
					crsNameTF.setEnabled(true);
					crsFeeTF.setEnabled(true);
					crsdurationTF.setEnabled(true);
					
					
					refreshBtn.setEnabled(true);
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
			Course e = new Course();
			try{
			
			e.setCourseId(crsIdTF.getText());
			e.setCourseName(crsNameTF.getText());
			e.setCourseFee(Double.parseDouble(crsFeeTF.getText()));
			e.setDuration(crsdurationTF.getText());
			
			
			
			er.insertInDB(e);
			
			JOptionPane.showMessageDialog(this, "Inserted");
			}
			catch(Exception ro)
			{
			    JOptionPane.showMessageDialog(this, "operation halted");
			}
			crsIdTF.setText("");
			crsNameTF.setText("");
			crsFeeTF.setText("");
			crsdurationTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			crsIdTF.setText("");
			crsNameTF.setText("");
			crsFeeTF.setText("");
			crsdurationTF.setText("");
			
			crsIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			refreshBtn.setEnabled(false);
		}
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllCourse();
			String head[] = {"courseId", "courseName", "courseFee", "duration"};
			
			panel.remove(crsTableSP);
			
			crsTable = new JTable(data,head);
			crsTable.setEnabled(false);
			crsTableSP = new JScrollPane(crsTable);
			crsTableSP.setBounds(350, 100, 400, 150);
			panel.add(crsTableSP);
			
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
