import java.io.IOException;
import cli.Cli;


public class init {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//System.out.println("ok lets gos");
		//char ch = (char) System.in.read();
		//System.out.println(ch);
		Cli cli = new Cli();
		cli.run_seq();
	}

}
