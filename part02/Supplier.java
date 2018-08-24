package part02;

import java.util.ArrayList;

public class Supplier {
	private static int nextSupCode = 1;
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private ArrayList<Product> supProducts = new ArrayList<Product>();

	public Supplier(String supName, Address supAddress, SupRegion supRegion, ArrayList<Product> supProducts) {

		this.supCode = nextSupCode;
		nextSupCode++;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
	}

	public void printProductList() {
		System.out.println();
		System.out.println("Products from: " + this.getSupName() + " (" + supCode + ")");
		System.out.println("-----------------------------------");
		for (int i = 0; i < this.supProducts.size(); i++) {
			System.out.println(this.supProducts.get(i).getProductDetails());

		}

	}

	public String PrintSupplierDetails() {
		String line1 = "Supplier Code: " + "(" + supCode + ")";
		String line2 = "Supplier Name: " + getSupName();
		String line3 = "Supplier Address: " + getSupAddress().getFullAddress();
		String line4 = "Supplier Region: " + getSupRegion();
		return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4;

	}

	public int getSupCode() {
		return supCode;
	}

	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}

	public void supGenerator() {
		System.out.println(supName + " " + supAddress + " " + supRegion + " " + supProducts + "(" + supCode + ")");
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public Address getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}

	public SupRegion getSupRegion() {
		return supRegion;
	}

	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}

	public ArrayList<Product> getSupProducts() {
		return supProducts;
	}

	public void setSupProducts(ArrayList<Product> supProducts) {
		this.supProducts = supProducts;
	}

}
