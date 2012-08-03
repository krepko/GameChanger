import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import transport.ConnectionManager;
import transport.DataComm;
import transport.Receiver;
import transport.Sender;
import cli.Cli;


public class init {
	
	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		/*
		int MANAGER_PORT = 2100;
		boolean exit_loop = false;
		Receiver chat_receiver = null;
		
		Cli cli = new Cli();
		ConnectionManager connectionManager = new ConnectionManager("ConnectionManager",MANAGER_PORT);
		connectionManager.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(!exit_loop)
		{
			System.out.print("> ");
			String input_string = cli.readLine();
			if (input_string.equals("%exitnow"))
			{
				break;
			}
			
			else if (input_string.startsWith("%connectnow"))
			{
				chat_receiver = new Receiver("Receiver",2200);
				chat_receiver.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Sender sender = new Sender(2100);
				sender.sendMessage(input_string);
				sender.closeConnection();
				
			}
			
			else if (connectionManager.chat_sender == null)
			{
				if (chat_receiver != null)
				{
					chat_receiver.sendMessage(input_string);
				}
			}
			else
			{
				connectionManager.chat_sender.sendMessage(input_string);
			}
			
		}
		*/
		Sender sender = new Sender(2000);
		sender.sendMessage("this is sparta");
		sender.closeConnection();
	}

}
