package LeetCode;

public class Prob28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0;
        for (int i =0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j=0, c=0;
                for (j=0, c=i; j < needle.length(); j++, c++) {
                    if (c >=  haystack.length() || haystack.charAt(c) != needle.charAt(j))
                        break;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }
}

/*

"helolollo", needle = "ll"
        ^
TC: O(len(haystack)), SC: O(1)
check nulls and size of 0 for needle and needle size should be smaller or equal to
for i=0 -> hastack.leng-1
    if first char of needle matches haystack[i]:
        int c =i
        from j=0 -> needle.len-1
            if the chars at c and j dont match break out of this loop
            c++, j++
        if (j == length of needle-1) return i;
    i++
return -1
*/