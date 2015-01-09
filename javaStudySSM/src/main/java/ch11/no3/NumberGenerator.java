package ch11.no3;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class NumberGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "gen.txt";
		long numbers = 10;
		if (args.length == 1) {
			filename = args[0];
		} else if(args.length == 2) {
			filename = args[0];
			numbers = Long.parseLong(args[1], 10);
		}
		generate(filename, numbers);

	}

	private static void generate(String filename, long numbers) throws FileNotFoundException {
		PrintStream ps = new PrintStream(filename);
		Random rand = new Random();
		for (long i=0; i<numbers; i++) {
			ps.println(Math.abs(rand.nextInt()));
		}
		ps.flush();
		ps.close();
		
	}

}
