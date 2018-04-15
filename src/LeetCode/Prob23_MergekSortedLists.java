package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } } [[1,4,5],[1,3,4],[2,6]]
 * 
 */
public class Prob23_MergekSortedLists {

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(0), ret = dummy;
		if (lists == null || lists.length == 0)
			return dummy.next;
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (l1, l2) -> (l1.val - l2.val));
		for (ListNode l : lists) {
			if (l == null)
				continue;
			queue.offer(l);
		}
		while (!queue.isEmpty()) {
			ListNode temp = queue.poll();
			dummy.next = temp;
			dummy = dummy.next;
			if (temp.next != null)
				queue.offer(temp.next);
		}
		return ret.next;
	}

	public ListNode mergeKListsTLE2(ListNode[] lists) {
		ListNode dummy = new ListNode(0), ret = dummy;
		if (lists == null || lists.length == 0)
			return dummy.next;
		Set<ListNode> listSet = new HashSet(); // all hashes would be different
		listSet.addAll(Arrays.asList(lists));
		while (!listSet.isEmpty()) {
			ListNode temp = null;
			int smallest = Integer.MAX_VALUE;
			for (ListNode l : listSet) {
				if (l == null)
					continue;
				if (l.val < smallest) {
					smallest = l.val;
					temp = l;
				}
			}
			if (temp == null)
				listSet.remove(temp);
			else {
				listSet.remove(temp);
				listSet.add(temp.next);
				dummy.next = new ListNode(temp.val);
				dummy = dummy.next;
			}
		}
		return ret.next;
	}

	public ListNode mergeKListsTLE(ListNode[] lists) {
		ListNode dummy = new ListNode(0), ret = dummy;
		if (lists == null || lists.length == 0)
			return dummy.next;
		int n = lists.length, i = 0;
		while (i < n) {
			int temp = -1;
			int smallest = Integer.MAX_VALUE;
			for (int t = 0; t < n; t++) {
				if (lists[t] == null)
					continue;
				if (lists[t].val < smallest) {
					smallest = lists[t].val;
					temp = t;
				}
			}
			if (temp != -1) {
				dummy.next = new ListNode(smallest);
				dummy = dummy.next;
				lists[temp] = lists[temp].next;
				if (lists[temp] == null)
					i++;
			} else {
				i++;
			}
		}
		return ret.next;
	}
}

/*
 * Easy way - make a new list - TC O(n) n=number of nodes - whats the point of k
 * sorted?? works but TLE for large sets.. So use a SET and delte the ones which
 * are null and traverse that x pointer: one pointer at each list:: while (at
 * least one pointer is valid - by a simple int whenever a pointer reaches its
 * end increase int by 1): if any pointer is invalid then ignore that append
 * smallest of the x pointers to the new list and increase that pointer by 1
 * return new list
 */