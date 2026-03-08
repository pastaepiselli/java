package leetcode;

public class ChangesToMakeAltenatingBinaryString {
	public static void main(String[] args) {
		minOperations("1111");
	}
	public static int minOperations(String s) {
	       int counter = 0;
	        for  (int i = 1; i < s.length(); i++){
	            char prev = s.charAt(i - 1);
	            char cur = s.charAt(i);
	            if (prev == cur){ // nn va bene :(
	                counter++;
	                if (cur == '0'){
	                    s.charAt(i - 1);
	                } else {
	                    s.charAt(i);
	                }
	                
	            }
	        }
	        System.out.println(s);
	        return counter; 
	    }
}
