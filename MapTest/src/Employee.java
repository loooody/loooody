
public class Employee {
	private String name;
	private int salary;
	
	public Employee(String n) {
		name = n;
		salary = 0;
	}
	
	public String toString() {
		return "name="+name+"  salary="+salary;
	}
}
