package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import other.Notice;
import other.User;

public class Data_query {
	private List<User> list;
	private List<Notice> list_notice;
	private Statement statement = null;
	private ResultSet result = null;
	
	
	
	public List<User> getAllUser() throws ClassNotFoundException, SQLException{
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select * from user");
		
		while(result.next()) {
			String userId = result.getString("userId");
			String userName = result.getString("userName");
			String userPwd = result.getString("userPwd");
			String userGrade = result.getString("userGrade");
			
			User users = new User(userId,userName,userPwd,userGrade);
			list.add(users);
		}
		result.close();
		return list;
	}
	
	/*
	 * �����ݿ�notice���в��빫��
	 */
	public void insert_notice(String name,String context) {
		try {
			statement  = new DB_connect().DB_connect();
		//	String sqlstr = "insert into notice values("+name+","+context+")";
			statement.executeUpdate("insert into notice(notice_name,notice_context) values("+"'"+name+"'"+","+"'"+context+"'"+")");
			JOptionPane.showMessageDialog(null, "����ɹ�");
			statement.close();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "û���ҵ������", "error", 0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݲ���ʧ��", "error", 0);
		}
	}
	
	/*
	 * ��ѯ����
	 */
	public List<Notice> query_notice() throws SQLException, ClassNotFoundException {
		list_notice = new ArrayList<Notice>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select * from notice");
		
		while(result.next()) {
			String name = result.getString("notice_name");
			String context = result.getString("notice_context");
			
			Notice notice = new Notice(name,context);
			list_notice.add(notice);
		}
		result.close();
		return list_notice;
	}
	
