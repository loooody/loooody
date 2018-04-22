package 时间类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeTest {
	public static void main(String[] args) {
	Calendar time = Calendar.getInstance();
	//获取当前时间的年月日
	int year = time.get(time.YEAR);
	int month = time.get(time.MONTH)+1;
	int day = time.get(time.DATE);
	int hour = time.get(time.HOUR);
	int minute = time.get(time.MINUTE);
	int second = time.get(time.SECOND);
	
	System.out.println(year + "   " +month+ "   " +day+ "   " +hour+"   "+minute+"    "+ second +"   ");
	System.out.println("****************************");
	System.out.println();
	
	//显示当前时间
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String str = dateFormat.format(date);
	System.out.println(str);
	System.out.println("****************************");
	System.out.println();
	
	//将字符转换为时间
	String st = "2016-03-02";
	SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
	Date ymd = null;
	try {
		ymd = format.parse(st);
		System.out.println(ymd);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
