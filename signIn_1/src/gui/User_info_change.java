package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Data_query;
import logic.Logic_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_info_change extends JFrame {

	private JPanel contentPane;
	private JTextField user_pwd;
	private JTextField user_name;
	private JTextField user_num;
	private JTextField user_grade;
	private String id;
	private String name;
	private String pwd;
	private String grade;
	private boolean flag = false;  //当数据查询成功，确认由此按钮时，启动更新按钮

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_info_change frame = new User_info_change();
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
	public User_info_change() {
		setTitle("\u4FE1\u606F\u66F4\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(43, 141, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(43, 87, 72, 18);
		contentPane.add(label_1);
		
		user_pwd = new JTextField();
		user_pwd.setBounds(129, 84, 86, 24);
		contentPane.add(user_pwd);
		user_pwd.setColumns(10);
		
		user_name = new JTextField();
		user_name.setBounds(129, 138, 86, 24);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		user_num = new JTextField();
		user_num.setBounds(129, 33, 86, 24);
		contentPane.add(user_num);
		user_num.setColumns(10);
		
		user_grade = new JTextField();
		user_grade.setBounds(280, 112, 86, 24);
		contentPane.add(user_grade);
		user_grade.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = user_num.getText();
				pwd = user_pwd.getText();
				
				
				try {
					if(new Logic_login().isUser(id, pwd)) {
						user_num.setEditable(false);
						user_name.setText(new Logic_login().getName(id));
						user_grade.setText(new Logic_login().getGrade(id, pwd));
						flag = true;
					}else {
						JOptionPane.showMessageDialog(null, "没有此用户信息", "error", 0);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(43, 202, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u66F4\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = user_name.getText();
				pwd = user_pwd.getText();
				grade = user_grade.getText();
				
				if(flag) {
					if(name.equals("")||pwd.equals("")||grade.equals("")) {
						JOptionPane.showMessageDialog(null, "姓名,密码，用户级别不能为空", "error", 0);
					}else {
				         new Data_query().user_change_info(id, name, pwd, grade);
					}
				}
			}
		});
		button_1.setBounds(259, 202, 113, 27);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u53F7");
		lblNewLabel.setBounds(43, 36, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7EA7\u522B");
		label_2.setBounds(280, 68, 72, 18);
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
