package CtCi_v6;

public class Prob8_1_TripleSteps {

    public static void main(String[] args) {
        System.out.println(howManyWays(4));
    }

    public static int howManyWays(int step) {
        int[] stepWays = new int[step+1];
        stepWays[0] = 0;
        stepWays[1] = 1;
        stepWays[2] = 2;
        stepWays[3] = stepWays[2] + stepWays[1] + 1;

        for (int i = 4; i < stepWays.length; i++)
            stepWays[i] = stepWays[i-1]+stepWays[i-2]+stepWays[i-3];

        return stepWays[step];
    }

}
