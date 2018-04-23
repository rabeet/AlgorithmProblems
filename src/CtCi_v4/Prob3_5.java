package CtCi_v4;
import java.util.Deque;
import java.util.Stack;

public class Prob3_5 {
	
	/*
	 * 3.5: Implement MyQueue using 2 stacks
	 * To maintain FIFO you push an item onto the first stack
	 * Stack1 will have all the pushes.
	 * On a pop/peek push every item to stack 2 and return its head.
	 */

	public static void main(String[] args) {
		MyQueue<Integer> mq = new MyQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			mq.add(i);
		}
		System.out.println(mq.stack1.size());
		System.out.println(mq.stack2.size());
		mq.remove();
		System.out.println(mq.peek());
		mq.add(10);
		System.out.println(mq.stack1.size());
		System.out.println(mq.stack2.size());
	}
	
	private static class MyQueue<T> {
		
		Stack<T> stack1, stack2;
		public MyQueue() {
			stack1 = new Stack<T>();
			stack2 = new Stack<T>();
		}
		
		public void add(T item) {
			stack1.push(item);
		}
		
		public T remove() {
			if (!stack2.isEmpty()) return stack2.pop();
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		
		public T peek() {
			if (!stack2.isEmpty() )return stack2.peek();
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
			return stack2.peek();
		}
		
		public int size() {
			return stack1.size() + stack2.size();
		}
		
	}

}
