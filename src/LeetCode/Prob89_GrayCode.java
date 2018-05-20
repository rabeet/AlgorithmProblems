package LeetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob89_GrayCode {

    public static void main(String[] args) {
        System.out.println((grayCode(3)));
    }

    /*
    i = 0 --> 8-1:
        G(0) = 000 XOR 0/2 = 000
        G(1) = 001 XOR 1/2 = 001
        G(2) = 010 XOR 001 = 011
        G(3) = 011 XOR 001 = 010
        G(4) = 100 XOR 010 = 110
        G(5) = 101 XOR 010 = 111
        G(6) = 110 XOR 011 = 101
        G(7) = 111 XOR 011 = 100
     */

    public static List<Integer> grayCode(int n) {
        return IntStream.range(0, 1<<n).map(i -> i ^ i>>1).boxed().collect(Collectors.toList());
    }

    public static List<Integer> grayCodeBacktrack(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        set.add(num); ans.add(num);
        grayCode(n, 0, ans, set);
        num = 0;
        return ans;
    }

    private static void grayCode(int n, int bit, List<Integer> list, Set<Integer> set) {
        if (bit < 0 || bit >= n) return;
        if (set.add(num^(1<<bit))) {
            num ^= 1 << bit;
            list.add(num);
            grayCode(n, bit-1, list, set);
            grayCode(n, bit+1, list, set);
        }
    }

    private static int num = 0;
}

/*
000
001
011
010
110

000;0
001;1
010;2
011;3
100;4
101;5
110;6
111;7
*/