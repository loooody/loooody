package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import DB.Data_query;
import other.Notice;
import other.User;

public class Logic_query_notice {
	private Data_query data_query = new Data_query();
	private JTable table;
	private List<Notice> list = new ArrayList<Notice>();
	private Notice notice;
	private Object[][] data;
	private JScrollPane scroll;
	
	public JTable Logic_query_notice(String[] name) throws ClassNotFoundException, SQLException {
	list = data_query.query_notice();
	data = new Object[50][2];
	int count =1;
	System.out.println(list.size());
	if(list.size()>0) {
	for(int i=0;i<list.size();i++) {
		notice = list.get(i);
//		System.out.println(notice.getUserName());
		data[i][0] = notice.getNotice_name();
		data[i][1] = notice.getNotice_context();
	}
	}
	table = new JTable(data,name);
//	scroll = new JScrollPane(table);
	
	
	return table;
	}
}
