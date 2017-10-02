package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob225_ImplementStackUsingQueues {

}

class MyStack {

	/** Initialize your data structure here. */
	Queue<Integer> q1;
	Queue<Integer> q2;

	public MyStack() {
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
	}

	// 1, 2, 3 -> pop == 3
	// q2: 2, 3 -> q1: 3 == pop 3
	// push 4, 5 -> q1: 4 , 5; q2: 2, 3
	// pop: q1: 4, 5, 2; q2: 3 --> pop 3
	// pop: q2: 4,5, 2; q1: 4,5 --> pop 2\
	// pop: q2: 4; q1:5 --> pop 5
	// pop: q2: 4 --> pop 4
	/** Push element x onto stack. */
	public void push(int x) {
		q1.offer(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				if (q1.size() == 1)
					break;
				else
					q2.offer(q1.poll());
			}
			return q1.poll();
		} else {
			while (!q2.isEmpty()) {
				if (q2.size() == 1)
					break;
				else
					q1.offer(q2.poll());
			}
			return q2.poll();
		}
	}

	/** Get the top element. */
	public int top() {
		if (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				if (q1.size() == 1)
					break;
				else
					q2.offer(q1.poll());
			}
			int ans = q1.peek();
			q2.offer(q1.poll());
			return ans;
		} else {
			while (!q2.isEmpty()) {
				if (q2.size() == 1)
					break;
				else
					q1.offer(q2.poll());
			}
			int ans = q2.peek();
			q1.offer(q2.poll());
			return ans;
		}
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */