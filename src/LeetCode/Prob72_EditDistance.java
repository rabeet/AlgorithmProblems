package LeetCode;

public class Prob72_EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();
        int[][] matrix = new int[word1.length()+1][word2.length()+1];

        // FIRST ROW:
        for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = i;
        // FIRST COL:
        for (int i = 0; i < matrix.length; i++) matrix[i][0] = i;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                else {
                    int min = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                    matrix[i][j] = 1 + min;
                }
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }

    /*
    recursively get the min of update, delete and insert without actually doing them.. That will TLE out.. So follow the same in matrix:
    if char at word1(i) == char at word2(j)
        matrix[i][j] = matrix[i-1][j-1]
    else:
        it is 1 + the min of:
            matrix[i-1][j-1] // update
            matrix[i-1][j] // insert
            matrix[i][j-1] // delete
    make a matrix:
            H   O   R   S   E
            1   2   3   4   5
    R   1
    O   2
    S   3
    */

    public int minDistanceTLE(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        if (word1.charAt(0) == word2.charAt(0)) return minDistance(word1.substring(1, word1.length()), word2.substring(1, word2.length()));

        // get the min of the update, delete, or insert - you dont actually have to do the update delete or insert !!!
        int u = minDistance(word1.substring(1, word1.length()), word2.substring(1, word2.length()));
        int d = minDistance(word1.substring(1, word1.length()), word2);
        int i = minDistance(word1, word2.substring(1, word2.length()));

        return 1+Math.min(u, Math.min(d,i));
    }

//     private void edit(String word1, String word2, int sofar) {
//         if (word1.equals(word2)) {
//             if (minDistance < sofar) minDistance = sofar;
//             return;
//         }
//         word1 = getNextBestMove(word1, word2);
//         edit(word1, word2, sofar+1);
//     }

//     private String getNextBestMove(String word1, String word2) {
//         // if any len of char is common amongst the two then play around that
//     }
}

/*
check nulls and size 0s and what nots
NAIVE:
    horse, ros
    rorse   rorse   orse    rhorse      hose
    rosse   rose    ors     rohorse     rose
    ross    ros     or      roshorse    ros
    ros             o       roshors
                    r       roshor
                    ro      rosho
                    ros     rosh
                            ros
*/