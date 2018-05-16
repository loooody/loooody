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
	 * 判断登录是否成功
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
	 * 获取当前用户的名字，显示在登录窗口
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
	 * 判断是否有当前用户
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
	 * 获取该用户的用户等级
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
