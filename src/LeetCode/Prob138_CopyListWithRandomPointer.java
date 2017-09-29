package LeetCode;
import java.util.HashMap;
import java.util.Map;

public class Prob138_CopyListWithRandomPointer {

	public static void main(String[] args) {
		
		
		RandomListNode node1 = new RandomListNode(1);
		
		Prob138_CopyListWithRandomPointer prob = new Prob138_CopyListWithRandomPointer();
		RandomListNode copiedNode = prob.copyRandomList(node1);
		
		while (copiedNode != null) {
			System.out.println("Source: " + node1 + " " + node1.random);
			System.out.println("Destination: " + copiedNode + " " + copiedNode.random);
			copiedNode = copiedNode.next;
			node1 = node1.next;
			System.out.println();
		}
		
	}
	
	// 1 -> 2 -> 3
	// 1 -> 3
	// 2 -> 1
	// 3 -> 2
	
	// 1 -> 2 -> 3
	// 3    1    2
	
	public RandomListNode copyRandomList (RandomListNode node) {
		if (node == null) return null;
		RandomListNode nt = new RandomListNode(node.label);
		RandomListNode dummy = nt;
		Map<RandomListNode, RandomListNode> map = new HashMap();
		map.put(node,nt);
		copyList(nt, node.next, map);
		while (dummy != null) {
			RandomListNode random = map.getOrDefault(node.random, null);
			dummy.random = random;
			dummy = dummy.next;
			node = node.next;
		}
		return nt;
	}
	
	public void copyList (RandomListNode dest, RandomListNode src, Map map) {
		if (src == null)
			return;
		dest.next = new RandomListNode(src.label);
		map.put(src, dest.next);
		copyList(dest.next, src.next, map);
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) {
		this.label = x;
	}
};