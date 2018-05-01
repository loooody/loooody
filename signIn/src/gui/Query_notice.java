package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import DB.Data_query;
import logic.Logic_query_notice;
import other.Notice;
import other.User;

public class Query_notice extends JFrame {

	private JPanel contentPane;
	private List<Notice> list = new ArrayList<Notice>();
	private Data_query data_query = new Data_query();
	private Notice notice;
	private String old_id;
	private static Login_employee employee;
//	private static Query_salary_employee query_salary ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_notice frame = new Query_notice(employee);
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
	public Query_notice(Login_employee employee) throws ClassNotFoundException, SQLException {
		this.employee = employee;
		old_id = employee.getTitle();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("查询公告");
		setSize(450,300);
		setBounds(100, 100, 450, 300);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		
		Object[][] data = {};
		String[] name = {"公告名","公告内容"};
		JTable table = new Logic_query_notice().Logic_query_notice(name);
		
		
		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll,"Center");
		setContentPane(contentPane);
		setVisible(true);
		
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
