package LeetCode;

public class Prob72_EditDistance {

    // Given two string what is the min edit distance from string1 to string2


    public int edit(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return s2.length();
        if (s2 == null || s2.length() == 0) return s1.length();
        return 0;
    }

    private int edit(String s1, String s2, int i, int j) {
        return 0;
    }
}
