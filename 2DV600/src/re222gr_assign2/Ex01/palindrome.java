package re222gr_assign2.Ex01;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean isPalindrome(String[] array) {
	    for (int i = 0; i < array.length / 2; i++) {
	        if(!array[i].equals(array[array.length - 1 - i])) {
	            return false;
	        }
	    }
	    
	    return true;
	}

}
