package fileSharing;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class server implements Runnable {
	private static Socket socket;
	private static ServerSocket serverSock;
	private Thread thread = null;
	private static DataInputStream streamIn;
	private static DataOutputStream streamOut;
	private final static int PORT = 60534;
	private static ServerSocket serverListen;
	private final String handshakeStart = ("HI_THERE");
	private final String handshakeAck = ("BACK_AT_YA");
	private String clientUsername = null;
	private Scanner servScanner = null;
	private String serverUsername = null;

	private final static String badHandshake = ("ERROR BAD HANDSHAKE");

	public server(String serverUsername) throws Exception {
		
		try {
			System.out.println("Set server username");
			servScanner = new Scanner(System.in);
			this.setServerUsername(servScanner.nextLine()); 
			System.out.println("Binding to port " + PORT + ", please wait  ...");
			// initializing server socket

			System.out.println("Server started: " + this.getServerUsername());
			    serverSock = new ServerSocket(PORT);
			    socket = serverSock.accept();
			    
			  
			 // input comes in from client
				streamIn = new DataInputStream(null);
				streamOut = new DataOutputStream(null);
				System.out.println("Connection coming in from"
					 + this.getPort());
				//serverListen = new ServerSocket();
				//checks if server gets message HI_THERE <serverUsername>)
				  if (socket.getInputStream().equals(handshakeAck + this.serverUsername))
				    		{
					  		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					  		System.out.println("Sending acknowledge");
					  		out.println(handshakeAck + this.serverUsername);
					  		out.println(clientUsername);
				    		}
				  
				  else
				  {
					  //needs HI_THere in order to acknowldege
					  //returns badHandshake if not
					  System.out.println(badHandshake);
				  }
				
				
				socket.close();
				serverSock.close();
		}
		catch(Exception e)
		{
			
			System.out.println(badHandshake);
		}

		
	}

	public static Socket getSocket() {
		return socket;
	}

	public static ServerSocket getServer() {
		return serverSock;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public static DataInputStream getStreamIn() {
		return streamIn;
	}

	public static DataOutputStream getStreamOut() {
		return streamOut;
	}

	public static ServerSocket getServerListen() {
		return serverListen;
	}

	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	public String getServerUsername() {
		return serverUsername;
	}

	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}

	public int getPort() {
		return PORT;
	}

	public String getHandshakeStart() {
		return handshakeStart;
	}

	public String getHandshakeAck() {
		return handshakeAck;
	}

	public static String getBadhandshake() {
		return badHandshake;
	}

	public Scanner getServScanner() {
		return servScanner;
	}

	public void setServScanner(Scanner servScanner) {
		this.servScanner = servScanner;
	}

	@Override
	public void run() {

		try {
			server server0 = new server(this.getServerUsername(),
					server.getLocalPort());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
