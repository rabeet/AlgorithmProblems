package LeetCode;

import java.util.*;

public class Prob49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return null;
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) return ans;
        // use a hashmap where the key is the:
        // sorted string and the value is the string itself
        // TC: Max(O(n), O(k log k) where k is the size of the longest string)
        // SC: O(n) where n is the num of strings
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            // s = s.replaceAll("[^a-z]","");
            String sortedString = sortString(s);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<String>());
            list.add(s);
            map.put(sortedString, list);
        }
        ans.addAll(map.values());
        return ans;
    }

    private String sortString(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
