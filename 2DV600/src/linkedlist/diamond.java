package linkedlist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class diamond {

	public static void main(String[] args) {
		System.out.print("Provide an odd integer: ");
		Scanner scan = new Scanner(System.in); 
		int n = scan.nextInt();	
		
		try {
			if(n % 2 == 0 || n<0) {
				System.out.println("IS NOT AN ODD NUMBER");
			}else {
		        for (int i = -n; i <= n; i++) {
		            for (int j = -n; j <= n; j++) {
		                if (Math.abs(i) + Math.abs(j) <= n) System.out.print("*");
		                else System.out.print(" ");
		            }
		            System.out.println();
		        }
			}
		}catch(InputMismatchException exception) {
			System.out.println("NEED TO BE A NUMBER");
		}
	}
}
