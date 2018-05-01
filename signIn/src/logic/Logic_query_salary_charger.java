package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import DB.Data_query;
import other.User;

public class Logic_query_salary_charger {
	private Data_query data_query = new Data_query();
	private JTable table;
	private List<User> list = new ArrayList<User>();
	private User user;
	private Object[][] data;
	private Logic_employee sign_Count = new Logic_employee();
	
	public Object[][] query_salary(String[] name,String date) throws ClassNotFoundException, SQLException {
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
			data[i][3] = sign_Count.user_salary(data_query.get_nCount_signIn(user.getUserId(),date));
			System.out.println("´ÎÊý:"+data[i][3]+"      "+date);
			count++;
		}
		}
	//	table = new JTable(data,name);
//		scroll = new JScrollPane(table);
		
		
		return data;
	}
}
