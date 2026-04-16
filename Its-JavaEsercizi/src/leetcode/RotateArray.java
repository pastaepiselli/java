package leetcode;

// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
public class RotateArray {
	public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            // il % serve per arrotondare e non far sforare il giro :P
            arr[(i + k) % nums.length] = nums[i];
        }
        
        // copia in arr
        for (int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
        
    }
}
