package houjonathan.liferay;

public class Item {

	// Each Item variable
	private int quantity;
	private final String name;
	private double price;

	// Auto incrementing id
	private static int idIncrement;
	private int id;

	// Variables after tax included
	private double afterTax;

	// Constructor for Item and its respective attributes
	public Item(int quantity, String name, double price) {
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.afterTax = price;
		// Auto incrementing id using a static variable as a counter.
		this.id = idIncrement;
		idIncrement++;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public double getAfterTax() {
		return afterTax;
	}

	// Adds Sales and Duty tax with the current Item price.
	public void setAfterTax(double tax) {
		this.afterTax += tax;
	}

}
