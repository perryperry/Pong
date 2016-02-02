import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PongMain {

	private final static int PORT = 22222;
	
	public static void main(String[] args) 
	{
		Socket connection;
		try {
			ServerSocket server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
