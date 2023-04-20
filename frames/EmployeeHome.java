package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class EmployeeHome extends JFrame implements ActionListener
{
	//JButton logoutBtn, manageEmpBtn, manageProductBtn, managePurchaseBtn, changePasswordBtn;
	private JLabel textLabel,imgLabel;
	private JButton manageEmpBtn,studentBtn,purchaseBtn,mangePayment,changePasswordBtn,updateBtn,CourseBtn,allStudentBtn,paymentBtb,logoutBtn;
	//private JPanel panel;
	//private ImageIcon img;
	
	private JPanel panel;
	
	User user;
	
	public EmployeeHome(User user)
	{
		
		
		super("Employee Home");
		this.setSize(800, 600);
		this.setLocation(500, 100);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.user=user;
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#112d4e"));
		
		textLabel = new JLabel("Choose your Right Option!");
		textLabel.setBounds(310, 70, 300, 30);
		textLabel.setForeground(Color.decode("#ff9a00"));
		textLabel.setFont(new Font("Calibri",Font.HANGING_BASELINE,20));
		panel.add(textLabel);
		
		manageEmpBtn = new JButton("ManageEmployee");
		manageEmpBtn.setBounds(230, 150, 150, 38);
		manageEmpBtn.setBackground(Color.decode("#6a2c70"));
		manageEmpBtn.setForeground(Color.decode("#30e3ca"));
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		studentBtn = new JButton("ManageStudent");
		studentBtn.setBounds(410, 150, 150, 38);
		studentBtn.setBackground(Color.decode("#6a2c70"));
		studentBtn.setForeground(Color.decode("#30e3ca"));
		studentBtn.addActionListener(this);
		panel.add(studentBtn);
		
		CourseBtn = new JButton("ManageCourse");
		CourseBtn.setBounds(230, 218, 150, 38);
		CourseBtn.setBackground(Color.decode("#6a2c70"));
		CourseBtn.setForeground(Color.decode("#30e3ca"));
		CourseBtn.addActionListener(this);
		panel.add(CourseBtn);
		
		purchaseBtn = new JButton("ManagePurchase");
		purchaseBtn.setBounds(410, 218, 150, 38);
		purchaseBtn.setBackground(Color.decode("#6a2c70"));
		purchaseBtn.setForeground(Color.decode("#30e3ca"));
		purchaseBtn.addActionListener(this);
		panel.add(purchaseBtn);
		
		
		
		allStudentBtn = new JButton("See All Student");
		allStudentBtn .setBounds(410, 280, 150, 38);
		allStudentBtn .setBackground(Color.decode("#6a2c70"));
		allStudentBtn .setForeground(Color.decode("#30e3ca"));
		allStudentBtn .addActionListener(this);
		panel.add(allStudentBtn );
		
		
		
		
		updateBtn = new JButton("Update Info");
		updateBtn.setBounds(230, 280, 150, 38);
		updateBtn.setBackground(Color.decode("#6a2c70"));
		updateBtn.setForeground(Color.decode("#30e3ca"));
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(290, 428, 210, 35);
		logoutBtn.setBackground(Color.decode("#6a2c70"));
		logoutBtn.setForeground(Color.decode("#30e3ca"));
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Chang Password");
		changePasswordBtn.setBounds(290, 378, 210, 35);
		changePasswordBtn.setBackground(Color.decode("#6a2c70"));
		changePasswordBtn.setForeground(Color.decode("#30e3ca"));
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		
		
		
		/*img = new ImageIcon("homepage.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(150, 0, 500, 555);
		panel.add(imgLabel);*/ 
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				EmployeeFrame ef = new EmployeeFrame(user);
				ef.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(studentBtn.getText())){
			
			StudentFrame sh = new StudentFrame(user);
			sh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(CourseBtn.getText())){
			 CourseFrame ch = new  CourseFrame(user);
			 ch.setVisible(true);
			 this.setVisible(false);
		}
		else if(command.equals(purchaseBtn.getText())){
			PurchaseFrame pg=new PurchaseFrame();
		    pg.setVisible(true);
			this.setVisible(false);
			
			
		}
		else if(command.equals(updateBtn.getText())){
			UpdateInfo uf=new UpdateInfo(user);
			uf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(allStudentBtn.getText())){
			AllStudent uf=new AllStudent(user);
			uf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(changePasswordBtn.getText())){
			PasswordFrame1 pf=new PasswordFrame1(user);
			pf.setVisible(true);
			this.setVisible(false);
		}
		
		
		
		else{}
	}
}