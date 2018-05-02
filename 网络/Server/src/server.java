import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome! The Server is running.....");
		ServerSocket server = new ServerSocket(5678);
		//监听并捕获一个连接到此端口的Socket
		Socket fromClient = server.accept();
//		System.out.println("Connected to the client....");
		InputStream inData  = fromClient.getInputStream();
		InputStreamReader isR = new InputStreamReader(inData);
		BufferedReader in = new BufferedReader(isR);
		
		OutputStream outData = fromClient.getOutputStream();
		PrintWriter out = new PrintWriter(outData,true);
		
	//	toClient.print("Type quit to STOP");
		
	//	Scanner data = new Scanner(inData);
		while(true) {
			//String line = data.nextLine();
			String str = in.readLine();
			System.out.println(str);
			out.println("has received.....");
			out.flush();
			
			if(str.equalsIgnoreCase("quit")) {
				
				break;
			}
			
		}fromClient.close();
	}
}
