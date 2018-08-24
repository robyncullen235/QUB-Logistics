package part02;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSystem {
	private static Scanner in = new Scanner(System.in);
	private static ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

	public static void main(String[] args) {
		Supplier s1 = GenData.genSupOne();
		Supplier s2 = GenData.genSupTwo();
		Supplier s3 = GenData.genSupThree();
		suppliers.add(s1);
		suppliers.add(s2);
		suppliers.add(s3);
		  
		runMenu(); 	
	}
	// This is how the menu will appear in the console. 
	public static void runMenu() {
		System.out.println("===================================");
		System.out.println("|          Welcome to our         |");
		System.out.println("|         Menu Application        |");
		System.out.println("===================================");
		System.out.println("[1] Print All Products");
		System.out.println("[2] Add New Supplier");
		System.out.println("[3] Add New Product");
		System.out.println("[4] Edit Supplier");
		System.out.println("[5] Delete Supplier");
		System.out.println("[6] Delete Product");
		System.out.println("[7] Search for Product");
		System.out.println("[8] Check Stock of Product");
		System.out.println("[9] Discontinued Products");
		System.out.println("[10] Exit");
		System.out.println("===================================");
		System.out.print("Enter Menu Option: ");

		// This ensures only a integer can be entered. 
		while (!in.hasNextInt()) {
			in.nextLine();
			System.out.println("Invalid selection, please enter a number.");
			System.out.println("Enter menu option: ");
		}
		// menuChoice ensures that the user input can only equal one of the cases. 
		int menuChoice = in.nextInt();
		in.nextLine();
		switch (menuChoice) {
		case 1:
			printProductList();
			break;
		case 2:
			addSupplier();
			break;
		case 3:
			addNewProduct();
			break;
		case 4:
			editSupplier();
			break;
		case 5:
			deleteSupplier();
			break;
		case 6:
			deleteProduct();
			break;
		case 7:
			searchProduct();
			break;
		case 8:
			checkStock();
			break;
		case 9:
			checkDiscontinued();
			break;
		case 10:
			System.out.println("Thank you for using our application. -Goodbye-");
			System.exit(0);
			break;
		default:
			System.out.println();
			System.out.println("Invalid selection, please try again.");
			runMenu();
		}

	}
	
	// This prints the discontinued products if the proDiscontinued equals true.
	public static void checkDiscontinued() {
		System.out.println("___________________________________");
		System.out.println("DISCONTINUED PRODUCTS  ");
		System.out.println("___________________________________");

		// Cycles through a for each loop to find if the proDiscontinued is true for every supProduct in the supplier.
		for (Supplier eachS : suppliers) {
			ArrayList<Product> products = eachS.getSupProducts();
			for (Product eachP : products) {
				if (eachP.isProDiscontinued() == true)
					System.out.println(eachP.getProductDetails());
				

			}
		}
		System.out.print("Press any key to return to menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}
	}

	/*
	 *  Cycles through a for each loop to find if the proCode equals the user input 
	 *  for any of the codes stored in the supProducts ArrayList
	 *  then prints the quantity available for the specific product. 
	 */
	public static void checkStock() {
		System.out.println("___________________________________");
		System.out.println("STOCK LEVELS");
		System.out.println("___________________________________");
		System.out.println("Enter the Product code you want to check the stock of: ");
		int chosenProMod = in.nextInt();

		for (Supplier eachS : suppliers) {
			ArrayList<Product> products = eachS.getSupProducts();
			for (Product eachP : products) {
				if (eachP.getProCode() == chosenProMod) {
					System.out.println("---STOCK REMANING---");
					System.out.println(eachP.getProQtyAvailable());

				}

			}
		}

		System.out.print("Press any key to return to menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}

	}

	// Edit a Supplier name
	public static void editSupplier() {
		System.out.println("___________________________________");
		System.out.println("EDIT SUPPLIER");
		System.out.println("___________________________________");
		System.out.print("Enter name of the Supplier you want to edit: ");
		String chosenSupName = in.nextLine();
		// sets boolean 
		boolean found = false;
		// Cycles through for loop to find the supplier name stored in the suppliers ArrayList 
		for (int i = 0; i < suppliers.size(); i++) {
			// If user input matches the supplier name in the application prompt user to enter new name.
			if (suppliers.get(i).getSupName().equals(chosenSupName)) {
				System.out.print("Enter the new Supplier name: ");
				String newSupName = in.nextLine();
				// This sets the supplier name to the user input and prints it out. 
				suppliers.get(i).setSupName(newSupName);
				System.out.println("Supplier Name: " + newSupName);

				// Space
				System.out.println();

				// Else if statement if supplier name found 
				if (found = true) {
					System.out.println("---Supplier name updated---");
				} else if (found == false) {
					System.out.println("---Error--- ");
					System.out.println("This Supplier does not exist. Please try again.");
				}
			}

		}
		runMenu();
	}

	// Delete a supplier 
	public static void deleteSupplier() {
		System.out.println("___________________________________");
		System.out.println("DELETE SUPPLIER");
		System.out.println("___________________________________");

		/*
		 *  For loop cycles through the first to the last supplier then gets the index of the 
		 *  Supplier in the ArrayList and prints the product list related to that supplier.
		 */
		System.out.println("Which Supplier do you want to delete?");
		for (int i = 0; i < suppliers.size(); i++) {
			System.out.println((i + 1) + ":");
			suppliers.get(i).printProductList();
		}
		// User enters choice (-1 ensures the correct supplier is deleted due to the offset)
		System.out.println("Enter Supplier number: ");
		int supplierNo = in.nextInt() - 1;
		in.nextLine();
		// the suppliers ArrayList gets the user input and deletes the supplier associated to that number.
		suppliers.get(supplierNo);
		suppliers.remove(supplierNo);
		
		runMenu();
	}

	public static void deleteProduct() {
		System.out.println("___________________________________");
		System.out.println("DELETE PRODUCT");
		System.out.println("___________________________________");

		System.out.println("Which Supplier do you want to delete a Product from?");
		for (int i = 0; i < suppliers.size(); i++) {
			System.out.println((i + 1) + ":");
			suppliers.get(i).printProductList();
		}
		System.out.println("Enter Supplier number: ");
		int supplierNo = in.nextInt() - 1;
		in.nextLine();
		suppliers.get(supplierNo);
		/*
		 *  This gets the user input and the supProducts associated with the supplier and stores it in a 
		 *  new Product ArrayList. A for each loop is used to get the index of the product and print 
		 *  the details of that product.
		 * */
		ArrayList<Product> proForSup = suppliers.get(supplierNo).getSupProducts();
		for (int i = 0; i < proForSup.size(); i++) {
			System.out.println((i + 1) + ":");
			System.out.println(proForSup.get(i).getProductDetails());
		}
		// User chooses product number 
		System.out.println("Enter Product Number: ");
		int proNo = in.nextInt();
		in.nextLine();
		// The proForSup ArrayList gets the product number the user entered and removes that product.
		proForSup.get(proNo);
		proForSup.remove(proNo);

		
		runMenu();
	}

	// Search for a product make
	public static void searchProduct() {
		System.out.println("___________________________________");
		System.out.println("SEARCH FOR PRODUCT MAKE");
		System.out.println("___________________________________");
		System.out.print("Please enter a product make you wish to find: ");
		String search = in.nextLine();

		int noMatches = 0;
		/*
		 * For each loop cycles through suppliers ArrayList then gets the supProducts of that supplier 
		 * For each product in the products Array List if the proMake matches the user input then print 
		 * product details for each product grouped by their supplier. 
		 */
		for (Supplier eachS : suppliers) {
			ArrayList<Product> products = eachS.getSupProducts();
			for (Product eachP : products) {
				if (eachP.getProMake().equalsIgnoreCase(search)) {
					System.out.println();
					System.out.println("---MATCH FOUND---");
					eachP.getProductDetails();
					System.out.println("in");
					eachS.printProductList();
					System.out.println("----------------------");
					noMatches++;

				}
			}
		}
		System.out.println(noMatches + " matches found for '" + search + "'");

		System.out.println("___________________________________");
		System.out.print("Press any key to return to menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}
	}

	public static void printProductList() {
		System.out.println();
		System.out.println("___________________________________");
		System.out.println("INFORMATION ON ALL PRODUCTS");
		System.out.println("___________________________________");
		for (Supplier eachS : suppliers) {
			eachS.printProductList();
		}
		System.out.println("___________________________________");
		System.out.print("Press any key to return to menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}
	}

	public static Address addAddress() {
		System.out.println("___________________________________");
		System.out.println("ADD NEW ADDRESS");
		System.out.println("___________________________________");

		System.out.print("Building Number: ");
		int bldNum = in.nextInt();
		in.nextLine();

		System.out.print("Street Name: ");
		String bldStreet = in.nextLine();
		// Validation - can only enter letters
		boolean badName = false;			
		
		for (int i = 0; i<bldStreet.length(); i++) {			
			if (!Character.isLetter(bldStreet.charAt(i))) {		
				badName = true;	
			}		
		}			
					
		if (badName) {			
			System.out.printf("Error, Invalid Character, try again");
			System.out.println();
			System.out.print("Street Name: ");
			 in.nextLine();
		} else {			
			System.out.println("Name Validated");		
		}			

		System.out.print("Town Name: ");
		//Validation - can only enter letters
		String bldTown = in.nextLine();
		boolean wrong = false;			
		
		for (int i = 0; i<bldTown.length(); i++) {			
			if (!Character.isLetter(bldTown.charAt(i))) {		
					wrong = true;	
			}		
		}			
					
		if (wrong) {			
			System.out.printf("Error, Invalid Character, try again");
			System.out.println();
			System.out.print("Town Name: ");
			 in.nextLine();
		} else {			
			System.out.println("Name Validated");		
		}		
		
		System.out.print("PostCode: ");
		String bldPcode = in.nextLine();

		System.out.print("Country: ");
		String bldCountry = in.nextLine();
		// Validation - can only enter letters
		boolean wrongName = false;			
		
		for (int i = 0; i<bldCountry.length(); i++) {			
			if (!Character.isLetter(bldCountry.charAt(i))) {		
				wrongName = true;	
			}		
		}			
					
		if (wrongName) {			
			System.out.printf("Error, Invalid Character, try again");
			System.out.println();
			System.out.print("Country: ");
			 in.nextLine();
		} else {			
			System.out.println("Name Validated");		
		}			

		// Create new address object
		Address newAdd = new Address(bldNum, bldStreet, bldTown, bldPcode, bldCountry);
		return newAdd;
	}

	public static void addSupplier() {
		System.out.println("___________________________________");
		System.out.println("ADD NEW SUPPLIER");
		System.out.println("___________________________________");

		System.out.print("Supplier Name: ");
		String supName = in.nextLine();
		// Validation - can only enter letters.
		boolean badN = false;			
	
		for (int i = 0; i<supName.length(); i++) {			
			if (!Character.isLetter(supName.charAt(i))) {		
				badN = true;	
			}		
		}			
					
		if (badN) {			
			System.out.printf("Error, Invalid Character, try again");
			System.out.println();
			System.out.print("Supplier Name: ");
			 in.nextLine();
		} else {			
			System.out.println("Name Validated");		
		}			
		System.out.println("Select region from list below");
		SupRegion[] supRegionVals = SupRegion.values();

		for (int i = 0; i < supRegionVals.length; i++) {
			System.out.printf("t%d: %s\n", i + 1, supRegionVals[i]);
		}
		System.out.print("Enter Region Number: ");
		SupRegion supRegion = null;
		int regionChoice = in.nextInt();
		in.nextLine();
		switch (regionChoice) {
		case 1:
			supRegion = SupRegion.EUROPE;
			break;
		case 2:
			supRegion = SupRegion.OUTSIDE_EU;
			break;
		case 3:
			supRegion = SupRegion.UNITED_KINGDOM;
			break;
		default:
			System.out.println("Invalid Region Choice, Please Start Again");
			runMenu();
		}
		ArrayList<Product> emptyProducts = new ArrayList<Product>();
		suppliers.add(new Supplier(supName, addAddress(), supRegion, emptyProducts));
		
		System.out.println("---Supplier added---");
		System.out.println();
		System.out.println("Press any key to return to main menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}
	}

	public static void addNewProduct() {
		System.out.println("___________________________________");
		System.out.println("ADD NEW PRODUCT");
		System.out.println("___________________________________");

		System.out.println("How many products do you want to add?: ");
		int loopCount = in.nextInt();
		in.nextLine();

		for (int i = 0; i < loopCount; i++) {
			System.out.println("Enter Product Code: ");
			int proCode = in.nextInt(); in.nextLine();

			System.out.println("Enter Product Make: ");
			String proMake = in.nextLine();

			System.out.println("Enter Product Model: ");
			String proModel = in.nextLine();

			System.out.println("Enter Product Price: ");
			double proPrice = in.nextDouble();

			System.out.println("Enter Quantity of Products Available: ");
			int proQtyAvailable = in.nextInt();
			in.nextLine();

			boolean proDiscontinued;

			if (proQtyAvailable == 0) {
				proDiscontinued = true;
			} else {
				proDiscontinued = false;
			}

			// Create new object and add to ArrayList
			Product new_product = new Product(proCode, proMake, proModel, proPrice, proQtyAvailable, proDiscontinued);

			System.out.println("Which Supplier should these products be assigned to?");
			for (int j = 0; j < suppliers.size(); j++) {
				System.out.println((j + 1) + ": ");
				System.out.println(suppliers.get(j).PrintSupplierDetails());
			}
			System.out.println();
			System.out.print("Enter Supplier number: ");
			int supplierNo = in.nextInt();

			Supplier myS = suppliers.get(supplierNo - 1);
			myS.getSupProducts().add(new_product);

		}
		System.out.println("---Products added---");
		System.out.println();
		System.out.println("Press any key to return to main menu: ");
		if (in.hasNextLine()) {
			in.nextLine();
			runMenu();
		}
	}

}
