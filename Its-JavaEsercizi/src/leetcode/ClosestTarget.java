package leetcode;

public class ClosestTarget {
	 public int closestTarget(String[] words, String target, int startIndex) {
	       int res = 1000000;
	       boolean trovato = false;
	       for (int i = 0; i < words.length; i++) {
	    	   if (words[i] == target) {
	    		   trovato = true;
	    		   
	    		   // movimento a destra
	    		   int d_mov = Math.abs(startIndex - i);
	    		   
	    		   // movimento a sinistra 
	    		   int s_mov = words.length - d_mov;
	    		   
	    		   res = Math.min(res, Math.min(d_mov, s_mov));
	    	   }
	       }
	       if (trovato) {
	    	   return res;
	       }
	       return -1;
	    	   
	    	   
	       
	    		   
	 }
}
