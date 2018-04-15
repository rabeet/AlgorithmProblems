package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        if (n <= 0) return list;
        populateList(list, "", 0, n);
        
        return list;
    }
    
    private void populateList(List<String> list, String built, int o, int size) {
        if (built.length() == size*2) {
            if (o == 0)
                list.add(built);
            return;
        }
        if (o < size)
            populateList(list, built+"(", o+1, size);
        if (o > 0)
            populateList(list, built+")", o-1, size);
    }
}

/*
Have to use some form of recursion
Naive sol: Generate all combination of parentheses and only add to the list the ones which are well formed
*/