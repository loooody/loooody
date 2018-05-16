package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.Data_query;
import other.User;

public class Logic_login {
	private List<User> list;
	private User user ;
	private Data_query data_query;
	private boolean flag = false;
	private String userName;
	private String userGrade;
	
	/*
	 * �жϵ�¼�Ƿ�ɹ�
	 */
	public boolean Login(String id,String pwd,String grade) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		data_query = new Data_query();
		list = data_query.getAllUser();
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
		System.out.println(user.getUserId()+"       "+user.getUserName()+"     "+user.getUserPwd()+"       "+user.getUserGrade()+"\n"+id.equals(user.getUserId())+"\n"+user.getUserPwd().equals(pwd));
		if(id.equals(user.getUserId())&&pwd.equals(user.getUserPwd())) {
			userName = user.getUserName();
			if(user.getUserGrade().equals("Admin")&&grade.equals("Admin")) {
				flag = true;
			}else if(user.getUserGrade().equals("Charger")&&grade.equals("Charger")) {
				flag = true;
			}else if(user.getUserGrade().equals("Employee")&&grade.equals("Employee")) {
				flag = true;
			}
	     }//System.out.println(flag);
		}
		return flag;
	}
			
	/*
	 * ��ȡ��ǰ�û������֣���ʾ�ڵ�¼����
	 */
	public String getName(String id) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		data_query = new Data_query();
		list = data_query.getAllUser();
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
		System.out.println(user.getUserName()+"     "+user.getUserPwd()+"       "+user.getUserGrade());
		if(id.equals(user.getUserId())) {
			userName = user.getUserName();	
	   }
	}
		return userName;
}
	
	
	/*
	 * �ж��Ƿ��е�ǰ�û�
	 */
	public boolean isUser(String id,String pwd) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		data_query = new Data_query();
		list = data_query.getAllUser();
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
		System.out.println(user.getUserName()+"     "+user.getUserPwd()+"       "+user.getUserGrade());
		if(id.equals(user.getUserId())&&pwd.equals(user.getUserPwd())) {
			flag = true;	
	   }
	}
		return flag;
}
	
	/*
	 * ��ȡ���û����û��ȼ�
	 */
	public String getGrade(String id,String pwd) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		data_query = new Data_query();
		list = data_query.getAllUser();
		for(int i=0;i<list.size();i++) {
			user = list.get(i);
		System.out.println(user.getUserName()+"     "+user.getUserPwd()+"       "+user.getUserGrade());
		if(id.equals(user.getUserId())&&pwd.equals(user.getUserPwd())) {
			userGrade = user.getUserGrade();	
	   }
	}
		return userGrade;
}
	
	
}
