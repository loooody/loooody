package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login_employee extends JFrame {

	private JPanel contentPane;
	public Login_employee employee = this;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_employee frame = new Login_employee();
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
	public Login_employee() {
	//	this.query_salary = query_salary;
		setTitle("\u7528\u6237");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u7B7E\u5230\u7B7E\u9000");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserSign(employee).setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(76, 29, 93, 67);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u67E5\u770B\u516C\u544A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Query_notice(employee).setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		button_1.setBounds(252, 29, 93, 67);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5DE5\u8D44\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Query_salary_employee(employee).setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button_2.setBounds(76, 146, 93, 67);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u8FD4\u56DE\u767B\u5F55");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Login().setVisible(true);
				setVisible(false);
			}
		});
		button_3.setBounds(252, 146, 93, 67);
		contentPane.add(button_3);
		
	}

}
