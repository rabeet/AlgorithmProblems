package CtCi_v4;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Prob3_3 {

	public static void main(String[] args) {
		SetOfStacks stack = new SetOfStacks(3);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		for (int i = 0; i < 11; i++) {
			System.out.println(stack.pop());
		}
	}
	
	private static class SetOfStacks extends Stack<Integer> {
		public SetOfStacks(int limit) {
			list = new ArrayList<>();
			list.add(new Stack<Integer>());
			this.limitPerStack = limit;
		}
		
		public Integer popAt(int i) {
			if (i > list.size()) return -1;
			Stack<Integer> stack = list.get(i);
			return stack.pop();
		}
		
		public Integer pop() {
			int val = 0;
			boolean empty = true;
			for (int i = list.size()-1; i >= 0; i--) {
				if (!list.get(i).isEmpty()) {
					val = list.get(i).pop();
					empty = false;
//					System.out.println("popping from stack: " + (i));
					break;
				}
			}
			
			if (empty) throw new EmptyStackException();
			return val;
		}
		
		public void push(int val) {
			if (list.get(list.size()-1).size() >= limitPerStack) {
				Stack<Integer> stack = new Stack<>();
				stack.push(val);
				list.add(stack);
			} else {
				list.get(list.size()-1).push(val);
//				System.out.println("pushing to stack " + (list.size()-1));
			}
		}
		
		List<Stack<Integer>> list;
		int limitPerStack;
	}

}
