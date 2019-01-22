/**
 * 
 */
package re222gr_assign2.Ex02;

/**
 * @author rjosi
 *
 */
public class Lorry extends Vehicle{
	// set lorry prices
	public Lorry() {
		this.setVehicleCost(300);
		this.setVehicleSpace(vehicleSpace);
		this.setMaxPassenger(2);
		this.setPassengerCost(15);
		this.setPassengerQuantity(passengerQuantity);
		this.setTotalSum(vehicleCost, passengerCost, passengerQuantity);
	}
	
	public String returnVehicleType(){
		return "Type: Lorry";	
	}
}
