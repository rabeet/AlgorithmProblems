package LeetCode;

import java.util.*;

public class Prob139_WordBreak {

    public static void main(String[] args) {
//        System.out.println(wordBreakTLE("leetcode", Arrays.asList("leet","code")));
//        System.out.println(wordBreakTLE("catsasi", Arrays.asList("cat","sasi","cats")));
//        System.out.println(wordBreakTLE("catsasi", Arrays.asList("cats","asi","cat")));
        System.out.println(wordBreakTLE("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")));
    }


    /*
    Set<Integer> checkpoints;
    from 0 to s.len: (i)
        for each int in set: (s)
            check if s to i is in the wordDict:
                YES: add i+1 to set
    return len+1 is in the set
     */
    static public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < s.length(); i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int c : set) {
                String sub = s.substring(c,i+1);
                if (wordDict.contains(sub))
                    tempList.add(i+1);
            }
            set.addAll(tempList);
        }
        return set.contains(s.length());
    }

    static public boolean wordBreakTLE(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        return wordBreakTLE(s, wordDict, 1);
    }

    static private boolean wordBreakTLE(String s, List<String> wordDict, int end) {
        if (s.isEmpty()) return true;
        if (end > s.length()) return false;
        if (wordDict.contains(s.substring(0,end)))
            return wordBreakTLE(s.replaceAll(s.substring(0,end),""), wordDict, 1) || wordBreakTLE(s, wordDict, end + 1);
        else return wordBreakTLE(s, wordDict, end+1);
    }
}

/*

catsasi, cats, asi
asi

word: catsasi, cats, asi
cat, sasi
cats, asi

word: catsasi; cat, sa, si, cats

applepenapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepen:
take out first apple
penapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepenapplepen:

applesappleapplepenpenpenapple
*/