package fileSharing;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client2client {
	private Socket socket = null;
	private DataInputStream streamIn = null;
	private DataOutputStream streamOut = null;
	private String fileName;
	private final String handshakeStart = ("HI_THERE");
	private final String handshakeAck = ("BACK_AT_YA");
	private String badHandhake = ("ERROR BAD HANDSHAKE");
	private final static int PORT = 60534;
	private Scanner clientScanner = null;
	private String clientName;
	private String serverName;

	public client2client(String clientName) {
		System.out.println("Set client username");
		clientScanner = new Scanner(System.in);
		this.clientName = clientScanner.nextLine();
		System.out.println("What is name of server you're connecting to?");
		this.serverName = clientScanner.nextLine();
		System.out.println("Establishing connection. Please wait ...");
		try {
			socket = new Socket(serverName, PORT);
			System.out.println("Connected: " + socket);
			start();
		} catch (Exception e) {
			System.out.println(badHandhake);
		}

		
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataInputStream getStreamIn() {
		return streamIn;
	}

	public void setStreamIn(DataInputStream streamIn) {
		this.streamIn = streamIn;
	}

	public DataOutputStream getStreamOut() {
		return streamOut;
	}

	public void setStreamOut(DataOutputStream streamOut) {
		this.streamOut = streamOut;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Scanner getClientScanner() {
		return clientScanner;
	}

	public void setClientScanner(Scanner clientScanner) {
		this.clientScanner = clientScanner;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void start() throws IOException {
		streamIn = new DataInputStream(System.in);
		streamOut = new DataOutputStream(socket.getOutputStream());
	}

	
	
}
