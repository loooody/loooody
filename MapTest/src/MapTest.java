import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,Employee> staff = new HashMap<String,Employee>();
		staff.put("144", new Employee("lv"));
		staff.put("145", new Employee("l"));
		staff.put("147", new Employee("lvds"));
		staff.put("149", new Employee("lvfds"));
		staff.put("150", new Employee("lvg"));
		staff.put("154", new Employee("lvxv"));
		staff.put("14", new Employee("lvvxbdf"));
		
		
		System.out.println(staff);
		
		staff.remove("144");
		
		staff.put("14", new Employee("7898"));
		
		System.out.println(staff.get("149"));
		
		for(Map.Entry<String, Employee> entry:staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key:"+key+",value:"+value);
		}
		
		
	}
	
}
