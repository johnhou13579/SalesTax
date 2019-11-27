package houjonathan.liferay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

	static List<String> allLines;
	static List<Item> allItems = new ArrayList<Item>();

	public Reader() {

	}

	// Method gets the name of the input file and stores into the allLines List variable
	public void read() {

		// Gets file name located at root directory which contains purchased items.
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the input file?");
		String fileName = sc.nextLine();

		// Stores lines from input file into a List before performing split/delimiter functions.
		try {
			allLines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}

	// Method takes List allLines and changes them into Item classes. Stores into List of Item called allItems.
	public List<Item> parse() {
		for (String line : allLines) {

			// Parse quantity, name, and price from each line in List allLines.
			int quantity = Integer.parseInt(line.substring(0, 1));
			int idx = line.indexOf(" at ");
			String name = line.substring(2, idx);
			double price = Double.parseDouble(line.substring(idx + 3));

			// Creating Item and storing into a List allItems.
			Item temp = new Item(quantity, name, price);
			allItems.add(temp);
		}

		// Returns the list containing each Item in the shopping basket.
		return allItems;
	}

}
