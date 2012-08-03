package transport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread{
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	
	public void run() {	
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("localhost", 2100);
			System.out.println("Connected to localhost in port 2004");
			
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			//3: Communicating with the server
			do {
				try{
					message = (String)in.readObject();
					System.out.print("\n< " + message + "\n> ");
				}
				catch(ClassNotFoundException classnot){
					System.err.println("Data received in unknown format");
				}
			} while (!message.equals("%endtrans"));

		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try{
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		
	}
}
