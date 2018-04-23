package CtCi_v4;
import java.util.Arrays;
import java.util.Stack;

public class Prob3_4 {

	/*
	 * MEthod has N disks given to it. Use recursion.
	 */

	public static void main(String[] args) throws InterruptedException {
		Stack<Integer>[] stacks = new Stack[3];
		stacks[0] = new Stack<Integer>();
		stacks[1] = new Stack<Integer>();
		stacks[2] = new Stack<Integer>();
		// stacks[0].push(3);
		// stacks[0].push(2);
		stacks[0].push(3);
		stacks[0].push(2);
		stacks[0].push(1);
//		hanoiSolver(stacks, 3, 0);
		hanoiSolverRecursive(stacks, 3, 0,2,1);
//		for (Stack s : stacks) {
//			System.out.println(Arrays.toString(s.toArray()));
//		}
		System.out.println(stacks[2].peek());
	}
	
	public static void hanoiSolverRecursive(Stack<Integer>[] stacks, int n, int source, int destination, int extra) {
		if (n <= 0)
			return;
		hanoiSolverRecursive(stacks, n-1, source,extra,destination);
		moveADisk(stacks, source, destination);
		hanoiSolverRecursive(stacks, n-1, extra,destination,source);
	}

	public static void hanoiSolver(Stack<Integer>[] stacks, int n, int i) throws InterruptedException {
		while (stacks[2].size() < n) {
			int move = moveADisk(stacks, i, i + 1);
			System.out.println(move);
			Thread.sleep(1000);
			switch (move) {
			case -1:
				i=0;
				move = moveADisk(stacks, i, i - 1);
				break;
			case -2:
				if (move > 2)
					move = moveADisk(stacks, i - 1, i - 2);
				else
					move = moveADisk(stacks, i + 1, i + 2);
				break;
			case -3:
				i++;
				move = moveADisk(stacks, i, i+1);
				break;
			case -4:
				move = moveADisk(stacks, 2, findValidStack(stacks, 2));
				break;
			default:
				i++;
				break;
			}
		}

	}

	private static int findValidStack(Stack<Integer>[] stacks, int st) {
		for (int i = 0; i < stacks.length; i++) {
			if (i == st)
				continue;
			if (stacks[i].isEmpty())
				return i;
			if (!stacks[i].isEmpty() && !stacks[st].isEmpty() && stacks[i].peek() > stacks[st].peek())
				return i;
		}
		return -1;
	}

	private static int moveADisk(Stack<Integer>[] stacks, int from, int to) {
		// if (to > 2 || from > 2) return;
		// if (stacks[to].isEmpty())
		// stacks[to].push(stacks[from].pop());
		// else {
		// if (stacks[from].peek() < stacks[to].peek())
		// stacks[to].push(stacks[from].pop());
		// else moveADisk(stacks, from, to+1);
		// }

		if (to < 0 || to > 2)
			return -1;
		if (from < 0 || from > 2)
			return -2;
		if (stacks[from].isEmpty())
			return -3;
		if (!stacks[to].isEmpty() && !stacks[from].isEmpty() && stacks[to].peek() < stacks[from].peek())
			return -4;
		System.out.println("Moving " + stacks[from].peek() + " from stack " + from + ", to stack " + to+ ".........");
		stacks[to].push(stacks[from].pop());
		return to;
	}

}
