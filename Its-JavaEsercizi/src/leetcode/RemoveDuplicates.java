package leetcode;

public class RemoveDuplicates {
	 public int removeDuplicates(int[] nums) {
		 	int k = 1;
	        int cur = nums[0];
	        for (int i = 1; i < nums.length; i++){
	            if (cur != nums[i]){
	                nums[k] = nums[i];
	                k++;
	                cur = nums[i];
	            }
	        }
	        return k;
	 }
}
