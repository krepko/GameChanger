import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
		DataComm dataComm;
		boolean i_am_sender = false;
		//System.out.println("ok lets gos");
		//char ch = (char) System.in.read();
		//System.out.println(ch);
		boolean exit_loop = false;
		Cli cli = new Cli();
		while(!exit_loop)
		{
			System.out.print("> ");
			String input = cli.readLine();
			if (input.equals("%exitnow"))
			{
				break;
			}
			
			
		}
		
		
		cli.run_seq();
		if (cli.port != 0)
		{
			new Receiver("Jamaica",cli.port).start();
			
		}
		else
		{
			//dataComm  = new Sender();
			//i_am_sender = true;
			cli.chat();
			
		}
		//while(true);
		System.out.println("im still alive");
		
	}

}
