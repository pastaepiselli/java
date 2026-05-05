package leetcode;
/*
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * questa e bellissima utilizziamo l'operatore XOR (^) e le sue seguente proprieta:
 *  1) un numero XOR con 0 resta invariato
 *  2) un numero XOR con se stesso ritorna zero 
 *  3) la proprieta commutativa che spacca sempre -> ordine non conta 
 *  
 *  quindi:
 *  [4, 1, 1, 2, 2]
 *  
 *  se scrivessimo tutto con tutti xor in mezzo
 *  
 *  4 ^ 1 ^ 1 ^ 2 ^ 2
 *  
 *  === proprieta commutativa ===
 *  
 *  4 ^ (1 ^ 1) ^ ( 2 ^ 2)
 *  	   |		  |
 *  4 ^    0	^	  0
 *  
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums){
            res ^= i;
        }
        return res;
    }
}
