package Other.BaseConversions;

public class IntegerToHex {

    public static void main(String[] args) {

    }


    /*
    Divide num by 16
    Quotient used for next iteration
    Remainder is used for the hex digit
    Repeat until num is 0
     */
    public static String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            int rem = num % 16;
            ans.insert(0, hex(num));
            num /= 16;
        }
        return ans.toString();
    }

    private static char hex(int num) {
        if (num == 0)
            return '0';
        else if (num > 0) {
            if (num < 10)
                return (char) ('0'+num);
            else
                return (char) ('A'+num-10);
        }
        return '1';
    }

}
