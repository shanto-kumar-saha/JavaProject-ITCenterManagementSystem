package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StudentHome extends JFrame implements ActionListener
{
	private JLabel idLabel, nameLabel;
	private JTextField idTF, nameTF;
	private JButton changePasswordBtn, logoutBtn;
	private JPanel panel;
	private User user;
	
	public StudentHome(User user)
	{
		super("StudentHome ");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user=user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(200, 50, 160, 30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(310, 50, 150, 30);
		idTF.setEditable(false);
		panel.add(idTF);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(200, 90, 160, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(310, 90, 150, 30);
		nameTF.setEditable(false);
		panel.add(nameTF);
		
		
		changePasswordBtn= new JButton("Change Password");
		changePasswordBtn.setBounds(300, 220, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
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
		else if(command.equals(changePasswordBtn.getText()))
		{
			PasswordFrame pw = new PasswordFrame(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
	}
}