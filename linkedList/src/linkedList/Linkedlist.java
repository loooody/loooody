package linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Linkedlist {
	public static void main(String[] args) {
		List<String> a = new LinkedList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		
		List<String> b = new LinkedList<String>();
		b.add("A");
		b.add("B");
		b.add("C");
		b.add("D");
		
		//将两个链表合并
		ListIterator aIter = a.listIterator();
		ListIterator bIter = b.listIterator();
		
		while(bIter.hasNext()) {
			if(aIter.hasNext()) {
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		//从b中移除一部分数据
		bIter = b.listIterator();
		while(bIter.hasNext()) {
			bIter.next();
			if(bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
}
