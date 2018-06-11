package Other.TwoSigma;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class FriendsCircle {
    /*
     * Complete the friendCircles function below.
     */
    static int friendCircles(String[] friends) {
        /*
         * Write your code here.
         */
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < friends.length; i++) {
            if (!set.contains(i)) {
                count++;
                bfs(friends, i, set);
            }
        }
        return count;
    }

    private static void bfs(String[] friends, int index, Set<Integer> set) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(index);
        int n = friends.length;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int temp = 0; temp < s; temp++) {
                int i = q.poll();
                set.add(i);
                for (int _i = 0; _i < n; _i++) {
                    if (friends[i].charAt(_i) == 'N') continue;
                    if (!set.contains(_i)) q.offer(_i);
                }
            }
        }
    }


/*
TESTING:
YYNN 1
YYYN 1
NYYN 1
NNNY 2

YNNNN 1
NYNNN 2
NNYNN 3
NNNYN 4
NNNNY 5
*/


/*

for each index, see if it is friend with any other and construct the friend circle using bfs. If no friend in that circle then add that.
keep a set of visited indices to not visit them again

count
from 0 to n (i):
    if i not in set:
    do bfs on i and count++

bfs:
add 0 to q

pop 0 from q
try to add 0 to set
if not in set: add 0's neighbors to q: 1

pop 1 from q
try to add 1 to set
if not in set add 1's neighbors to q: 2

pop 2 from q
add 2 to set
if not in set add 2's neighbors to q which are not in set: null

*/
}
