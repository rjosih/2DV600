/**
 * 
 */
package re222gr_assign2.Ex02;

/**
 * @author rjosi
 *
 */
public class Bus extends Vehicle{
	// set bus prices
	public Bus() {
		this.setVehicleCost(200);
		this.setVehicleSpace(vehicleSpace);
		this.setMaxPassenger(20);
		this.setPassengerCost(10);
		this.setPassengerQuantity(passengerQuantity);
		this.setTotalSum(vehicleCost, passengerCost, passengerQuantity);
	}
}
