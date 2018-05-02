import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",5678);
		//获取socket发送的信息
		InputStream inData = client.getInputStream();
		InputStreamReader isR = new InputStreamReader(inData);
		BufferedReader in = new BufferedReader(isR);
		//获取socket接受的信息
		
		
		OutputStream outData = client.getOutputStream();
		PrintWriter toServer = new PrintWriter(outData);
		
		//获取用户输入的信息
		InputStreamReader userData = new InputStreamReader(System.in);
		BufferedReader wt = new BufferedReader(userData);
		System.out.println("Type quit to STOP");
		while(true) {
			String str = wt.readLine();
			toServer.println(str);
			toServer.flush();
			if(str.equals("quit")) {
				break;
			}
			System.out.println(in.readLine());
		}
		client.close();
		
	}
}
