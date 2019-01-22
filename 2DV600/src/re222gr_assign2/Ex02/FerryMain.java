/**
 * 
 */
package re222gr_assign2.Ex02;

//import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class FerryMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		ArrayList passengerList = new ArrayList();
//		ArrayList vehicleList = new ArrayList();
		Ferry ferry = new Ferry();
		Scanner scanner = new Scanner(System.in);

		// passengers only quantity
		System.out.println("How many passengers without vehicles?");
		int passengersOnly;
		passengersOnly = scanner.nextInt();
		for (int i = 0; i < passengersOnly; i++) {
			ferry.embark(new Passenger());
			for (int j = 0; j < 25; j++) {
				ferry.countMoney(new Cost());
			}
		}

		// cars 
		System.out.println("How many cars?");
		int countCars = 0;
		int carsQuantity = scanner.nextInt();
		for (int i = 0; i < carsQuantity; i++) {
			System.out.println("how many persons in car number " + (ferry.vehicleList.size() + 1) + "?");
			countCars++;
			// persons in car
			int personsInCar = scanner.nextInt();
			if (personsInCar > 4) {
				throw new Exception("A car can only take 4 persons at most!!!!!!!!!!!");
			} else {
				// adding persons in car
				for (int j = 0; j < personsInCar; j++) {
					ferry.embark(new Passenger());
					// adding cost of persons in the cars
					for (int l = 0; l < 15; l++) {
						ferry.countMoney(new Cost());
					}
				}
				// adding cars
				for (int k = 0; k < carsQuantity; k++) {
					ferry.embark(new Vehicle());
					// cars cost
					for (int m = 0; m < 100; m++) {
						ferry.countMoney(new Cost());
					}
				}
			}
		}

		// bikes, since a bike needs one rider is the 1:1 on bike
		System.out.println("How many bicycles?");
		double bicycles;
		double bicylesInCars;
		bicycles = scanner.nextInt();
		// a bike = 1/5 of a car
		bicylesInCars = Math.ceil(bicycles / 5);
		for (int i = 0; i < bicylesInCars; i++) {
			ferry.embark(new Vehicle());
		}
		// adding passenger to bike
		for (int i = 0; i < bicycles; i++) {
			ferry.embark(new Passenger());
			for (int j = 0; j < 25; j++) {
				// add cost for persons and bike
				ferry.countMoney(new Cost());
				ferry.countMoney(new Cost());
			}
		}

		// busses
		System.out.println("How many busses?");
		int busses = scanner.nextInt();
		int bussesInCars = busses * 4;
		for (int i = 0; i < busses; i++) {
			System.out.println("how many persons in bus number " + (i+1) + "?");
			// persons in bus
			int personsInBus = scanner.nextInt();
			if (personsInBus > 20) {
				throw new Exception("A bus can only take 20 persons at most!!!!!!!!!!!");
			} else {
				// adding persons in car
				for (int j = 0; j < personsInBus; j++) {
					ferry.embark(new Passenger());
					// adding cost of persons in the cars
					for (int l = 0; l < 10; l++) {
						ferry.countMoney(new Cost());
					}
				}
				// adding busses in vehicleList
				for (int k = 0; k < bussesInCars; k++) {
					ferry.embark(new Vehicle());
				}
			}
		}
		// busses cost
		for(int l = 0; l < busses; l++) {
			for (int m = 0; m < 200; m++) {
				ferry.countMoney(new Cost());					
			}
		}
		
		// Lorry
		System.out.println("How many lorries?");
		int lorries = scanner.nextInt();
		int lorriesInCars = lorries * 8;
		for (int i = 0; i < lorries; i++) {
			System.out.println("how many persons in lorry number " + (i+1) + "?");
			// persons in lorry
			int personsInLorry = scanner.nextInt();
			if (personsInLorry > 2) {
				throw new Exception("A lorry can only take 2 persons at most!!!!!!!!!!!");
			} else {
				// adding persons in lorry
				for (int j = 0; j < personsInLorry; j++) {
					ferry.embark(new Passenger());
					// adding cost of persons in the cars
					for (int l = 0; l < 15; l++) {
						ferry.countMoney(new Cost());
					}
				}
				// adding busses
				for (int k = 0; k < (lorriesInCars); k++) {
					ferry.embark(new Vehicle());
				}
				// busses cost
				for (int m = 0; m < 300; m++) {
					ferry.countMoney(new Cost());
				}
			}
		}


		// presenting the ferry statuses
		System.out.println("Passenger quantity: " + ferry.passengerList.size());
		System.out.println("Vehicle quantity: " + ferry.vehicleList.size());
		System.out.println("Total sum: " + ferry.costList.size());		
		
		ferry.disembark();
		System.out.println("\nDISEMBARKED\n");
		System.out.println("Passenger quantity: " + ferry.passengerList.size());
		System.out.println("Vehicle quantity: " + ferry.vehicleList.size());
		System.out.println("Total sum: " + ferry.costList.size());


	}

}
