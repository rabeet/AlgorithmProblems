package LeetCode;

import java.util.*;

public class Prob127_WordLadder {

    public static void main(String[] args) {
        Prob127_WordLadder p = new Prob127_WordLadder();
//        System.out.println(p.ladderLengthTLE("hot", "cog", Arrays.asList("hit", "lot", "bot", "cog", "log", "dog")));
        System.out.println(p.ladderLengthTLE("qa","sq",Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
        System.out.println(p.ladderLength("qa","sq",Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
//        System.out.println(p.ladderLengthTLE("qa", "sq", (Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"))));
        System.out.println(p.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "bot", "cog", "lot", "log", "hog", "pit"))));
        System.out.println(p.ladderLength("hit", "cag", new ArrayList<>(Arrays.asList("hot", "bot", "cag", "lot", "log", "hog", "pit"))));
        System.out.println(p.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "bot", "cog", "lot", "log", "hog", "pit","fog"))));
        System.out.println(p.ladderLengthTLE("hit", "cog", new ArrayList<>(Arrays.asList("hot", "bot", "cog", "lot", "log", "hog", "pit"))));
    }

    private class Node {
        String data;
        Set<Node> neighbors;
        Integer distanceToEnd;

        public Node(String data) {
            this.data = data;
            neighbors = new HashSet<>();
        }

        public void addNeighbor(Node node) {
            neighbors.add(node);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        if (!wordList.contains(endWord)) return 0;
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        wordList = new ArrayList<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        int count = 1;
        q.offer(endWord);
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String word = q.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!set.contains(j)) {
                        String neighbor = wordList.get(j);
                        if (word.equals(neighbor)) {
                            set.add(j);
                            continue;
                        }
                        if (isOneTransformDistance(word, neighbor)) {
                            if (neighbor.equals(beginWord)) return count+1;
                            set.add(j);
                            q.offer(wordList.get(j));
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }

    public int ladderLengthTLE(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        if (!wordList.contains(endWord)) return 0;
        wordList = new ArrayList<>(wordList);
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);
        Map<String, Node> map = new HashMap<>();
        // This TLEs out
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                String fWord = wordList.get(i), sWord = wordList.get(j);
                if (!map.containsKey(sWord)) map.put(sWord, new Node(sWord));
                if (i == j) continue;
                if (!map.get(fWord).neighbors.contains(map.get(sWord)) && isOneTransformDistance(fWord, sWord)) {
                    map.get(fWord).addNeighbor(map.get(sWord));
                    map.get(sWord).addNeighbor(map.get(fWord));
                }
            }
        }
        // do bfs updating the distance to end at each iteration
        int ans = bfs(endWord, beginWord, map, new HashSet<>());
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int bfs(String beginWord, String endWord, Map<String, Node> map, Set<String> es) {
        Node begin = map.get(beginWord), end = map.get(endWord);
        if (begin.distanceToEnd != null) return begin.distanceToEnd;
        if (begin.neighbors.contains(end)) {
            begin.distanceToEnd = 2;
            return begin.distanceToEnd;
        }
        int ans = Integer.MAX_VALUE;
        es.add(beginWord);
        for (Node node : begin.neighbors) {
            if (es.contains(node.data)) continue;
            ans = Math.min(ans, bfs(node.data, endWord, map, es));
        }
        es.remove(beginWord);
        begin.distanceToEnd = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans+1;
        return begin.distanceToEnd;
    }

    private boolean isOneTransformDistance(String firstWord, String secondWord) {
        boolean found = false;
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }
}

/*
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

if current word == endWord return current count
Find next word which has one transformation distance, call the function on that word and increase count to 1
if no such word found return -1

0-0;0
0-1;1
0-2;1
0-3;0
0-4;0
1-0;1
1-1;0
1-2;0
1-3;0
1-4;0
2-0;
2-1;1
...
4-5;1

0:
5:4,3(1)
4:3,0(2)
3:1(3)
1:0(4)

*/