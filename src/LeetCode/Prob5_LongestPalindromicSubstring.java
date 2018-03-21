package LeetCode;

public class Prob5_LongestPalindromicSubstring {

	public static void main(String args[]) {
		String s = "abasbaxa";
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome("123321"));
		System.out.println(longestPalindrome("avadagad"));
	}

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean cache[][] = new boolean[len][len];
        String maxPal = "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                if (isPalindrome(j, j+i, s, cache)) {
                    String pal = s.substring(j, j+i+1);
                    maxPal = pal.length() > maxPal.length() ? pal : maxPal;
                }
            }
        }
        
        return maxPal;
    }
    
    private static boolean isPalindrome(int i, int j, String s, boolean[][] cache) {
        if (i == j){
            cache[i][j] = true;
        }
        else if (j-i == 1){
            cache[i][j] = s.charAt(i) == s.charAt(j);
        }
        else {
            if ((cache[i+1][j-1]) && (s.charAt(i) == s.charAt(j))) {
                cache[i][j] = true;
            } else {
                cache[i][j] = false;
            }
        }
        return cache[i][j];
    }}
