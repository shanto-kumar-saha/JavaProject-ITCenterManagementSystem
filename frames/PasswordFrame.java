package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class PasswordFrame extends JFrame implements ActionListener
{
	private JLabel cpasswordLabel, npasswordLabel;
	private JPasswordField cpasswordfild,npasswordfild;
	//private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton backBtn, submitBtn, logoutBtn;
	private JPanel panel;
	private User user;
	
	
	public PasswordFrame(User user)
	{
		super("PasswordFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user=user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		cpasswordLabel = new JLabel("Current Password: ");
		cpasswordLabel.setBounds(200, 100, 160, 30);
		panel.add(cpasswordLabel);
		
		cpasswordfild = new JPasswordField();
		cpasswordfild.setBounds(310, 100, 150, 30);
		panel.add(cpasswordfild);
		
		npasswordLabel = new JLabel("New Password: ");
		npasswordLabel.setBounds(200, 140, 160, 30);
		panel.add(npasswordLabel);
		
		npasswordfild = new JPasswordField();
		npasswordfild.setBounds(310, 140, 150, 30);
		panel.add(npasswordfild);
		
		
		submitBtn= new JButton("Submit");
		submitBtn.setBounds(420, 200, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		
		backBtn= new JButton("Back");
		backBtn.setBounds(300, 300, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		this.add(panel);
		
		logoutBtn= new JButton("Log out");
		logoutBtn.setBounds(415, 300, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame e = new LoginFrame();
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(submitBtn.getText()))
		{
			LoginFrame e = new LoginFrame();
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(backBtn.getText()))
		{
			StudentHome pw = new StudentHome(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
	}
}
