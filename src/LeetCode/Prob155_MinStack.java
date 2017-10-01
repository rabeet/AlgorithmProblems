package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Prob155_MinStack {
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		obj.push(2);
		obj.push(-512);
		obj.push(214);
		System.out.println(obj.getMin());
		System.out.println(obj.top());
		Queue<Integer> q = new ArrayDeque<>();	
	}
}

class MinStack {
    /** initialize your data structure here. */
    Stack<IntWithMin> stack;
    public MinStack(){
        stack = new Stack<IntWithMin>();
    }
    
    public void push(int x) {
        int minsofar = stack.isEmpty() ? x : x < getMin() ? x : getMin();
        IntWithMin in = new IntWithMin(x, minsofar);
        stack.push(in);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().data;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
    }
}

class IntWithMin {
    int data;
    int minSoFar;
    public IntWithMin(int data, int min) {
        this.data = data;
        this.minSoFar = min;
    }
}