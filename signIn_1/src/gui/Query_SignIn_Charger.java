package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DB.Data_query;
import logic.Logic_query_salary_charger;
import logic.Logic_query_sign_charger;

public class Query_SignIn_Charger extends JFrame implements ActionListener{
	private JScrollPane scroll;
	private JPanel contentPane;
	private JButton btn_query;
	private String date = "";
	private JComboBox box,box1,box2;
	private JTable table;
	private String name[] = {"序号","工号","姓名","签到时间","签退时间"};
	private Object[][] data;
	private DefaultTableModel tableModel = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_SignIn_Charger frame = new Query_SignIn_Charger();
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
	public Query_SignIn_Charger() throws ClassNotFoundException, SQLException {
		setTitle("\u5458\u5DE5\u7B7E\u5230\u60C5\u51B5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = (JPanel)getContentPane();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
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
		
		JLabel day = new JLabel("日:");
		panel.add(day);
		String[][] name_day = {{"01","02","03","04","05","06","07","08","09","10",
				             "11","12","13","14","15","16","17","18","19","20",
				             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
					             "11","12","13","14","15","16","17","18","19","20",
					             "21","22","23","24","25","26","27","28","29"},
				{"01","02","03","04","05","06","07","08","09","10",
						             "11","12","13","14","15","16","17","18","19","20",
						             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
							             "11","12","13","14","15","16","17","18","19","20",
							             "21","22","23","24","25","26","27","28","29","30"},
				{"01","02","03","04","05","06","07","08","09","10",
								             "11","12","13","14","15","16","17","18","19","20",
								             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
									             "11","12","13","14","15","16","17","18","19","20",
									             "21","22","23","24","25","26","27","28","29","30"},
				{"01","02","03","04","05","06","07","08","09","10",
										             "11","12","13","14","15","16","17","18","19","20",
										             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
											             "11","12","13","14","15","16","17","18","19","20",
											             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
												             "11","12","13","14","15","16","17","18","19","20",
												             "21","22","23","24","25","26","27","28","29","30"},
				{"01","02","03","04","05","06","07","08","09","10",
													             "11","12","13","14","15","16","17","18","19","20",
													             "21","22","23","24","25","26","27","28","29","30","31"},
				{"01","02","03","04","05","06","07","08","09","10",
														             "11","12","13","14","15","16","17","18","19","20",
														             "21","22","23","24","25","26","27","28","29","30"},
				{"01","02","03","04","05","06","07","08","09","10",
															             "11","12","13","14","15","16","17","18","19","20",
															             "21","22","23","24","25","26","27","28","29","30","31"},};
		box2 = new JComboBox();
		for(int i=0;i<name_day[0].length;i++) {
		box2.addItem(name_day[0][i]);
		}
		panel.add(box2);
		
		//获取当前时间
		Date date_today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String Today = format.format(date_today);
		box.setSelectedItem(Today.substring(0, 4));
		box1.setSelectedItem(Today.substring(5, 7));
		box2.setSelectedItem(Today.substring(8, 10));
//		System.out.println(Today+"\n"+Today.substring(0, 4)+"\n"+Today.substring(5, 7));
		
		date = Today;
		btn_query = new JButton("查询");
		btn_query.addActionListener(this);
		panel.add(btn_query);
		contentPane.add(panel,"North");
		
	//	String name[] = {"序号","工号","姓名","签到时间","签退时间"};
	//	JTable table = new Logic_query_sign_charger().getSignIn_info_Charger1(name,date);
		
			
		//创建表格模型
	//	DefaultTableModel tableModel = new DefaultTableModel(data,name);
		
	//	table = new JTable(tableModel);
		
	//	table = new Logic_query_sign_charger().getSignIn_info_Charger(name);
	//	scroll = new JScrollPane(table);
		
	//	contentPane.add(scroll,"Center");
		/*
		Object[][] data = {};
		String name[] = {"序号","工号","姓名","签到时间","签退时间"};
		JTable table = new JTable(data,name);
//		JTable table = new Logic_query_sign_charger().getSignIn_info_Charger(name);
		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll,"Center");
		*/
	//	setContentPane(contentPane);
	//	setVisible(true);
		
		data = new Logic_query_sign_charger().getSignIn_info_Charger(name,date);
		//    	for(int i=0;i<50;i++) {
		 //   		for(int j=0;j<6;j++) {
		 //   			System.out.println(data[i][j]);
		    		
		//    	}
		//    	table = new Logic_query_sign_charger().getSignIn_info_Charger1(name,date);
		//    	JOptionPane.showMessageDialog(null, date);
		    	
		    	//创建表格模型
				tableModel = new DefaultTableModel(data,name);
				
				table = new JTable(tableModel);
				
			//	table = new Logic_query_sign_charger().getSignIn_info_Charger(name);
				scroll = new JScrollPane(table);
				
				contentPane.add(scroll,"Center");
				setContentPane(contentPane);
				setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             
					new Login_charger().setVisible(true);
				
	          } 
	      });
	}
	
public void actionPerformed(ActionEvent e) {
	
		String date1 = box1.getSelectedItem().toString().substring(0,2);
		date = "";
	//	tableModel.getDataVector().removeAllElements();
	    if(e.getSource() == btn_query) {
	    	
	//    	Query_SignIn_Charger frame = new Query_SignIn_Charger();
	    	data = new Object[50][6];
	    	date += box.getSelectedItem();
	    	date += "-";
	    	date += date1;
	    	date += "-";
	    	date += box2.getSelectedItem();
	    	System.out.println(date);
//	    	JOptionPane.showMessageDialog(null, date);
	    	try {
				data = new Logic_query_sign_charger().getSignIn_info_Charger(name,date);
				for(int i=0;i<data.length;i++) {
					for(int j=0;j<5;j++) {
						table.setValueAt(data[i][j], i, j);
					}
				}
	    	} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	
	    	
	    }
	 //   	new Query_SignIn_Charger().setVisible(true);
	//		setVisible(false);
	
	   
			
			
	    	
		}
}
