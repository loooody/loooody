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
	private User user ;
	private Data_query data_query = new Data_query();
	private boolean flag = false;
	
/*
 * 判断是否有当前用户
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
 * 获取当前时间并返回
 */
	public String getTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(date);
		
		return time;
	}
	
	/*
	 * 用户注册
	 */
	public void user_Register(String name,String pwd) throws ClassNotFoundException, SQLException {
		int id = data_query.register_user_Id();
		int login = JOptionPane.showConfirmDialog(null, "是否注册此账号:\n用户ID:"+id+"\n用户名:"+name+"\n密码:"+pwd,"Register",JOptionPane.YES_NO_OPTION);
		if(login == 0) {
		data_query.user_add(String.valueOf(id), name, pwd);
		}
	}
	
	
	
}
