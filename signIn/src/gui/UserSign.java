package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Data_query;
import logic.Logic_Sign;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSign extends JFrame{

	private JPanel contentPane;
	private JTextField user_id;
	private String id;
	private String userId;
	private String signIn_time = null;
	private String signOut_time = null;
	private String old_id;
	private static Login_employee employee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSign frame = new UserSign(employee);
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
	public UserSign(Login_employee employee) {
		this.employee = employee;
		old_id = employee.getTitle();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u7B7E\u5230\u7B7E\u9000");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = employee.getTitle().substring(employee.getTitle().length()-5,employee.getTitle().length());
		user_id = new JTextField();
		user_id.setBounds(191, 35, 128, 24);
		user_id.setText(id);
		user_id.setEditable(false);
		contentPane.add(user_id);
		user_id.setColumns(10);
		
		JLabel label = new JLabel("\u5DE5\u53F7");
		label.setBounds(117, 38, 72, 18);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("\u7B7E\u5230\u65F6\u95F4");
		label_2.setBounds(92, 97, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u7B7E\u9000\u65F6\u95F4");
		label_3.setBounds(92, 151, 72, 18);
		contentPane.add(label_3);
		
		JTextArea user_signIn = new JTextArea();
		user_signIn.setBounds(191, 95, 164, 24);
		contentPane.add(user_signIn);
		
		JTextArea user_SignOut = new JTextArea();
		user_SignOut.setBounds(191, 149, 164, 24);
		contentPane.add(user_SignOut);
		
		JButton button = new JButton("\u7B7E\u5230");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = user_id.getText();
	//			String name = user_name.getText();
				try {
					if((new Logic_Sign().isUser(id))) {
					user_signIn.setText(new Logic_Sign().getTime());
					button.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null, "没有该用户","error",JOptionPane.ERROR_MESSAGE);
					}
					signIn_time = user_signIn.getText();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "查询失败");
				}
			}
		});
		button.setBounds(92, 213, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7B7E\u9000");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(signIn_time != null) {
				user_SignOut.setText(new Logic_Sign().getTime());
				signOut_time = user_SignOut.getText();
				
				new Data_query().signIn(id, signIn_time, signOut_time);
				button_1.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "还未签到","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(244, 213, 113, 27);
		contentPane.add(button_1);
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	        	  Login_employee frame = new Login_employee();
	        	  frame.setTitle(old_id);
	        	  frame.setVisible(true);
	             setVisible(false);
	          }
	      });
	}
}
