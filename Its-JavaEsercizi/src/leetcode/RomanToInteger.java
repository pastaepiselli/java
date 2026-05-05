package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++){
        	// se il carattere precedente e minore sottraggo
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))){
                res -= roman.get(s.charAt(i));
            } else { // se il carattere e maggiore aggiungo
                res += roman.get(s.charAt(i));
            }
        }
        // nel ciclo interrompo all'ultimo carattere cosi aggiungo alla fine 
        return res + roman.get(s.charAt(s.length() - 1)) ;
    }
}
