package LeetCode;
import java.util.Random;

public class Prob382_LinkedListRandomNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution obj = new Solution(head);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandomSinglePass());
	}
	
	static class Solution {
		ListNode head;
		public Solution(ListNode head) {
			this.head = head;
		}
		// 1 -> 2 -> 3
		public int getRandom() {
			// Find size of list
			int size = 0;
			ListNode node = head;
			while (node != null) {
				size++;
				node = node.next;
			}
			Random random = new Random();
			size = random.nextInt(size); // 0 <= x < size
			
			// Traverse to the random node
			node = head;
			for (int i = 1; i < size+1; i++) {
				node = node.next;
			}
			return node.val;
		}
		
		// DO it in a single pass
		public int getRandomSinglePass() {
			ListNode node = head;
			Random random = new Random();
			int val = node.val;
			for (int i = 1; node.next != null; i++) {
				node = node.next;
				if (random.nextInt(i+1) == i) {
					val = node.val;
				}
			}
			
			return val;
		}
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x;}
	}
}

