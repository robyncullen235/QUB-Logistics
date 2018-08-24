package part01;

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
	// Menu display 
	public static void runMenu() {
		System.out.println("===================================");
		System.out.println("|          Welcome to our         |");
		System.out.println("|         Menu Application        |");
		System.out.println("===================================");
		System.out.println("Options: ");
		System.out.println("[1] Print All Products");
		System.out.println("[2] Add New Supplier");
		System.out.println("[3] Add New Product");
		System.out.println("[4] Exit");
		System.out.println("===================================");
		System.out.println("Enter Menu Option: ");

		// While loop ensures input can only be an integer 
		while (!in.hasNextInt()) {
			in.nextLine();
			System.out.println("Invalid selection, please enter a number.");
			System.out.println("Enter menu option: ");
		}
		/* Switch statements which calls each method needed for the menu options to run.
		 * menuChoice ensures that user input can only be a number of one of the cases.
		 */
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
			System.out.println("Thank you for using our application. -Goodbye-");
			System.exit(0);
			break;
		default:
			System.out.println();
			System.out.println("Invalid selection, please try again.");
			runMenu();
		}

	}
	// For each Supplier in the suppliers ArrayList, print the products for them.  
	public static void printProductList() {
		System.out.println();
		System.out.println("___________________________________");
		System.out.println("INFORMATION ON ALL PRODUCTS");
		System.out.println("___________________________________");
		for (Supplier eachS : suppliers) {
			eachS.printProductList();
			
		}
		// Returns to main menu using any key. 
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

		System.out.print("Town Name: ");
		String bldTown = in.nextLine();

		System.out.print("PostCode: ");
		String bldPcode = in.nextLine();

		System.out.print("Country: ");
		String bldCountry = in.nextLine();
		
		// This adds the user input into a new Address object which is included in the Supplier object.
		Address newAdd = new Address(bldNum, bldStreet, bldTown, bldPcode, bldCountry);
		return newAdd;
	}

	public static void addSupplier() {
		System.out.println("___________________________________");
		System.out.println("ADD NEW SUPPLIER");
		System.out.println("___________________________________");
		
		System.out.print("Supplier Name: ");
		String supName = in.nextLine();

		System.out.println("Select region from list below");
		SupRegion[] supRegionVals = SupRegion.values();
		
		// For loop prints first supRegion value to the last.
		for (int i = 0; i < supRegionVals.length; i++) {
			System.out.printf("t%d: %s\n", i + 1, supRegionVals[i]);
		}
		System.out.print("Enter Region Number: ");
		SupRegion supRegion = null;
		int regionChoice = in.nextInt();
		in.nextLine();
		/* Switch statement to allow user to select an option of regions.
		 * This ensures they can only enter a region stored in the ENUM class.
		 */
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
		//ArrayList of emptyProducts is created as the products have not yet been created by the user.
		ArrayList<Product> emptyProducts = new ArrayList<Product>();
		//Adds the user input into a new Supplier object and adds it to the ArrayList suppliers.
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
		// LoopCount for the loop to remember how many times the user wants the For loop to loop.
		int loopCount = in.nextInt();
		in.nextLine();
		// Loop the following x amount of times according to user input for loopCount.
		for (int i = 0; i < loopCount; i++) {
			System.out.print("Enter Product Code: ");
			int proCode = in.nextInt(); 
			
			// So that the next user input isn't read before the integer. 
			in.nextLine();

			System.out.print("Enter Product Make: ");
			String proMake = in.nextLine();

			System.out.print("Enter Product Model: ");
			String proModel = in.nextLine();

			System.out.print("Enter Product Price: ");
			double proPrice = in.nextDouble();

			System.out.print("Enter Quantity of Products Available: ");
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
			// Prints supplier details for each supplier in the ArrayList.
			System.out.println("Which Supplier should these products be assigned to?");
			for (int j = 0; j < suppliers.size(); j++) {
				System.out.println((j + 1) + ": ");
				System.out.println(suppliers.get(j).PrintSupplierDetails());
			}
			// Gap between information.
			System.out.println();
			
			System.out.print("Enter Supplier number: ");
			// Users supplier choice 
			int supplierNo = in.nextInt(); in.nextLine();
			
			/*  -1 ensures that the product is added to the correct supplier.
			 *  This is because it needs to be 0 or 1 due to the offset. 
			 */
			Supplier myS = suppliers.get(supplierNo - 1);
			// Gets the list of products and adds the new product to the supProducts ArrayList.
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
