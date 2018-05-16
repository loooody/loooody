package logic;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DB.Data_query;
import gui.User_info;
import other.User;

public class Logic_User_info {
	private Data_query data_query = new Data_query();
	private JTable table;
	private List<User> list = new ArrayList<User>();
	private User user;
	private Object[][] data;
	private JScrollPane scroll;
	
	public JTable getTable_info(String[] name) throws ClassNotFoundException, SQLException {
		
		list = data_query.getAllUser();
		data = new Object[50][6];
		int count =1;
		System.out.println(list.size());
		if(list.size()>0) {
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
			System.out.println(user.getUserName());
			data[i][0] = count;
			data[i][1] = user.getUserId();
			data[i][2] = user.getUserName();
			data[i][3] = user.getUserPwd();
			data[i][4] = user.getUserGrade();
			data[i][5] = "x";
			count++;
		}
		}
		table = new JTable(data,name);
//		scroll = new JScrollPane(table);
		
		
		return table;
		
	}
}
