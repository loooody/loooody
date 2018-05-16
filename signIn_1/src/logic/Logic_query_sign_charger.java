package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import DB.Data_query;
import other.User;

public class Logic_query_sign_charger {
	private Data_query data_query = new Data_query();
	private JTable table;
	private List<User> list = new ArrayList<User>();
	private User user;
	private Object[][] data;
	private JScrollPane scroll;
	
	public JTable getSignIn_info_Charger(String[] name) throws ClassNotFoundException, SQLException {
		
		list = data_query.getAllSign_Charger();
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
			data[i][3] = user.getSignIn_time();
			data[i][4] = user.getSignOut_time();
			count++;
		}
		}
		table = new JTable(data,name);
//		scroll = new JScrollPane(table);
		
		
		return table;
		
	}
	
	
public Object[][] getSignIn_info_Charger(String[] name,String date) throws ClassNotFoundException, SQLException {
		
		list = data_query.getAllSign_Charger(date);
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
			data[i][3] = user.getSignIn_time();
			data[i][4] = user.getSignOut_time();
			count++;
		}
		}
	//	table = new JTable(data,name);
		System.out.println("succeed");
//		scroll = new JScrollPane(table);
		
		
		return data;
		
	}
}
