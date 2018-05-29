package LeetCode;

import java.util.Arrays;

public class Prob242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        s = new String(S);
        return s.equals(new String(T));
    }
}
