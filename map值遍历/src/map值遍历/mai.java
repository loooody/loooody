package mapֵ����;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mai {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("����1", "��");
		map.put("����2", "��");
		map.put("����3", "��");
		map.put("����4", "��");
		map.put("����5", "��");
		map.put("����6", "��");
		
		//ͨ����key��ȡ��value
		for(String s:map.keySet()) {
			System.out.println("key:"+s+"  value:"+map.get(s));
		}
		System.out.println("=======================");
		
		//ֻ����������ֵ
		for(String s1:map.keySet()) {
			System.out.println("��key:"+s1);
		}
		for(String s2:map.values()) {
			System.out.println("ֵvalue:"+s2);
		}
		System.out.println("=======================");
		
		//Map.Entry<String,String>
		for(Map.Entry<String, String> entry:map.entrySet()) {
			System.out.println("��key��"+entry.getKey()+"  ֵvalue:"+entry.getValue());
		}
		System.out.println("=======================");
		
		//Iterator������ȡ
		Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("��key��"+entry.getKey()+"  ֵvalue:"+entry.getValue());
		}
	}
}
