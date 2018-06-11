package Other.TwoSigma;

import java.util.*;

public class StringChains {
    // Complete the longestChain function below.
    static int longestChain(String[] words) {
        if (words.length < 2) return words.length;
        Set<String> set = new HashSet<>(Arrays.asList(words)); // for faster lookup, dupes dont matter
        Map<String, Integer> map = new HashMap<>();
        int longest = 0;
        for (String word : words) {
            longest = Math.max(longest, dfs(word, set, map));
        }
        return longest;
    }

    private static int dfs(String word, Set<String> set, Map<String, Integer> map) {
        if (word.length() == 1)
            return (set.contains(null) || set.contains("")) ? 2 : 1;
        if (map.containsKey(word)) return map.get(word);

        int longest = 1;
        // StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            String neighbor = word.substring(0, i) + word.substring(i+1); // delete char at ith index (can also use stringbuilder)
            if (set.contains(neighbor))
                longest = Math.max(longest, 1+dfs(neighbor, set, map));
        }
        map.put(word, longest);
        return longest;
    }

/*
TESTING:
a 1
b 1
ba 2
bca 3
bda 3
bdca 4
*/

/*
int longestchain
for each word in array:
    check if it has an entry in HM:
        yes: compare it with longestchain/update if necessary
        no: do dfs to populate its entry in HM

int dfs(word):
    if word is one char:
        if null exists in input set return 2
    else return 1;
    if word exists in HM return that

    longest = 1
    for each of its neighbors:
        longest = MAX(longest, 1+dfs(neighbor))
    add longest to HM
    return longest
*/
}
