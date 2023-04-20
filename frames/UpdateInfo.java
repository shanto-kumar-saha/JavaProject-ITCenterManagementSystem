package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;



public class UpdateInfo  extends JFrame implements ActionListener{

	private JLabel empIdLabel, empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, backBtn,logoutBtn;
	private JTable empTable;
	private JScrollPane empTableSP;
	private JPanel panel;
	private User user;
	private EmployeeRepo ur;
	
	public  UpdateInfo (User user) {
		super("Employee update info");
		this.setSize(800, 600);
		this.setLocation(500, 100);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.user=user;

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#53354a"));
		
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(100,100,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,100,100,30);
		empIdTF.setEnabled(false);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,150,100,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(220,150,100,30);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Designation: ");
		empDesignationLabel.setBounds(100,200,100,30);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(220,200,100,30);
		panel.add(empDesignationTF);
		
		empSalaryLabel = new JLabel("Salary: ");
		empSalaryLabel.setBounds(100,250,100,30);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(220,250,100,30);
		panel.add(empSalaryTF);
		/*emEmail = new JLabel("Email: ");
		emEmail.setBounds(90,200,100,30);
		emEmail.setForeground(Color.decode("#bfcfff"));
		emEmail.setFont(new Font("Calibri",Font.PLAIN,20));
		panel.add(emEmail);
		
		emEmailTF = new JTextField();
		emEmailTF.setBounds(220,200,300,30);
		emEmailTF.setBackground(Color.decode("#e8f1f5"));
		emEmailTF.setForeground(Color.black);
		emEmailTF.setFont(new Font("Calibri",Font.PLAIN,18));
		panel.add(emEmailTF);*/
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(280,280,150,30);
		updateBtn.addActionListener(this);
		updateBtn.setBackground(Color.decode("#283149"));
		updateBtn.setForeground(Color.decode("#e8f1f5"));
		updateBtn.setFont(new Font("Calibri",Font.PLAIN,18));
		//updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		loadBtn = new JButton("load");
		loadBtn.setBounds(450,280,150,30);
		loadBtn.addActionListener(this);
		loadBtn.setBackground(Color.decode("#283149"));
		loadBtn.setForeground(Color.decode("#e8f1f5"));
		loadBtn.setFont(new Font("Calibri",Font.PLAIN,18));
		
		panel.add(loadBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(330, 460, 150, 30);
		
		backBtn.setBackground(Color.decode("#283149"));
		backBtn.setForeground(Color.decode("#e8f1f5"));
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(500, 460, 150, 30 );
		logoutBtn.setBackground(Color.decode("#283149"));
		logoutBtn.setForeground(Color.decode("#e8f1f5"));
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if(command.equals(backBtn.getText())) {
			EmployeeHome ep = new EmployeeHome(user);
			ep.setVisible(true);
			this.setVisible(false);
		}
		
	
		else if(command.equals(logoutBtn.getText())) {
			/*Singuppage sing =new Singuppage();
			sing.setVisible(true);
			this.setVisible(false);*/
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(loadBtn.getText())) {
                   String em=user.getUserId();
				Employee e = ur.searchEmployee(em);
				if(e!= null)
				{
					empIdTF.setText(e.getEmpId());
					empNameTF.setText(e.getName());
					empDesignationTF.setText(e.getDesignation());
					empSalaryTF.setText(e.getSalary()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(false);
					empSalaryTF.setEnabled(false);
					
					
					
					
					updateBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
		
	}
	
	else if(command.equals(updateBtn.getText()))
		{
			Employee e = new Employee();
			
			
			try{
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			e.setSalary(Double.parseDouble(empSalaryTF.getText()));
			
			
			ur.updateInDB(e);
	
			
			
			JOptionPane.showMessageDialog(this, "Updated");
			}
			catch(Exception ro)
			{
				JOptionPane.showMessageDialog(this, "operation halted");
			}
			
			
		}
	}
	
	
}
