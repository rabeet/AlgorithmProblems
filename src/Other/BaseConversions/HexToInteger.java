package Other.BaseConversions;

public class HexToInteger {

    // Given a HEX string convert it to its integer output
    public static void main(String[] args) {
        System.out.println(HextoInteger("-FFFFFFFFFFFFFFFFFFFFFFFFFFF1"));
        System.out.println(HextoInteger("-F1A901"));
    }

    public static String HextoInteger(String hex) {
        if (hex == null || hex.isEmpty() || !hex.matches("\\-?[0-9A-F]+")) return "";
        Integer ans = 0;
        // multiply each least sig dig by num * 16^i where i is the 0 for the lsd and len-1 for the gsd
        char[] C = hex.toCharArray();
        int pow = 0;
        boolean neg = C[0] == '-';
        for (int i = hex.length()-1; i >= (neg?1:0); i--) {
            int I = getInt(C[i]) * (int)(Math.pow(16, pow));
            if ((long)ans + (long)I > Integer.MAX_VALUE)
                return neg?""+Integer.MIN_VALUE:""+Integer.MAX_VALUE;
            ans += I;
            pow++;
        }
        return neg ? "-"+ans:""+ans;
    }

    private static int getInt(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            return (c- '1') + 1;
        }
        return 10 + (c-'A');
    }
}
