package LeetCode;

import java.util.Stack;

public class Prob682_BaseBallGame{
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        
        // 2 passes
        
        // first pass: resolve all the c,d,+ and get a number in each
        for (int i = 0; i < ops.length; i++) {
            // if number
            if (ops[i].matches("-?\\d+"))
                stack.push(new Integer(ops[i]));
            // else
            else {
                if (ops[i].equalsIgnoreCase("c")) { // C
                    stack.pop();
                } else if (ops[i].equalsIgnoreCase("d")) { // D
                    stack.push(stack.peek()*2);
                } else { // +
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    int sumOfLastTwo = n1+n2;
                    stack.push(n2);
                    stack.push(n1);
                    stack.push(sumOfLastTwo);
                }
            }
        }
        
        // second pass pop each element to get a sum
        int sum = 0;
        int siz = stack.size();
        for (int i = 0; i < siz; i++) {
            sum += stack.pop();
        }
        
        return sum;
    }
}
