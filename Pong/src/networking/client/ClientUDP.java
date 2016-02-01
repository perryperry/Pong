package networking.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import view.GameBoard;

public class ClientUDP implements Runnable
{
	Scanner kb = new Scanner(System.in);
	public ClientUDP(GameBoard gameBoard)
	{
		System.out.println("Enter Server's IP:");
		String serverHostname = kb.nextLine();
		
	}
	
	@Override
	public void run() 
	{
		
		
		
		
		
	}
	

}
