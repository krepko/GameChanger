package transport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ConnectionManager extends Thread {
	ServerSocket managerSocket = null;
	Socket connection = null;

	ObjectOutputStream out;
	ObjectInputStream manager_in_stream;

	public int the_port;

	boolean manager_exit = false;

	String message;

	public Client chat_sender = null;
	
	public ConnectionManager(String str, int a_port) {
		super(str);
		the_port = a_port;
	}
	
	//modtag connections, connect
	public void run() {
		boolean port_taken = false;
		
		while(!manager_exit)
		{
			try{
				//1. creating a server socket
				managerSocket = new ServerSocket(the_port, 100);
				System.out.println(managerSocket);

				//2. Wait for connection
				while(!manager_exit)
				{
					System.out.println("Waiting for connection");
					connection = managerSocket.accept();
					System.out.println("Connection received from " + connection.getInetAddress().getHostName());

					//3. get Input and Output streams
					out = new ObjectOutputStream(connection.getOutputStream());
					out.flush();
					manager_in_stream = new ObjectInputStream(connection.getInputStream());

					//4. The two parts communicate via the input and output streams
					try{
						message = (String)manager_in_stream.readObject();
						System.out.println("client>" + message);
						String messagePart[] = message.split(" ");
						for (int i = 0; i < messagePart.length; i++)
						{
							System.out.println(messagePart[i]);
						}
						chat_sender = new Client();
						chat_sender.start();
						
					}
					catch(ClassNotFoundException classnot){
						System.err.println("Data received in unknown format");
					}
				}

			}
			catch(IOException ioException){
				the_port += 1;
				port_taken = true;
				
			}
			finally{
				//4: Closing connection
				try{
					
					if (!port_taken)
					{
						manager_in_stream.close();
						out.close();
						managerSocket.close();
					}	

				}
				catch(IOException ioException){
					ioException.printStackTrace();
				}
			}
		}
	}

	
}