	/*
	 * ������û�
	 */
	public void user_add(String id,String name,String pwd) {
		try {
			statement  = new DB_connect().DB_connect();
	//		JOptionPane.showMessageDialog(null, "����ɹ�","��������",JOptionPane.);
			int i = JOptionPane.showConfirmDialog(null, "�Ƿ���Ӵ��û�?\n�û�����"+name+"\n����:"+pwd,"�����û�",JOptionPane.YES_NO_OPTION);
			if(i == 0) {
			statement.executeUpdate("insert into user(userId,userName,userPwd) values("+"'"+id+"'"+","+"'"+name+"'"+","+"'"+pwd+"'"+")");
			JOptionPane.showMessageDialog(null, "����ɹ�");
			statement.close();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "û���ҵ������", "error",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݲ���ʧ��", "error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * ɾ���û�
	 */
	public void user_delete(String id,String name,String grade) {
		try {
			statement  = new DB_connect().DB_connect();
		//	String sqlstr = "insert into notice values("+name+","+context+")";
			int i = JOptionPane.showConfirmDialog(null, "�Ƿ���´��û���Ϣ?\n���ţ�"+id+"\n�û���:"+name+"\n�û�����:"+grade,"�����û�",JOptionPane.YES_NO_OPTION);
			System.out.println(i+"\n");
			if(i == 0) {
			statement.executeUpdate("delete from user where userId ="+"'"+id+"'");
			JOptionPane.showMessageDialog(null, "ɾ���û��ɹ�");
			statement.close();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "û���ҵ������", "error",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * �����û���Ϣ
	 */
	public void user_change_info(String id,String name,String pwd,String grade) {
		try {
			statement  = new DB_connect().DB_connect();
		//	String sqlstr = "insert into notice values("+name+","+context+")";
			int i = JOptionPane.showConfirmDialog(null, "�Ƿ���´��û���Ϣ?\n�û�����"+name+"\n����:"+pwd+"\n�û�����:"+grade,"�����û�",JOptionPane.YES_NO_OPTION);
			System.out.println(i+"\n");
			if(i == 0) {
			statement.executeUpdate("update user set userName = "+"'"+name+"' " +" , "+"userPwd ="+"' "+pwd+"'"+","
		                                 +"userGrade ="+"'"+grade+"' "+" where userId ="+"'"+id+"'");
			JOptionPane.showMessageDialog(null, "���³ɹ�");
			statement.close();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "û���ҵ������", "error",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ݸ���ʧ��","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * ǩ��
	 */
	public void signIn(String userId,String signIn,String signOut) {
		try {
			statement  = new DB_connect().DB_connect();
		//	String sqlstr = "insert into notice values("+name+","+context+")";
			int i = JOptionPane.showConfirmDialog(null, "ǩ��?","sign",JOptionPane.YES_NO_OPTION);
			System.out.println(i+"\n");
			if(i == 0) {
			statement.executeUpdate("insert into sign(userId,signIn_time,signOut_time) values("+"'"+userId+"'"+","+"'"+signIn+"'"+","+"'"+signOut+"'"+")");
			JOptionPane.showMessageDialog(null, "ǩ���ɹ�");
			statement.close();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "û���ҵ������", "error",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ݸ���ʧ��","error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * �����˲鿴ǩ�����
	 */
	public List<User> getAllSign_Charger() throws ClassNotFoundException, SQLException{
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select id,user.userId,userName,signIn_time,signOut_time from user,sign where user.userId = sign.userId");
		
		while(result.next()) {
			int id = result.getInt("id");
			String userId = result.getString("userId");
			String userName = result.getString("userName");
			String signIn = result.getString("signIn_time");
			String signOut = result.getString("signOut_time");
			
			User users = new User(id,userId,userName,signIn,signOut);
			list.add(users);
		}
		result.close();
		return list;
	}
	
	/*
	 * ǩ�����
	 */
	public List<User> getAllSign_Charger(String date) throws ClassNotFoundException, SQLException{
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select id,user.userId,userName,signIn_time,signOut_time from user,sign where user.userId = sign.userId "
												+ "and left(signIn_time,10) = "+"'"+ date+"'");
		
		
		while(result.next()) {
			int id = result.getInt("id");
			String userId = result.getString("userId");
			String userName = result.getString("userName");
			String signIn = result.getString("signIn_time");
			String signOut = result.getString("signOut_time");
			
			User users = new User(id,userId,userName,signIn,signOut);
			list.add(users);
		}
		result.close();
		return list;
	}
	/*
	 * ��ѯ�û�ǩ������
	 */
	public int get_nCount_signIn(String userId) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select user.userId,userName,userPwd,userGrade from sign,user where user.userId = sign.userId and user.userId = "+"'"+userId+"'");
		
		while(result.next()) {
			String Id = result.getString("userId");
			String userName = result.getString("userName");
			String userPwd = result.getString("userPwd");
			String userGrade = result.getString("userGrade");
			
			User users = new User(Id,userName,userPwd,userGrade);
			list.add(users);
		}
		result.close();
		return list.size();
	}
	
	/*
	 * ��ѯ�û�ǩ������
	 */
	public int get_nCount_signIn(String userId,String date) throws ClassNotFoundException, SQLException {
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select user.userId,userName,userPwd,userGrade from sign,user where user.userId = sign.userId and user.userId = "+"'"+userId+"'"
											+"and left(signIn_time,7) = "+"'"+date+"'");
		
		while(result.next()) {
			String Id = result.getString("userId");
			String userName = result.getString("userName");
			String userPwd = result.getString("userPwd");
			String userGrade = result.getString("userGrade");
			
			User users = new User(Id,userName,userPwd,userGrade);
			list.add(users);
		}
		result.close();
		return list.size();
	}
	
	/*
	 * ��ע���û�����һ��userId
	 */
	public int register_user_Id() throws ClassNotFoundException, SQLException{
		list = new ArrayList<User>();
		statement  = new DB_connect().DB_connect();
		result = statement.executeQuery("select * from user");
		
		
		while(result.next()) {
			String userId = result.getString("userId");
			String userName = result.getString("userName");
			String userPwd = result.getString("userPwd");
			String userGrade = result.getString("userGrade");
			
			User users = new User(userId,userName,userPwd,userGrade);
			list.add(users);
		}
		result.close();
		User user = list.get(list.size()-1);
		int ID = Integer.parseInt(user.getUserId());
		return ID+1;
	}
}
