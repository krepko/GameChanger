package transport;

import java.io.*;
import java.net.*;


public class Sender {
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;

	public Sender(int port) //init connection
	{
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("localhost", port);
			System.out.println("Connected to localhost in port 2004");
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server

			//out.writeObject(msg);
			//out.flush();
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	public void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		try{
			in.close();
			out.close();
			requestSocket.close();
			System.out.println("sender closing connection");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}