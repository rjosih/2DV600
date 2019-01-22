/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
public class Invoice {
	/**
	 * @param args
	 */
	//instance variables
	private String partNumber;
	private String partDescription;
	private int partQuantity;
	private double pricePerItem;
	
	//constructor
	public Invoice(String part, String desc, int count, double price) {
		partNumber = part;
		partDescription = desc;
		partQuantity = count;
		pricePerItem = price;

		if (count < 0) {
			partQuantity = 0;
		}
		if (price < 0.0) {
			pricePerItem = 0.0;
		}
	}

	// set method partNumber
	public void setPartNumber(String number) {
		partNumber = number;
	}

	// get method partNumber
	public String getPartNumber() {
		return partNumber;
	}

	// set method partDescription
	public void setPartDescription(String desc) {
		partDescription = desc;
	}

	// get method partDescripton
	public String getPartDescription() {
		return partDescription;
	}

	// set method partQuantity
	public void setPartQuantity(int count) {
		partQuantity = count;
	}

	// get method partQuantity
	public int getPartQuantity() {
		return partQuantity;
	}

	// set method pricePerItem
	public void setPricePerItem(double price) {
		pricePerItem = price;
	}

	// get method pricePerItem
	public double getPricePerItem() {
		return pricePerItem;
	}

	// get method sum
	public double getInvoiceAmount() {
		double sum;
		sum = partQuantity * pricePerItem;
		return sum;

	}
}