import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Server started");
		ServerSocket ss = null;
		try {
			System.out.println(Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ss = new ServerSocket(5555);
			Socket s = ss.accept();
			s.setKeepAlive(true);
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(isr);
			
			System.out.println(bf.readLine());
			String line;
			while((line = bf.readLine()) != null) {
				
				System.out.println(line);
			}
			/*System.out.println("system opened");
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(isr);
			
			System.out.println(bf.readLine());
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server ended");

	}
}
