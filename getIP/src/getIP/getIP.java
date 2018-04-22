package getIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getIP {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
	}
}
