import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class Send implements Runnable{
	private DatagramSocket ds;
	Send(DatagramSocket ds){
		this.ds = ds;
	}
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		String line = null;
		
		try {
			while((line = br.readLine())!=null) {
				if("886".equals(line)) 
					break;
					byte[] buf = line.getBytes();
					DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.164.1"),10007);
					ds.send(dp);
}
		} catch (IOException e) {
			System.out.println("∑¢ÀÕ∂À ß∞‹");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
	
	class Rece implements Runnable{
		private DatagramSocket ds;
		Rece(DatagramSocket ds){
			this.ds = ds;
		}
		
		public void run() {
			while(true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				try {
					ds.receive(dp);
				} catch (IOException e) {
					System.out.println("Ω” ’∂À ß∞‹");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				int port = dp.getPort();
				System.out.println(data.toUpperCase());
			}
		}
	}
	
	
public  class uSend {
	public static void main(String[] args) throws SocketException {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket = new DatagramSocket(10007);
		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receiveSocket)).start();
	}
}

