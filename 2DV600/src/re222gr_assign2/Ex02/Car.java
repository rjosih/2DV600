/**
 * 
 */
package re222gr_assign2.Ex02;

/**
 * @author rjosi
 *
 */
public class Car extends Vehicle {
	// set car prices
	public Car() {
		this.setVehicleCost(100);
		this.setVehicleSpace(vehicleSpace);
		this.setMaxPassenger(4);
		this.setPassengerCost(15);
		this.setPassengerQuantity(passengerQuantity);
		this.setTotalSum(vehicleCost, passengerCost, passengerQuantity);
	}

}
