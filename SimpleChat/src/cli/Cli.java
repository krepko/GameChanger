package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import transport.DataComm;
import transport.Sender;

public class Cli {
	public int port;

	public Cli()
	{

	}
	public void run_seq()
	{
		char data[] = new char[5];
		System.out.println("Which port?");
		int bytes_saved = 0;
		int the_byte = 0;
		while(the_byte != '\n')
		{
			try {
				the_byte = System.in.read();
				data[bytes_saved] = (char) the_byte;
				bytes_saved += 1;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		char[] dummy = new char[bytes_saved-1];
		for (int i = 0; i < dummy.length; i++)
		{
			dummy [i] = data[i];
		}

		String string_port = String.copyValueOf(dummy);
		System.out.println(string_port);
		port = Integer.parseInt(string_port);
	}

	public void chat()
	{	
		Sender sender = new Sender(2004);
		while(true)
		{
			try {
				System.out.print("me> ");
				String keyboard_string = readLine();
				sender.sendMessage(keyboard_string);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String readLine() throws IOException
	{
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);

		return in.readLine();
	}
}
