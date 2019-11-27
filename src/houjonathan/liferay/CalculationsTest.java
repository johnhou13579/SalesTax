package houjonathan.liferay;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CalculationsTest {

	//Test for Total Price Input1.txt
	@Test
	void test() {
		List<Item> sc = new ArrayList<Item>();
		Item s = new Item(1, "book", 12.49);
		Item s2 = new Item(1, "music CD", 14.99);
		Item s3 = new Item(1, "chocolate bar", 0.85);
		sc.add(s);
		sc.add(s2);
		sc.add(s3);
		Calculations test = new Calculations(sc);
		test.calculateTaxAndDuty();
		assertEquals("29.83", test.printTotal());		
		assertEquals("1.50", test.printTotalSalesTax());
	}
	
	//Test for Total Price Input2.txt
	@Test
	void test2() {
		List<Item> sc = new ArrayList<Item>();
		Item s = new Item(1, "imported box of chocolates", 10.00);
		Item s2 = new Item(1, "imported bottle of perfume", 47.50);
		sc.add(s);
		sc.add(s2);
		Calculations test = new Calculations(sc);
		test.calculateTaxAndDuty();
		assertEquals("65.15", test.printTotal());
		assertEquals("7.65", test.printTotalSalesTax());
	}
	
	//Test for Total Price Input3.txt
	@Test
	void test3() {
		List<Item> sc = new ArrayList<Item>();
		Item s = new Item(1, "imported bottle of perfume", 27.99);
		Item s2 = new Item(1, "bottle of perfume", 18.99);
		Item s3 = new Item(1, "packet of headache pills", 9.75);
		Item s4 = new Item(1, "imported box of chocolates", 11.25);
		sc.add(s);
		sc.add(s2);
		sc.add(s3);
		sc.add(s4);
		Calculations test = new Calculations(sc);
		test.calculateTaxAndDuty();
		assertEquals("74.68", test.printTotal());
		assertEquals("6.70", test.printTotalSalesTax());
	}
	
	//Test for Custom
	@Test
	void test4() {
		List<Item> sc = new ArrayList<Item>();
		Item s = new Item(1, "bottle of perfume", 0);
		Item s2 = new Item(1, "bottle of perfume", 0);
		sc.add(s);
		sc.add(s2);
		Calculations test = new Calculations(sc);
		test.calculateTaxAndDuty();
		assertEquals("0.00", test.printTotal());
		assertEquals("0.00", test.printTotalSalesTax());
	}

}
