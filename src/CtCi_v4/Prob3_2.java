package CtCi_v4;
import java.util.Random;
import java.util.Stack;

class NodeWithMin {
	int data;
	int min;
	public NodeWithMin(int data, int min) {
		this.data = data;
		this.min = min;
	}
}

public class Prob3_2 {

	/*
	 * Design a stack which in addition to push and pop
	 * also has a min function which returns the min element
	 * They all should have O(1) complexity
	 * 
	 * ANS: just keep a min element WITHIN EACH NODE and maintain it after every push
	 * Can also maintain another stack for mins
	 */
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			stack.push(random.nextInt(10));
			System.out.print(stack.peek().data);
			System.out.print( " " +stack.min());
			System.out.println();
		}
		for (int i = 0; i< 10; i++) {
			System.out.println(stack.pop().data);
			System.out.println(stack.min());
			System.out.println();
		}
	}
	
	private static class StackWithMin extends Stack<NodeWithMin> {
		
		public void push(int data) {
			NodeWithMin node = new NodeWithMin(data, Math.min(data, min()));
			super.push(node);
		}
		
		public int min() {
			if (this.isEmpty()) return Integer.MAX_VALUE;
			return this.peek().min;
		}
		
	}

}
