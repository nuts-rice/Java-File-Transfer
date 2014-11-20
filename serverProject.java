import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
public class serverProject implements Runnable {
	private Socket	socket = null;
	private ServerSocket server = null;
	private Thread thread = null;
	//datainput is coming into server
	private DataInputStream streamIn = null;
	private final PORT = 60534;
	private final String handshakeStart = ("HI_THERE");
	private final String handshakeAck = ("BACK_AT_YA");
	private String clientUsername= null;
	private String serverUsername = null;
	private final String badHandshake = ("ERROR BAD HANDSHAKE");
	
	public FileServer(int PORT)
	{
		try
      { 
	  System.out.println("Binding to port " + port + ", please wait  ...");
	  //initializing server socket
         server = new ServerSocket(port);  
         System.out.println("Server started: " + server);
         start();
      }
      catch(IOException ioe)
      {  System.out.println(ioe); 
		 System.out.println(badHandshake);
		 
      }
   }
		
		
		while (true)
		{
			System.out.println("Connection coming in from" + soc.getLocalPort());
			Socket soc = server.accept(); //takes in clients 
			System.out.println(
			
			try
			{
				String line = 
			
