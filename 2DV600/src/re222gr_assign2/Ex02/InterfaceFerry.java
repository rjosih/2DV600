/**
 * 
 */
package re222gr_assign2.Ex02;

/**
 * @author rjosi
 * @param <Count>
 *
 */
public interface InterfaceFerry<Count> extends Iterable<Vehicle> {
	 int countPassengers(); // Number of passengers on board
	 int countVehicleSpace(); // Used vehicle space. One car is 1.
	 int countMoney(Count c);
	 void embark(Vehicle v) throws Exception; // Embark vehicle, warning if not enough space
	 void embark(Passenger p) throws Exception;// Embark passenger, warning if not enough room
	 void disembark(); // Clear (empty) ferry. The money earned
	 // remains, i.e., is not reset to zero
	 boolean hasSpaceFor(Vehicle v); // true if we can embark vehicle v
	 boolean hasRoomFor(Passenger p); // true if we can embark passenger p
	 String toString(); // Nice looking ferry status print out
	}
