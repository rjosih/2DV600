/**
 * 
 */
package re222gr_assign1;

import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class TimeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hours;
		int minutes;
		int seconds;
		
		// user choose how many seconds
		System.out.print("Seconds: ");
		seconds = scanner.nextInt();
		
		// object timeA
		Time timeA = new Time(seconds);
	
		int newTime = seconds % 60;
		for(int j = 0; j < newTime; j++) {
			timeA.tick();
		}
		
		// prints out time for timeA
		for (int i = 0; i < 10; i++) {
			timeA.tick();
			System.out.println(timeA.getHours() + ":" + timeA.getMinutes() + ":" + timeA.getSeconds());
		}

		// time input for timeB
		System.out.print("Hours: ");
		hours = scanner.nextInt();

		System.out.print("Minutes: ");
		minutes = scanner.nextInt();

		System.out.print("Seconds: ");
		seconds = scanner.nextInt();
		
		// new timeB
		Time timeB = new Time(hours, minutes, seconds);
		
		// presenting the time
		timeB.tick();
		System.out.println("Before convert: " + timeB.getHours() + ":" + timeB.getMinutes() + ":" + timeB.getSeconds());
		
		// sum of timeA and timeB
		System.out.println("Sum of timeA and timeB: " + timeA.addTime(timeB));
		

		// object timeC tells the difference between timeA and timeB 
		String timeC = timeA.subtractTime(timeB);
			System.out.println("Difference between timeA to timeB: " + timeA.subtractTime(timeB));
			
		// closes scanner
		scanner.close();
		}
		
	}

