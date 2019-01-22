/**
 * 
 */
package re222gr_assign2.Ex02;

import java.util.ArrayList;

/**
 * @author rjosi
 *
 */
public class Vehicle {
	// instance variables
	int vehicleCost;
	int vehicleSpace;
	int passengerCost;
	int maxPassenger;
	int passengerQuantity;
	int totalSum;
	private Passenger p;


	ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

	// default values
	public Vehicle() {
	}

	// constructor with six parameters
	public Vehicle(int vCost, int vSpace, int pCost, int mPassenger, int pQuantity, int tSum, Passenger passenger) {
		vehicleCost = vCost;
		vehicleSpace = vSpace;
		passengerCost = pCost;
		maxPassenger = mPassenger;
		passengerQuantity = pQuantity;
		totalSum = tSum;
		passenger = p;
	}

	// get vehicleCost
	public int getVehicleCost() {
		return vehicleCost;
	}

	// set vehicleCost
	public void setVehicleCost(int vehicleCost) {
		this.vehicleCost = vehicleCost;
	}

	// get vehicleCost
	public double getVehicleSpace() {
		return vehicleSpace;
	}

	// set vehicleCost
	public void setVehicleSpace(int vehicleSpace) {
		this.vehicleSpace = vehicleSpace;
	}

	// get passengerCost
	public int getPassengerCost() {
		return passengerCost;
	}

	// set passengerCost
	public void setPassengerCost(int passengerCost) {
		this.passengerCost = passengerCost;
	}

	// get passengerSpace
	public int getPassengerSpace() {
		return maxPassenger;
	}

	// set passengerSpace
	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}

	// get passengerQuantity
	public int getPassengerQuantity() {
		return passengerQuantity;
	}

	// set passengerQuantity
	public void setPassengerQuantity(int passengerQuantity) {
		this.passengerQuantity = passengerQuantity;
	}

	// validate the amount of quantity in the vehicle towards available seats
	public void addPassenger(Passenger passenger) throws Exception {
		if (passengerQuantity > maxPassenger) {
			throw new Exception("Can't take that many passengers");
		} else {
			passengerList.add(passenger);
		}
	}

	// set totalSum
	public int setTotalSum(int vehicleCost, int passengerCost, int passengerQuantity) {
		int totalSum;
		int passengerTotal = passengerCost * passengerQuantity;
		totalSum = vehicleCost + passengerTotal;
		return totalSum;
	}

	// presenting the info in a string
	public String toString() {
		return "Vehicle cost: " + vehicleCost + "\n" + "Vehicle space: " + vehicleSpace + "\n" + "Passenger cost: "
				+ passengerCost + "\n" + "Maximum for the vehicle: " + maxPassenger + "\n" + "Passenger quantity: "
				+ passengerQuantity + "\n" + "Total sum: " + totalSum;
	}
}
