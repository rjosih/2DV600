/**
 * 
 */
package re222gr_assign2.Ex02;

/**
 * @author rjosi
 *
 */
public class Bicycle extends Vehicle {
	// set bicycles prices
	public Bicycle() {
		this.setVehicleCost(25);
		this.setVehicleSpace(vehicleSpace);
		this.setMaxPassenger(1);
		this.setPassengerCost(25);
		this.setPassengerQuantity(passengerQuantity);
		this.setTotalSum(vehicleCost, passengerCost, passengerQuantity);
	}
	
	public String returnVehicleType(){
		return "Type: Bicycle";	
	}
}
