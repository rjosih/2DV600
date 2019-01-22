/**
 * 
 */
package re222gr_assign2.Ex01;

import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class CollectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (;;) {
			ArrayIntStack intStack = new ArrayIntStack();
			ArrayIntList intList = new ArrayIntList();
			System.out.println("1 - IntStack " + "\n" + "2 - IntList");

			Scanner scanner = new Scanner(System.in);
			int stackOrList;
			stackOrList = scanner.nextInt();
			
			//intStack default values
			intStack.push(3);
			intStack.push(2);
			intStack.push(4);
			
			//intList default values 
			intList.add(2);
			intList.add(10);
			intList.add(5);
			
			if (stackOrList == 1) {
				System.out.println("IntStack is choosen");
				System.out.println("1 - push" 
				+ "\n" 
				+ "2 - pop" 
				+ "\n"
				+ "3 - peek"
				+ "\n" 
				+ "4 - get size"
				+ "\n"
				+ "5 - if list is empty"
				+ "\n" 
				+ "6 - show  string");
				
				int stackChoice;
				stackChoice = scanner.nextInt();
				
				// push 
				if(stackChoice == 1) {
					// default to be pushed
					intStack.push(1);
					System.out.println("IntStack: " + intStack);
				// pop
					
				}else if(stackChoice == 2) {
					System.out.println("IntStack before: " + intStack);
					 intStack.pop();
					 System.out.println("IntStack: " + intStack);
				// peek
				}else if(stackChoice == 3) {
					intStack.peek();
					System.out.println("IntStack: " + intStack);
				// get size
				} else if(stackChoice == 4) {
					System.out.println("Size of intStack: " + intStack.size());		
				// check if its empty
				} else if(stackChoice == 5) {
					System.out.print("Is intStack empty?" + intStack.isEmpty());
				// shows the intStack
				} else if(stackChoice == 6) {
					System.out.println(intStack);
				}	
				System.exit(stackOrList);
			} else if (stackOrList == 2) {
				System.out.println("IntList is choosen");
				System.out.println("1 - add number" 
				+ "\n" 
				+ "2 - add at index" 
				+ "\n"
				+ "3 - remove"
				+ "\n" 
				+ "4 - get number with index"
				+ "\n"
				+ "5 - size"
				+ "\n" 
				+ "6 - if list is empty"
				+ "\n"
				+ "7 - show string");
				int listChoice;
				listChoice = scanner.nextInt();
				
				// add a number
				if(listChoice == 1) {
					// default 1 to be added
					intList.add(1);
					System.out.println("IntList: " + intList);
				// add number at chosen index
				}else if(listChoice == 2) {
					// default to add 1 on index 2
					intList.addAt(1, 2);
					System.out.println("IntList: " + intList);
				// remove at index
				} else if(listChoice == 3) {
					// default value 1
					intList.remove(1);
					// the removed value will appear as a 0 in the end
					System.out.println("IntList: " + intList);
				// get value from index
				} else if(listChoice == 4) {
					//default 1
					int indexNumber = 1;
					intList.get(indexNumber);
					System.out.println("IntList's value of index " + indexNumber + " is " + intList.get(1));
				// size of the list
				} else if(listChoice == 5) {
					System.out.println("Size of intList: " + intList.size());
				// checks if its empty
				}else if(listChoice == 6) {
					System.out.print("Is intList empty? " + intList.isEmpty());
				// shows the list
				}else if(listChoice == 7) {
					System.out.print("IntList: " + intList);
				}
				System.exit(stackOrList);
			} else {
				System.out.println("The answer is not 1 or 2, please try again");
			}
			scanner.close();
		}
	}

}
