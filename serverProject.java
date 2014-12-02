package fileSharing;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
public class server implements Runnable {
	private Socket	socket = null;
	private static ServerSocket server = null;
	private Thread thread = null;
	
	
	private final static int PORT = 60534;
	
	
	
	
	private final String badHandshake = ("ERROR BAD HANDSHAKE");
	
	public static void main(String[] args) throws Exception
	{
		 System.out.println("Binding to port " + PORT + ", please wait  ...");	 
	  //initializing server socket
         ServerSocket serverListen = new ServerSocket(PORT);  
         System.out.println("Server started: " + server);
         try {
        	 while (true) {
        		 System.out.println("Connection coming in from" + serverListen.getLocalPort());
        	 
        		 new serverThread(serverListen.accept().start();
        	 }
         }
         finally {
        	 //closes server socket
        	 serverListen.close();
         }
         
	}
	
//	thread works with setting up 
//	initilization strings of client and server names
//	and "hi there" and "back at ya" 
// 	as well as datainput stream
	
	private static class serverThread extends Thread	{
		private final String handshakeStart = ("HI_THERE");
		private final String handshakeAck = ("BACK_AT_YA");
		private String clientUsername;
		private String serverUsername = null;
		//datainput is coming into server
		//can use it to take input 
		private DataInputStream streamIn;
		try	{
			clientInput = new DataInputStream(serverListen.)
		}
		
	}
		
	
    
		
		
			


		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
