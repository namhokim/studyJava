package ch11.no3.tdd;

import java.io.FileNotFoundException;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "C:/temp/gen3.txt";
		InputStreamNumberDataSource source = new InputStreamNumberDataSource(filename);
		VacantNumberFinder finder = new VacantNumberFinder(source);
		System.out.println("Vacant Number is " + finder.find());
		source.close();

	}

}
