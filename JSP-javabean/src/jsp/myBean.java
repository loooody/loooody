package jsp;

import java.io.Serializable;
public class myBean implements Serializable{
	private String name = null;
	private String pass = null;
	private int count = 0;
	
	public myBean() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getCount() {
		return count+1;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
