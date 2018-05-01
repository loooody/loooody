package logic;

public class Logic_employee {
	/*
	 * 计算用户工资
	 */
	public String user_salary(int count) {
		int salary = 0;
		salary += 200 * count;
		
		return String.valueOf(salary);
	}
}
