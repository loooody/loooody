package logic;

public class Logic_employee {
	/*
	 * �����û�����
	 */
	public String user_salary(int count) {
		int salary = 0;
		salary += 200 * count;
		
		return String.valueOf(salary);
	}
}
