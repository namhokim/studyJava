package ch11.no3.tdd;

import java.io.FileNotFoundException;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "C:/temp/gen5e.txt";
		FileNumberDataSource source = new FileNumberDataSource(filename);
		VacantNumberFinder finder = new VacantNumberFinder(source);
		try {
			System.out.println("Vacant Number is " + finder.find());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			//source.close();
		}

	}

}
