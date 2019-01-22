/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
public class Point {
	//instance variables
	private int posX = 0;
	private int posY = 0;

	public Point() {
	}

	public Point(int x, int y) {
		posX = x;
		posY = y;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// the task given from teacher, the mall 
		Point p1 = new Point();
		Point p2 = new Point(3, 4);
		System.out.println(p1.toString()); // ==> (0,0)
		System.out.println(p2.toString()); // ==> (3,4)
		if (p1.isEqualTo(p2)) // False!
			System.out.println("The two points are equal");
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance: " + dist);
		p2.move(5, -2); // ==> (8,2)
		p1.moveToXY(8, 2); // ==> (8,2)
		if (p1.isEqualTo(p2)) // True!
			System.out.println("The two points are equal");

	}

	// provide a new set of coordinates
	public void moveToXY(int x, int y) {
		posX = x;
		posY = y;
	}
	
	// if they have the same coordinates
	public void move(int x, int y) {
		posX += x;
		posY += y;
	}
	
	// distance between points (x,y) 
	public double distanceTo(Point p) {
		double difference;
		difference = Math.sqrt(Math.pow(posX - p.posX, 2) + Math.pow(posY - p.posY, 2));
		return difference;
	}

	// if x and y have the same coordinates
	public boolean isEqualTo(Point p) {
		return posX == p.posX && posY == p.posY;
	}
	
	// returns a string with coordinates suitable for print-outs
	public String toString() {
		return "(" + posX + "," + posY + ")";
	}
}
