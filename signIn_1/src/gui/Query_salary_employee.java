package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Data_query;
import logic.Logic_employee;
import logic.Logic_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Query_salary_employee extends JFrame implements ActionListener{
	private String old_id;
	private JPanel contentPane;
	private JTextField user_id;
	private JTextField user_name;
	private JTextField sign_nCount;
	private JTextField user_salary;
	private static Login_employee employee;
	private JButton btn_query;
	private Box basebox,Box1,Box2;
	private String date = "";
	private JComboBox box,box1;
	private String id;
//	public Query_salary_employee query_salary = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_salary_employee frame = new Query_salary_employee(employee);
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
	public Query_salary_employee(Login_employee employee) throws ClassNotFoundException, SQLException {
		this.employee = employee;
		setTitle("\u67E5\u8BE2\u5DE5\u8D44");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		JLabel year = new JLabel("年份:");
		panel.add(year);
		String[] name_year = {"2018","2019","2020","2021","2022","2023","2024"};
		box = new JComboBox(name_year);
		panel.add(box);
		
		JLabel month = new JLabel("月份:");
		panel.add(month);
		String[] name_month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		box1 = new JComboBox(name_month);
		panel.add(box1);
		
		//获取当前时间
		Date date_today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String Today = format.format(date_today);
		box.setSelectedItem(Today.substring(0, 4));
		box1.setSelectedItem(Today.substring(5, 7));
//		System.out.println(Today+"\n"+Today.substring(0, 4)+"\n"+Today.substring(5, 7));
		
		date = Today.substring(0, 7);
		
		btn_query = new JButton("查询");
		btn_query.addActionListener(this);
		panel.add(btn_query);
	//	panel.setSize(450,30);
		contentPane.add(panel,"North");
		
		
		JPanel panel2 = new JPanel();
		Box1 = Box.createVerticalBox();
		Box1.add(Box.createVerticalStrut(30));
		JLabel label = new JLabel("\u5DE5\u53F7");
		label.setBounds(109, 42, 72, 24);
		label.setSize(72,24);
		Box1.add(label);
		Box1.add(Box.createVerticalStrut(12));
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(109, 92, 72, 24);
		label_1.setSize(72,24);
		Box1.add(label_1);
		Box1.add(Box.createVerticalStrut(12));
		
		JLabel label_2 = new JLabel("\u7B7E\u5230\u6B21\u6570");
		label_2.setBounds(109, 146, 72, 24);
		label_2.setSize(72,24);
		Box1.add(label_2);
		Box1.add(Box.createVerticalStrut(12));
		
		JLabel label_3 = new JLabel("\u5DE5\u8D44");
		label_3.setBounds(109, 194, 72, 24);
		label_3.setSize(72,24);
		
		Box1.add(label_3);
		
		old_id = employee.getTitle();
		id = employee.getTitle().substring(employee.getTitle().length()-5,employee.getTitle().length());
		
		Box2 = Box.createVerticalBox();
		Box2.add(Box.createVerticalStrut(30));
		user_id = new JTextField();
		user_id.setText(id);
		user_id.setEditable(false);
		user_id.setBounds(208, 39, 86, 24);
		Box2.add(user_id);
		Box2.add(Box.createVerticalStrut(12));
		user_id.setColumns(10);
		
		
		user_name = new JTextField();
		user_name.setText(new Logic_login().getName(id));
		user_name.setEditable(false);
		user_name.setBounds(208, 89, 86, 24);
		Box2.add(user_name);
		Box2.add(Box.createVerticalStrut(12));
		user_name.setColumns(10);
		
	//	int count = new Data_query().get_nCount_signIn(id,date);
		sign_nCount = new JTextField();
	//	sign_nCount.setText(String.valueOf(count));
		sign_nCount.setEditable(false);
		sign_nCount.setBounds(208, 143, 86, 24);
		Box2.add(sign_nCount);
		Box2.add(Box.createVerticalStrut(12));
		sign_nCount.setColumns(10);
		
		user_salary = new JTextField();
	//	user_salary.setText(new Logic_employee().user_salary(count));
		user_salary.setEditable(false);
		user_salary.setBounds(208, 191, 86, 24);
		Box2.add(user_salary);
		user_salary.setColumns(10);
		
		basebox = Box.createHorizontalBox();
		basebox.add(Box1);
		basebox.add(Box.createHorizontalStrut(20));
		basebox.add(Box2);
		
		panel2.add(basebox);
		contentPane.add(panel2,"Center");
		
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
	
	public void actionPerformed(ActionEvent e) {
		date = "";
		String date1 = box1.getSelectedItem().toString();
		if(e.getSource() == btn_query) {
			 date += box.getSelectedItem();
			 date += "-";
			 date += date1.substring(0,2);
			 int count;
			try {
				count = new Data_query().get_nCount_signIn(id,date);
				sign_nCount.setText(String.valueOf(count));
			 
				user_salary.setText(new Logic_employee().user_salary(count));
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
	//		JOptionPane.showMessageDialog(null, date);
		}
	}
}
