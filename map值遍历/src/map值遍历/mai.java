package map值遍历;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mai {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("张三1", "男");
		map.put("张三2", "男");
		map.put("张三3", "男");
		map.put("张三4", "男");
		map.put("张三5", "男");
		map.put("张三6", "男");
		
		//通过键key获取到value
		for(String s:map.keySet()) {
			System.out.println("key:"+s+"  value:"+map.get(s));
		}
		System.out.println("=======================");
		
		//只遍历键或者值
		for(String s1:map.keySet()) {
			System.out.println("键key:"+s1);
		}
		for(String s2:map.values()) {
			System.out.println("值value:"+s2);
		}
		System.out.println("=======================");
		
		//Map.Entry<String,String>
		for(Map.Entry<String, String> entry:map.entrySet()) {
			System.out.println("键key："+entry.getKey()+"  值value:"+entry.getValue());
		}
		System.out.println("=======================");
		
		//Iterator遍历获取
		Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("键key："+entry.getKey()+"  值value:"+entry.getValue());
		}
	}
}
