package leetcode;
// devo ritornare l'index della posizone del target nella lista
// se non esiste l'index dove dovrebbe stare
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			// se lo trovo ritorno index
			if (nums[i] >= target) {
				return i;
			}
		}
		
		// se il numero non appare ne compreso ne nella lista ritorno il max index per inserimento
		return nums.length;
	}
}

