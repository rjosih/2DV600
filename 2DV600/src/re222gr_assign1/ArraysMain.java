/**
 * 
 */
package re222gr_assign1;


/**
 * @author rjosi
 *
 */

public class ArraysMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
       
        System.out.println("Max: " + Arrays.max(arr));
        System.out.println("Average: " + Arrays.average(arr));
        
        int[] rotated = Arrays.addN(arr, n);
        System.out.println("Rotated array: " + Arrays.toString(rotated));
        
        int[] reveresed = Arrays.reverse(arr);
        System.out.println("Reversed array: " + Arrays.toString(reveresed));
       
        int[] sorted = Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
        
        int[] subString = {1, 2, 3, 4, 5};
        int[] subString2 = {11, 2, 3, 4, 6};
       
        boolean sub = Arrays.hasSubsequence(subString, subString2);
        System.out.println("Sub: " + sub);
        
        int[] diff = Arrays.absDif(subString, subString2);
        System.out.println("Difference between arr and arr2 are " + Arrays.toString(diff));
        
        
              
	}
}
