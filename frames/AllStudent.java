package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;



public class AllStudent extends JFrame implements ActionListener{

	private JLabel headingLabel;
	private JTable empTable;
	private JScrollPane empTableSP;
	private JButton logoutBtn,backBtn;
	private JPanel panel;
	private User user;
	
	
	public AllStudent(User user) {
		super("all student");
		this.setSize(800, 600);
		this.setLocation(500, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#303841"));
		
		
		headingLabel= new JLabel("All Student");
		headingLabel.setBounds(350, 40, 200, 50);
		headingLabel.setForeground(new Color(255,255,255));
		headingLabel.setFont(new Font("Calibri",Font.HANGING_BASELINE,30));
		panel.add(headingLabel);
		
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Student Name", "Student-Id","Email"};
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(100, 100, 600, 281);
		empTableSP.setBackground(Color.decode("#66c6ba"));
		empTableSP.setFont(new Font("Calibri",Font.PLAIN,18));
		
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(570, 410, 170, 35);
		logoutBtn.setBackground(Color.decode("#aa96da"));
		logoutBtn.setForeground(Color.decode("#f9ed69"));
		logoutBtn.setFont(new Font("Roboto Mono",Font.PLAIN,16));
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(385, 410, 170, 35);
		backBtn.setBackground(Color.decode("#aa96da"));
		backBtn.setForeground(Color.decode("#f9ed69"));
		backBtn.setFont(new Font("Roboto Mono",Font.PLAIN,16));
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if(command.equals(logoutBtn.getText())) {
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(backBtn.getText())) {
			
			
			EmployeeHome ep = new EmployeeHome(user);
			ep.setVisible(true);
			this.setVisible(false);
		}
	}
}
