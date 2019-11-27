package houjonathan.liferay;

import java.util.List;

public class SalesTax {

	public static void main(String[] args) {
		/*
		 * Reads the name of file from the user. Parses the input and stores each
		 * variable to its own Item class. Stores all of the Items into a list.
		 */
		Reader rc = new Reader();
		rc.read();
		List<Item> il = rc.parse();

		/*
		 * Sales Tax and Import Duty set as final in Calculations class. The Taxes are
		 * calculated for each Item and determined if exempt. Prints receipt with the
		 * details for the shopping basket.
		 */
		Calculations c = new Calculations(il);
		c.printReceipt();
	}

}
