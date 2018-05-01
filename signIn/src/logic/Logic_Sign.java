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
	
	
	
}
