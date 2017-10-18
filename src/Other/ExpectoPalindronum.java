package Other;

public class ExpectoPalindronum {

	public static void main(String[] args)
    {
//       String given = "";
//       Scanner stdin = new Scanner(System.in);
//       given = stdin.nextLine();
//       stdin.close();
//       
//       int ans = 0;
//       if (isPalindrome(given, 0, given.length()-1)) {
//           System.out.println(ans);
//           return;
//       }
//       
//       int pal_ends = 0;
//       for (int i = 0; i < given.length(); i++) {
//           if (isPalindrome(given, 0, i)) {
//               pal_ends = i;
//           }
//       }
//       ans = given.length()-1 + (given.length()-pal_ends);
//       System.out.println(ans);
//       return;
		
		System.out.println(shortestPalindrome("aacecaaa"));
    }
	
	public static String shortestPalindrome(String s) {
        // if (isPalindrome(s,0,s.length()-1)) return s;
        int pal_ends = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i))
                pal_ends = i;
        }
        pal_ends++;
        int len = s.length();
        for (; pal_ends < len; pal_ends++) {
            s = s.charAt(pal_ends) + s;
        }
        return s;
    }
    
    /*
       TC:baaa -> 7 (aaabaaa)
       TC:ababa -> 0 (ababa)
       TC: sbabr -> 9 (rbabsbabr)
       TC: qrarqfcfqrarqs -> 15 (sqrarqfcfqrarqs)
       
       ALGO:
            if is palindrome return 0
            else:
            for each:
                if it is not palindrome so far then keep incrementing ends_at
                else save the position at starts_at
            return len + (len-ends_at)
       */
       
    private static boolean isPalindrome (String given, int i, int j) {
        if (given == null || given.isEmpty() || j-i == 0)
            return true;
        if (i > j) return false;
        while (i < j){
            if (given.charAt(i) != given.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
