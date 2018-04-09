package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Prob12_IntegerToRoman {
    static Map<Integer, String> map = new HashMap();
    static {
        map.put(0, "");
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }
    
    /*
    num = 66;
    "CXVI"
    */
    
    public String intToRoman(int num) {
        if (num < 1) return "";
        if (map.containsKey(num)) return map.get(num);
        int i = 1;
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            int ld = num % 10;
            ld = ld * i;
            if (map.containsKey(ld)) ans.insert(0, map.get(ld));
            else {
                int closest = findClosest(ld);
                if (closest < ld) {
                    String temp = map.get(closest);
                    ld = ld - closest;
                    while (ld >0) {
                        temp += ""+map.get(i);
                        ld -= i;
                    }
                    ans.insert(0, temp);
                } else {
                    String temp ="";
                    if (closest - ld == i) {
                        temp = map.get(i)+""+map.get(closest);
                    } else {
                        closest = ld-(3*i);
                        temp = map.get(closest);
                        ld = ld- closest;
                        while (ld > 0) {
                            temp += ""+map.get(i);
                            ld -= i;
                        }
                    }
                    ans.insert(0, temp);
                }
            }
            i *= 10;
            num /= 10;
        }
        return ans.toString();
    }
    
    public int findClosest(int ld) {
        Set<Integer> set = map.keySet();
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (Integer i : set) {
            if (Math.abs(i-ld) < diff) {
                ans = i;
                diff = Math.abs(i-ld);
            }
        }
        // System.out.println(ans);
        return ans;
    }
}

/*
for each lsd:
    see if it exists in the map
    if it does append its roman to result
    if it does not calculate closest roman and append that to result
*/
