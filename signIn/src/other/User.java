package other;

import java.sql.Date;

public class User {
	private int id;
	private String userId;
	private String userName;
	private String userPwd;
	private String userGrade;
	private String signIn_time;
	private String signOut_time;
	
	
	public User(String userId, String userName, String userPwd, String userGrade) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userGrade = userGrade;
	}

	public User(int id,String userId, String userName,String signIn_time, String signOut_time) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.signIn_time = signIn_time;
		this.signOut_time = signOut_time;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getSignIn_time() {
		return signIn_time;
	}

	public void setSignIn_time(String signIn_time) {
		this.signIn_time = signIn_time;
	}

	public String getSignOut_time() {
		return signOut_time;
	}

	public void setSignOut_time(String signOut_time) {
		this.signOut_time = signOut_time;
	}
	
	
}
