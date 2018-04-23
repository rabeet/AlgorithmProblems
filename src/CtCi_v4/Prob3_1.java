package CtCi_v4;

public class Prob3_1 {

	/*
	 * How would you use a single array to implement 3 stacks
	 * Divide it b/w the 3 stacks
	 */
	public static void main(String[] args) throws Exception {
		Integer[] arr = new Integer[100];
		Stack<Integer> stack1 = new Stack<Integer>(0, 100/3, arr);
		Stack<Integer> stack2 = new Stack<Integer>(100/3, 2*100/3, arr);
		Stack<Integer> stack3 = new Stack<Integer>(2*100/3, 100, arr);
		for (int i = 0; i < 33; i++) {
			stack1.push(i);
			stack2.push(i);
			stack3.push(i);
		}
		for (int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static class Stack<T> {
		private int lowerBound, upperBound;
		private T[] container;
		private int counter;
		public Stack(int l, int u, T[] arr) {
			this.lowerBound = l;
			this.upperBound = u;
			this.container = arr;
			this.counter = this.lowerBound;
		}
		
		public T pop() {
			if (counter < lowerBound) return null;
			int ret = counter;
			this.counter--;
			return container[ret];
		}
		
		public void push(T item) throws Exception {
			if (counter >= upperBound) throw new Exception();
			container[counter++] = item;
		}
	}

}
