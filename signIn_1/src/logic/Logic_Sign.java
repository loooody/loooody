package logic;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import DB.Data_query;
import other.User;


public class Logic_Sign {
	private List<User> list;
	private int id = 0;
	private String userId = "";
	private String userName = "";
	private String signIn_time = "";
	private String signOut_time = "";
	private User user = new User(id,userId,userName,signIn_time,signOut_time);
	private Data_query data_query = new Data_query();
	private boolean flag = false;
	
/*
 * �ж��Ƿ��е�ǰ�û�
 */
public boolean isUser(String id) throws ClassNotFoundException, SQLException {
	list = new ArrayList<User>();
	list = data_query.getAllUser();
	for(int i=0;i<list.size();i++) {
		user = list.get(i);
	System.out.println(user.getUserName()+"     "+user.getUserPwd()+"       "+user.getUserGrade());
	if(id.equals(user.getUserId())) {
		flag = true;	
   }
}
	return flag;
}

/*
 * ��ȡ��ǰʱ�䲢����
 */
	public String getTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(date);
		
		return time;
	}
	
	/*
	 * �û�ע��
	 */
	public void user_Register(String name,String pwd) throws ClassNotFoundException, SQLException {
		int id = data_query.register_user_Id();
		int login = JOptionPane.showConfirmDialog(null, "�Ƿ�ע����˺�:\n�û�ID:"+id+"\n�û���:"+name+"\n����:"+pwd,"Register",JOptionPane.YES_NO_OPTION);
		if(login == 0) {
		data_query.user_add(String.valueOf(id), name, pwd);
		}
	}
	
	/*
	 * �жϵ�ǰ���ݿ��Ƿ����и��û���ǩ����¼��������user��
	 */
public User getSignIn_info(String id,String date) throws ClassNotFoundException, SQLException {
		
		list = data_query.getAllSign_Employee(id, date);
	//	data = new Object[50][6];
	//	int count =1;
	//	System.out.println(list.size());
		if(list.size()>0) {
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
			System.out.println(user.getUserName());
			if(user.getUserId().equals(id)) {
				if(user.getSignIn_time().substring(0, 10).equals(date))
				break;
			//	return user;
			}
		}
		}
	//	JOptionPane.showMessageDialog(null, "ǩ��?");
	//	table = new JTable(data,name);
		System.out.println(user.getSignIn_time()+"     "+user.getSignOut_time());
//		scroll = new JScrollPane(table);
		
		
		return user;
		
	}
	
	
	
}
