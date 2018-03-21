package LeetCode;

public class Prob6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) return s;
        String[] zig = new String[numRows];
        int len = s.length();
        int i =0, t= 0;
        while (i < len) {
            while (t < zig.length) {
                if (zig[t] == null) zig[t] = "";
                if (i >= len) break;
                zig[t] += ""+s.charAt(i);
                i++;
                t++;
            }
            t-=2;
            while (t >= 0) {
                if (i >= len) break;
                zig[t] += "" + s.charAt(i);
                t--;
                i++;
            }
            t +=2;
        }
        String ans = "";
        for (String zag : zig) ans += zag;
        return ans;
    }
}
