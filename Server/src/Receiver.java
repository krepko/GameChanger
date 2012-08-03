

import java.io.*;
import java.net.*;

public class Receiver extends Thread  {
	ServerSocket providerSocket;
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	int the_port;
	public boolean receiver_exit = false;

	public Receiver(String str, int a_port) {
		super(str);
		the_port = a_port;
	}
	public void run() {		
		receiver_loop(the_port);
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
	
	void receiver_loop(int port)
	{
		try{
			//1. creating a server socket
			providerSocket = new ServerSocket(port, 100);

			//2. Wait for connection
			while(!receiver_exit)
			{
				System.out.println("Waiting for connection");
				connection = providerSocket.accept();
				System.out.println("Connection received from " + connection.getInetAddress().getHostName());

				//3. get Input and Output streams
				out = new ObjectOutputStream(connection.getOutputStream());
				out.flush();
				in = new ObjectInputStream(connection.getInputStream());

				//4. The two parts communicate via the input and output streams

				message = (String)in.readObject();
				
			}
			

		}
		catch(IOException ioException){
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
}
