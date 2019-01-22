/**
 * 
 */
package re222gr_assign1;

import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class InvoiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// default
		Invoice invoice = new Invoice(" ", " ", 0, 0.0);
		Scanner scanner = new Scanner(System.in);

		String productNumber;
		String desc;
		int quantity;
		double price;
		
		// gets the product number from user
		System.out.print("Product number: ");
		productNumber = scanner.nextLine();
		invoice.setPartNumber(productNumber);
		
		// gets the description from user
		System.out.print("Description: ");
		desc = scanner.nextLine();
		invoice.setPartDescription(desc);

		// gets the product price from user
		System.out.print("Price for the product (in SEK)");
		price = scanner.nextInt();
		if (price > 0) {
			invoice.setPricePerItem(price);
		} else {
			price = 0;
		}

		// gets the product quantity from user
		System.out.print("Quantity of the product: ");
		quantity = scanner.nextInt();
		if (quantity > 0) {
			invoice.setPartQuantity(quantity);
		} else {
			quantity = 0;
		}
		//closes scanner
		scanner.close();
		
		//prints out the total sum for the customer
		System.out.print("Sum is " + invoice.getInvoiceAmount() + " SEK");
	}

}
