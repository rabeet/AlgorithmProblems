import java.util.Stack;

public class Prob112_PathSum {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(4);
		t.right = new TreeNode(5);
		t.left.left = new TreeNode(7);
		t.right.left = new TreeNode(1);
		t.right.right = new TreeNode(3);
		t.right.left.left = new TreeNode(1);
		System.out.println(hasPathSum(t, 9));
	}
	/*
	 * 
Prob 112 - Path Sum

if(node == null)
	if (sum == rsum) return true;
	else return false
sum += node.left
sum += node.right

		1
	4		5
  7		   1  3
  		  2
sum = 9:

Stack: 4,1; 5,1
Stack: 7,5; null,5; 4,1; 5,1
Stack: null,12;null,12;7,5;null,5;4,1;5,1
Stack: 5,1
Stack: 1,6; 3, 9; 2,9

return true;

// Before I was only  checking for end nodes NOT leaf nodes
 * 
 * Path Sum - Iterative:

stack.push(root);
while(!stack.isEmpty()) {
	pop an element from stack1 and pop its sum so far from stack 2
		if its a leaf node check if the sum == finalsum
		else
	push all of its neighbors to stack 1 and push all of its sums with the neighbors to the stack 2
}
stack 1: 1; stack 2: 1
stack 1:4, 5; stack 2: 5, 6
stack 1:7, 5; stack 2: 12, 6
pop 7 and pop 12 at the same time to check if 12 is final sum
	 */
	
	public static boolean hasPathSumIterative(TreeNode root, int sum) {
		if (root == null) return false;
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		
		
		
		return true;
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		return pSum(root, sum, 0);
	}
	
	public static boolean pSum(TreeNode root, int finalSum, int sum) {
		if (root.left == null && root.right == null)
			return finalSum == sum+root.val;
		else if (root.left != null && root.right != null)
			return pSum(root.left, finalSum, sum+root.val) || pSum(root.right, finalSum, sum+root.val);
		else
			return root.left != null? pSum(root.left, finalSum, sum+root.val):pSum(root.right, finalSum, sum+root.val);
	}

}
