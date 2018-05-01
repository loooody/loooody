package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Logic_Sign;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register_User extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JTextField user_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_User frame = new Register_User();
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
	public Register_User() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(143, 63, 60, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(143, 124, 60, 18);
		contentPane.add(label_1);
		
		user_name = new JTextField();
		user_name.setBounds(217, 60, 86, 24);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		user_pwd = new JTextField();
		user_pwd.setBounds(217, 121, 86, 24);
		contentPane.add(user_pwd);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = user_name.getText();
				String pwd = user_pwd.getText();
				if(name.equals("") || pwd.equals("")) {
					JOptionPane.showMessageDialog(null, "账号或密码为空，请重新输入", "error", JOptionPane.ERROR_MESSAGE);
				}else {
				try {
					new Logic_Sign().user_Register(name, pwd);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		button.setBounds(90, 174, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Login().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(265, 174, 113, 27);
		contentPane.add(button_1);
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             new User_Login().setVisible(true);
	          }
	      });
	}

}
