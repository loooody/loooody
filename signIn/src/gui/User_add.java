package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Data_query;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_add extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JTextField user_pwd;
	private JTextField user_num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_add frame = new User_add();
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
	public User_add() {
		setTitle("\u6DFB\u52A0\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(126, 85, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5BC6\u7801");
		label_1.setBounds(126, 134, 72, 18);
		contentPane.add(label_1);
		
		user_name = new JTextField();
		user_name.setBounds(228, 82, 86, 24);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		user_pwd = new JTextField();
		user_pwd.setBounds(228, 131, 86, 24);
		contentPane.add(user_pwd);
		user_pwd.setColumns(10);
		
		user_num = new JTextField();
		user_num.setBounds(228, 35, 86, 24);
		contentPane.add(user_num);
		user_num.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = user_name.getText();
				String userPwd = user_pwd.getText();
				String userId = user_num.getText();
				
				new Data_query().user_add(userId, userName, userPwd);
			}
		});
		button.setBounds(168, 197, 113, 27);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u5DE5\u53F7");
		label_2.setBounds(126, 38, 72, 18);
		contentPane.add(label_2);
		
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             new User_manage().setVisible(true);
	          }
	      });
	}
}
