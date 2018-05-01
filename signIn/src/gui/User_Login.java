package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Logic_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNull;
	private JPasswordField passwordField;
	private String grade = "Employee";
	private String name = null;
	private String pwd = null;
	private Logic_login login =new Logic_login();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_Login() {
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 400, 450, 300);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u53F7");
		lblNewLabel.setBounds(137, 60, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(137, 110, 72, 18);
		contentPane.add(label);
		
		txtNull = new JTextField();
		txtNull.setBounds(193, 57, 86, 24);
		contentPane.add(txtNull);
		txtNull.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 107, 86, 24);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = txtNull.getText();
				pwd = passwordField.getText();
				
				System.out.println(name+"\n");
				System.out.println(pwd+"\n");
				System.out.println(grade+"\n");
				try {
					if(login.Login(name, pwd ,grade)) {
						if(grade.equals("Employee")) {
							Login_employee frame =new Login_employee();
							frame.setVisible(true);
							frame.setTitle("ª∂”≠ƒ˙£¨"+login.getName(name)+"  π§∫≈£∫"+name);
							
						}
						if(grade.equals("Charger")) {
							Login_charger frame =new Login_charger();
							frame.setVisible(true);
							frame.setTitle("ª∂”≠ƒ˙£¨"+login.getName(name)+"  π§∫≈£∫"+name);
						}
						if(grade.equals("Admin")) {
							Login_main frame =new Login_main();
							frame.setVisible(true);
							frame.setTitle("ª∂”≠ƒ˙£¨"+login.getName(name)+"  π§∫≈£∫"+name);
						}
						setVisible(false);
					}else if(name.equals("") || pwd.equals("")) {
						JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬ÎŒ™ø’£¨«Î÷ÿ–¬ ‰»Î", "error", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î ‰»Î¥ÌŒÛ", "error", 0);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(173, 186, 80, 27);
		contentPane.add(button);
		
		ButtonGroup group =new ButtonGroup(); 
		
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.setSelected(true);
		rdbtnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grade = rdbtnEmployee.getText();
			}
		});
		rdbtnEmployee.setBounds(55, 150, 105, 27);
		contentPane.add(rdbtnEmployee);
		group.add(rdbtnEmployee);
		
		JRadioButton rdbtnCharger = new JRadioButton("Charger");
		rdbtnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grade = rdbtnCharger.getText();
			}
		});
		rdbtnCharger.setBounds(173, 150, 86, 27);
		contentPane.add(rdbtnCharger);
		group.add(rdbtnCharger);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grade = rdbtnAdmin.getText();
			}
		});
		rdbtnAdmin.setBounds(269, 150, 91, 27);
		contentPane.add(rdbtnAdmin);
		group.add(rdbtnAdmin);
		
		
		JButton button_1 = new JButton("\u53BB\u6CE8\u518C\uFF1F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  new Register_User().setVisible(true);
			  setVisible(false);
			}
		});
		button_1.setBounds(292, 213, 105, 27);
		contentPane.add(button_1);
	}
	
}
