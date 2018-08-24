package part01;

import java.util.ArrayList;

public class GenData {
	public static Supplier genSupOne() {
		// New Address
		Address ad1 = new Address(10, "Burns", "Belfast", "BT33 6QX", "Northern Ireland");

		// Create Products for ArrayList
		Product p1 = new Product(1, "Samsung", "S7 Edge", 570.00, 500, false);
		Product p2 = new Product(2, "iPhone", "iPhone X", 999.00, 20, false);
		Product p3 = new Product(3, "One Plus", "One Plus 5T", 500.00, 600, false);
		Product p4 = new Product(4, "Nokia", "3310", 20.00, 0, true);

		// Add the Products to the ArrayList
		ArrayList<Product> supProducts = new ArrayList<Product>();
		supProducts.add(p1);
		supProducts.add(p2);
		supProducts.add(p3);
		supProducts.add(p4);

		// Create new Supplier using Address and Product objects
		Supplier s = new Supplier("Currys", ad1, SupRegion.EUROPE, supProducts);
		
		return s;

	}
	public static Supplier genSupTwo() {
		Address ad2 = new Address(25, "Creed way", "Belfast", "BT33 H5T", "Northern Ireland");

		Product p1 = new Product(5, "Cay Horstmann", "Java Concepts: Early Objects", 30.00, 20, false);
		Product p2 = new Product(6, "Robert Sedewick", "Algorithms", 40.00, 50, false);
		Product p3 = new Product(7, "John L. Hennessy", "Computer Architecture", 45.50, 4, false);

		ArrayList<Product> supProducts = new ArrayList<Product>();
		supProducts.add(p1);
		supProducts.add(p2);
		supProducts.add(p3);

		Supplier s = new Supplier("WHS Smith", ad2, SupRegion.EUROPE, supProducts);
		
		return s;

	}
	public static Supplier genSupThree() {
	Address ad3 = new Address(60, "Sprucefield", "Lisburn", "BT40 9RV", "Northern Ireland");

	Product p1 = new Product(8, "Monitor", "Infinite Display 4K", 150, 300, false);
	Product p2 = new Product(9, "Mouse", "Scult Comfort Mouse", 34.99, 300, false);

	ArrayList<Product> supProducts = new ArrayList<Product>();
	supProducts.add(p1);
	supProducts.add(p2);

	Supplier s = new Supplier("Microsoft", ad3, SupRegion.UNITED_KINGDOM, supProducts);
	
	return s;
	} 
}