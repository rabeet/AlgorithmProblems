package LeetCode;

public class Prob14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // if (strs == null || strs.length<1)
        //     return "";
        // Arrays.sort(strs);
        // StringBuilder common = new StringBuilder();
        // char[] first = strs[0].toCharArray(), last = strs[strs.length-1].toCharArray();
        // for (int i = 0; i < first.length; i++) {
        //     if (i < last.length && first[i] == last[i])
        //         common.append(first[i]);
        //     else break;
        // }
        // return common.toString();
        return longestCommonPrefixDQ(strs);
    }
    
    public String longestCommonPrefixDQ(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        return longestCommonPrefixDQ(strs, 0, strs.length-1);
    }
    
    private String longestCommonPrefixDQ(String[] strs, int l, int r) {
        if (l >= r)
            return strs[l];
        int mid = (l+r)/2;
        String cleft = longestCommonPrefixDQ(strs, l, mid);
        String cright = longestCommonPrefixDQ(strs, mid+1, r);
        return commonAmongst(cleft, cright);
    }
    
    private String commonAmongst(String left, String right) {
        int end = 0;
        for (int i = 0; i < left.length(); i++) {
            if (i < right.length() && left.charAt(i) == right.charAt(i))
                end++;
            else break;
        }
        return left.substring(0,end);
    }
    
}

/*
ASSUMING CASE SENSITIVITY
common amongst all?
Divide and Conquer:
    if left is equal or greater than right then return left
    get common of left
    get common of right
    return common of left and right

O(sizeOfShortestString*n) way:
    string common = ""
    from k 0 to len of shortest string
        for each string:
            common = 0 to k
    return common
    
Sorting O(nlogn) + O(sizeOfShortestString) way:
    Sort array
    string common = ""
    while (i=0 < len a[first] && j=0 < len a[last]) {
        if a[i] and a[j] are equal then append that char to common
        else
        break;
    }
    return common;
aaa aab aac abd abe
fudge fun furr
lol lol loll

HashMap way O(n*sizeofLongestString) SC: O(sizeOfLongestString):
    key=index, value = char
    for first string:
        populate hashmap with key as index and value as char at that index
    from every string thereon:
        if the value at that key matches the char at that index then keep that otherwise delete that record from hm
    build the string from the hashmap using a stringbuilder

*/