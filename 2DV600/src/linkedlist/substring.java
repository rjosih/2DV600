package linkedlist;

public class substring {
	
	public static void main(String[] args) {
				System.out.println(hasSubstring("Hello World!", "Hel"));
				System.out.println(hasSubstring("Hello World!", "lo W"));
				System.out.println(hasSubstring("Hello World!", "Hej"));
				System.out.println(hasSubstring("Hello World!", "world"));
	}
	public static boolean hasSubstring(String str, String sub) {
		return str.contains(sub);
	}

}
