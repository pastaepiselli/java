package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
	// O(n^2)
	 public boolean containsDuplicate(int[] nums) {
	        for (int i = 0; i < nums.length; i++){
	            for (int j = i + 1; j < nums.length; j++){
	                if (nums[i] == nums[j]){
	                    return true;
	                }
	            }
	        }
	        return false;
	  }
	 // versione ottimizzata O(n)
	 public boolean containsDuplicateOpt(int[] nums) {
	        HashSet<Integer> hs = new HashSet<Integer>();
	        
	        for (int n : nums) {
				if (hs.contains(n)) {
					return true;
				}
				hs.add(n);
			}
	        return false;
	 }
	   
	
}
