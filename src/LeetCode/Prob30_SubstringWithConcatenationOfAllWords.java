package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob30_SubstringWithConcatenationOfAllWords {
	
	public static void main(String[] args) {
		Prob30_SubstringWithConcatenationOfAllWords p = new Prob30_SubstringWithConcatenationOfAllWords();
		System.out.println(p.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(p.findSubstring("barfoothefoobarsoonman", new String[] {"foo","bar"}));
		System.out.println(p.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(p.findSubstring("wordgoodstudentgoodword", new String[] {"word","good"}));
		System.out.println(p.findSubstring("goodswordgoodstudentgoodword", new String[] {"word","good"}));
	}
	
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList();
        if (s == null || words == null || words.length == 0) return ans; // what about ""?
        int n = words[0].length();
        int i  =0;
        Map<Integer, String> map = new HashMap();
        Set<String> wordsSet = new HashSet<String>(Arrays.asList(words));
        String temp = s;
        while (!temp.isEmpty()) {
            if (temp.length() < n) break;
            String word = temp.substring(0,n);
            if(wordsSet.contains(word)) map.put(i, word);
            else {
                int occ = firstOccurence(temp, wordsSet);
                if (occ == -1) break;
                else {
                    map.put(i, temp.substring(0, occ));
                    temp = temp.substring(occ);
                    i++;
                    continue;
                }
            }
            temp = temp.substring(n);
            i++;
        }
        for (Integer key : map.keySet()) {
            boolean valid = validSubstring(key, map, wordsSet);
            if (valid) ans.add(key*n);
        }
        return ans;
    }
    
    private int firstOccurence(String s, Set<String> wordsSet) {
        // return wordsSet.stream()
        //     .map(s::indexOf)
        //     .filter(e -> e != -1)
        //     .min(Integer::compare)
        //     .orElse(-1);
        
        int min = -1;
        for (String word : wordsSet) {
            if (s.indexOf(word) == -1) continue;
            if (min == -1) min = s.indexOf(word);
            min = s.indexOf(word) < min ? s.indexOf(word) : min;
        }
        return min;
    }
    
    private boolean validSubstring(int key, Map<Integer, String> map, Set<String> set) {
        Set<String> tempSet = new HashSet(set);
        while (key < map.size() && !tempSet.isEmpty()) {
            if (!tempSet.contains(map.get(key))) return false;
            tempSet.remove(map.get(key));
            key++;
        }
        return tempSet.isEmpty();
    }
}