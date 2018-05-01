package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import logic.Logic_employee;
import logic.Logic_query_salary_charger;
import logic.Logic_query_sign_charger;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Query_salary_Charger extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btn_query;
	private String date = "";
	private JComboBox box,box1;
	private Object[][] data;
	private JTable table;
	private String[] name = {"序号","工号","姓名","工资"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_salary_Charger frame = new Query_salary_Charger();
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
	public Query_salary_Charger() throws ClassNotFoundException, SQLException {
		setTitle("\u5DE5\u8D44\u67E5\u8BE2");
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
		box.addActionListener(this);
		panel.add(box);
		
		JLabel month = new JLabel("月份:");
		panel.add(month);
		String[] name_month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		box1 = new JComboBox(name_month);
		box1.addActionListener(this);
		panel.add(box1);
		
		
		//获取当前时间
				Date date_today = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String Today = format.format(date_today);
				box.setSelectedItem(Today.substring(0, 4));
				box1.setSelectedItem(Today.substring(5, 7));
//				System.out.println(Today+"\n"+Today.substring(0, 4)+"\n"+Today.substring(5, 7));
				
				date = Today.substring(0, 7);
				
		btn_query = new JButton("查询");
		btn_query.addActionListener(this);
		panel.add(btn_query);
		contentPane.add(panel,"North");
		
		
		
		data = new Logic_query_salary_charger().query_salary(name,date);
		table = new JTable(data,name);
		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll,"Center");
		setContentPane(contentPane);
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
					new Login_charger().setVisible(true);
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
			JOptionPane.showMessageDialog(null, date);
			
			try {
				data = new Logic_query_salary_charger().query_salary(name,date);
				System.out.println("长度:"+data.length+"   "+date);
				for(int i=0;i<data.length;i++) {
					for(int j=0;j<4;j++) {
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
		
	}
}
