package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import logic.Logic_User_info;
import other.User;

import javax.swing.JButton;

public class User_info extends JFrame {

	private JPanel contentPane;
	private List<User> list = new ArrayList<User>();
	private Data_query data_query = new Data_query();
	private User user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_info frame = new User_info();
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
	public User_info() throws ClassNotFoundException, SQLException {
		setTitle("\u7528\u6237\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = (JPanel)getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Object[][] data = new Object[50][];
		String[] name = {"序号","用户ID","用户名","用户密码","用户级别","删除"};
		
		JScrollPane scroll = new JScrollPane();
	
		JTable table = new Logic_User_info().getTable_info(name);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//得到选中的行列的索引值
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				try {
					list = data_query.getAllUser();
					//得到选中单元格的值
				user = list.get(r);
					Object value = table.getValueAt(r, c);
					if(value.toString().equals("x")) {
		//			String info = r+"行"+c+"列:"+value.toString();
					new Data_query().user_delete(user.getUserId(), user.getUserName(), user.getUserGrade());
					new User_info().setVisible(true);
					setVisible(false);
					}
				}
				 catch (ClassNotFoundException e1) {
					 JOptionPane.showMessageDialog(null, "没有相关类");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "没有查询到数据");
				}
			//		scroll.revalidate();
			}
		});
		
		scroll = new JScrollPane(table);
		contentPane.add(scroll);
		setContentPane(contentPane);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             new User_manage().setVisible(true);
	          }
	      });
	}

}
