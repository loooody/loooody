package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Data_query;
import logic.Logic_Sign;
import other.User;

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
	private String signIn_time = "";
	private String signOut_time = "";
	private String old_id;
	private static Login_employee employee;
	private User user;
	private JButton button,button_1;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public UserSign(Login_employee employee) throws ClassNotFoundException, SQLException {
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
		
		Date date_today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(date_today);
		
		
		button = new JButton("\u7B7E\u5230");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = user_id.getText();
				
	            if(user.getSignIn_time().equals("")) {
				user_signIn.setText(new Logic_Sign().getTime());
				signIn_time = user_signIn.getText();
				new Data_query().signIn(id, signIn_time, signOut_time);
				button.setEnabled(false);
				
				}
				
			}
		});
		button.setBounds(92, 213, 113, 27);
		contentPane.add(button);
		
		button_1 = new JButton("\u7B7E\u9000");
		button_1.setEnabled(true);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(signIn_time != null) {
				user_SignOut.setText(new Logic_Sign().getTime());
				signOut_time = user_SignOut.getText();
				
				new Data_query().signOut(id, signOut_time);
				button_1.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "»¹Î´Ç©µ½","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		user = new Logic_Sign().getSignIn_info(id, date);
		user_signIn.setText(user.getSignIn_time());
		user_SignOut.setText(user.getSignOut_time());

		button_1.setBounds(244, 213, 113, 27);
		contentPane.add(button_1);
		
		String str1 = user_signIn.getText();
		String str2 = user_SignOut.getText();
		
		System.out.println("user.getSignIn_time():"+user.getSignIn_time()+"user.getSignOut_time()"+user.getSignOut_time());
		if(str1.equals("")) {
			}else {
				button.setEnabled(false);
			}
		if(str2.equals("")) {
		//	button_1.setEnabled(false);
			}else {
				button_1.setEnabled(false);
			}
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
