import java.util.Stack;

public class Prob20_ValidParantheses {
    public boolean isValid(String s) {
        // this fails for ({()}[])
        // return isValidR(s,0,s.length()-1);
        
        // use a stack for easy
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char popped = '\0';
            if ((""+s.charAt(i)).matches("[({\\[]")) {
                stack.push(s.charAt(i));
                continue;
            }
            else {
                if (stack.isEmpty()) return false;
                else popped = stack.pop();
            }
            
            char endbracket = '\0';
            if (popped == '{') endbracket = '}';
            else if (popped == '[') endbracket = ']';
            else endbracket = ')';
            
            if (s.charAt(i) != endbracket) return false;
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
    
    public boolean isValidR(String s, int start, int end) {
        if (s.length() < 2) return false;
        if (start >= end) return true;
        if (!(""+s.charAt(start)).matches("[{\\[(]")) return false;
        char endbracket = '\0';
            if (s.charAt(start) == '{') endbracket = '}';
            else if (s.charAt(start) == '[') endbracket = ']';
            else endbracket = ')';
        if((s.charAt(end) == endbracket)) return isValidR(s, start+1, end-1);
        else if (s.charAt(start+1) == endbracket) return isValidR(s, start+2, end);
        else return false;
    }
}
/*
"(]" -> fals

"([]][]{})" -> false

"()[]{}" -> true

({()}[]) -> true now
*/