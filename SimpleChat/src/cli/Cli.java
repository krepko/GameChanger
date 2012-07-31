package cli;

import java.io.IOException;

public class Cli {

	public Cli()
	{

	}
	public void run_seq()
	{
		System.out.println("Which port?");
		int bytes_saved = 0;
		int the_byte = 0;
		while(the_byte != '\n')
		{
			try {
				the_byte = System.in.read();
				bytes_saved += 1; 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(bytes_saved);
	}
}
