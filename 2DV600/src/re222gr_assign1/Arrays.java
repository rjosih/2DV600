/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
public class Arrays {
	// return average value from arr
	public static int average(int[] arr) {
	    int sum = 0;
	    for (int value : arr) {
	        sum += value;
	    }

	    int average = 0;
		if (arr.length > 0) {
			average = sum / arr.length;
		}
		return average;
	}
	
	// return the max value from arr
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	// rotate the arr
	public static int[] addN(int[] arr, int n) {
		for(int i = 0; i< arr.length; i++){
			arr[i]= arr[i]+ n;
		}
		return arr;
	}

	public static int[] reverse(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i = arr.length, j = 0; i > 0; i--, j++)
			newArr[j] = arr[i - 1];
		return newArr;
	}

		//replace all the occurences, old with new
	public void replaceAll(int[] arr, int old, int nw) {
		for (int i = 0; i < arr.length; i++) {
			int pick = arr[i];
			if (pick == old)
				arr[i] = nw;
		}
		return;
	}

	// sort array, from least to most
	public static int[] sort(int[] arr) {
		int[] newArr = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (newArr[i] > newArr[j]) {
					int s = newArr[i];
					newArr[i] = newArr[j];
					newArr[j] = s;
				}
			}
		}
		return newArr;
	}
	
	// checks if some substring in string1 are the same in string2
	public static boolean hasSubsequence(int[] arr, int[] sub) {
		String string1 = ""; 
		String string2 = "";
		for (int i = 0; i < arr.length; i++) {
			string1 = string1 + arr[i]; 
		}
		
		for (int i = 0; i < sub.length; i++) { 
			string2 = string2 + sub[i]; 
		}
		return string1.contains(string2);
	}
	
	// difference between arr1 and arr2
	public static int[] absDif(int[] arr1, int[] arr2) {
		int[] diffArr = new int[arr1.length];
		if(arr1.length != arr2.length) {
			try {
				// if arr1 and arr2 are not same format
				throw new Exception("NOT SAME FORMAT HEHE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(arr1.length == arr2.length){
			for(int i = 0; i < arr1.length; i++){
				diffArr[i] = Math.abs(arr1[i] - arr2[i]);
			}
		}
		return diffArr;
	}

		// presenting the arr in string format
	public static String toString(int[] arr) {
	    if (arr.length <= 0){
	      return "[]";
	    }
	    String stringArr = "[" + arr[0];
	    for (int row = 1; row < arr.length; ++row){
	      stringArr += ", " + arr[row];
	    }
	    stringArr = stringArr+ "]";
	    return stringArr;
	  }
	}

