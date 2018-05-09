package LeetCode;

public class Prob605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1) return flowerbed[0] == 0 && n == 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else if (i == flowerbed.length-1) {
                if (flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else {
                if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}

/*
n <= num of 0 slots/2 ?

can we rearrange existing flowers? NO
from i = 0 to end:
    if ith slot is open: place flower and decrement n

return n == 0
*/
