package LeetCode;

public class Prob443_StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;
        // Arrays.sort(chars);
        char cur = chars[0];
        int count = 0;
        int c_start = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                if (count > 1) {
                    char[] countarr = (""+count).toCharArray();
                    for (int j = 0; j < countarr.length; j++) chars[c_start++] = countarr[j];
                }
                chars[c_start] = chars[i];
                cur = chars[i];
                c_start++;
                count = 1;
            }
        }
        if(c_start < chars.length) chars[c_start] = cur;
        if (count > 1) {
            char[] countarr = (""+count).toCharArray();
            for (int j = 0; j < countarr.length; j++) chars[c_start++] = countarr[j];
        }
        return c_start;
    }
}