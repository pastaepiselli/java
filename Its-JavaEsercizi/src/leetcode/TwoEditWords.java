package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoEditWords {
	 public boolean isChangable(String q, String d){
			int diff = 0;
			for (int i = 0; i < q.length(); i++){
					if (q.charAt(i) != d.charAt(i)){
						diff++;
					}
				}

				if (diff > 2){
					return false;
				}
				return true;
			}

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < queries.length; i++){
            for (int j = 0; j < dictionary.length; j++){

                if (isChangable(queries[i], dictionary[j])){
                    res.add(queries[i]);
                }
            }
        }
        return res;
    }   
}
