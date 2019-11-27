package houjonathan.liferay;

import java.util.ArrayList;
import java.util.List;

public class Calculations {
	private final double salesTax = .10;
	private final double importDuty = .05;
	double totalSalesTax;
	double total;
	List<Item> il = new ArrayList<Item>();

	public Calculations(List<Item> il) {
		this.il = il;
	}

	public void printReceipt() {
		// Calculates the Tax/Duty and prints the result
		calculateTaxAndDuty();
		printResults();
	}

	public void calculateTaxAndDuty() {
		// For each item, calculate and store value of sales tax and import duty
		for (Item item : il) {
			double temp = item.getQuantity() * item.getPrice();

			// Calculating Sales Tax and Adds to Total Taxes
			if (!exempt(item)) {
				double tax = temp * salesTax;
				item.setAfterTax(tax);
				totalSalesTax += tax;
			}
			// Calculating Import Duty and Adds to Total Taxes
			if (imported(item)) {
				double tax = temp * importDuty;
				item.setAfterTax(roundToFive(tax));
				totalSalesTax += roundToFive(tax);
			}

			// Keeps track of total amount
			total += item.getAfterTax();
		}
	}

	public void printResults() {
		// For each item, the quantity, name, and after tax cost
		for (Item item : il) {
			System.out.print(item.getQuantity() + " ");
			System.out.print(item.getName() + ": ");
			System.out.println(String.format("%.2f", item.getAfterTax()));
		}

		// Prints Sales Tax and Total Amount
		System.out.println("Sales Taxes: " + String.format("%.2f", totalSalesTax));
		System.out.println("Total: " + String.format("%.2f", total));
	}

	// Returns true if item is exempt such as book, food, and pill
	public static boolean exempt(Item item) {
		if (item.getName().contains("book") || item.getName().contains("chocolate") || item.getName().contains("pill"))
			return true;
		return false;
	}

	// Returns true if item is imported
	public static boolean imported(Item item) {
		if (item.getName().contains("import"))
			return true;
		return false;
	}

	// Rounds up to nearest .05
	public static double roundToFive(double d) {
		return Math.ceil(d * 20) / 20.0;
	}

	public double getTotalSalesTax() {
		//Returns Error as -1 if negative number is inputed. 
		if(totalSalesTax<0)
			return -1;
		else
			return totalSalesTax;
	}

	public double getTotal() {
		//Returns Error as -1 if negative number is inputed. 
		if(total<0)
			return -1;
		else
			return total;
	}

	public String printTotalSalesTax() {
		return String.format("%.2f", totalSalesTax);
	}

	public String printTotal() {
		return String.format("%.2f", total);
	}

}
