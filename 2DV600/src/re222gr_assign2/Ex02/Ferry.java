/**
 * 
 */
package re222gr_assign2.Ex02;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author rjosi
 *
 */
public class Ferry implements InterfaceFerry<Object> {

	ArrayList<Vehicle> vehicleList;
	ArrayList<Passenger> passengerList;
	ArrayList<Passenger> costList;
	private int maxSpaceVehicles;
	private int maxSpacePassengers;
	private int totalSum;
	private int usedSpaceVehicles;
	private int usedSpacePassengers;

	// default
	public Ferry() {
		// 50 cars = 400 bikes
		maxSpaceVehicles = 50;
		// 200 people
		maxSpacePassengers = 200;
		totalSum = 0;
		usedSpaceVehicles = 0;
		usedSpacePassengers = 0;
		vehicleList = new ArrayList<>();
		passengerList = new ArrayList<>();
		costList = new ArrayList<>();

	}

	@Override
	public Iterator<Vehicle> iterator() {
		return vehicleList.iterator();
	}

	// Number of passengers on board
	@Override
	public int countPassengers() {
		return passengerList.size();
	}

	// Used vehicle space. One car is 1.
	@Override
	public int countVehicleSpace() {
		return usedSpaceVehicles;
	}

	// Embark vehicle, warning if not enough space
	@Override
	public void embark(Vehicle v) throws Exception {
		this.usedSpaceVehicles++;
		if (this.usedSpaceVehicles > maxSpaceVehicles) {
			throw new Exception("Not enough space for more vehicles!!!!!");
		} else {
			vehicleList.add(v);
		}

	}

	// Embark passenger, warning if not enough room
	@Override
	public void embark(Passenger p) throws Exception {
		this.usedSpacePassengers++;
		if(this.usedSpacePassengers > maxSpacePassengers) {
			throw new Exception("Not enough space for more passengers!!!!!");
		}else {
			passengerList.add(p);
		}

	}

	// Clear (empty) ferry. The money earned
	// remains, i.e., is not reset to zero
	@Override
	public void disembark() {
		this.passengerList.clear();
		this.vehicleList.clear();
		this.usedSpacePassengers = 0;
		this.usedSpaceVehicles = 0;
	}

	// true if we can embark vehicle v
	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if(200 < vehicleList.size()) {
			return false;
		}
		return true;
	}

	// true if we can embark passenger p
	@Override
	public boolean hasRoomFor(Passenger p) {
		if(200 < passengerList.size()) {
			return false;
		}
		return true;
	}

	// Nice looking ferry status print out
	public String toString() {
		String ferryStatus;
		ferryStatus = "Total sum: " + totalSum + "\nVehicles onboard: " + usedSpaceVehicles + "\nPassengers onboard" + usedSpacePassengers;
		return ferryStatus;
	}


	public String costList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int costList(int i, int j) {
		int tot;
		tot = i + j;
		return tot;
	}

	public void countMoney(Cost c) {
		costList.add(c);
	}

	@Override
	public int countMoney(Object c) {
		// TODO Auto-generated method stub
		return 0;
	}



}