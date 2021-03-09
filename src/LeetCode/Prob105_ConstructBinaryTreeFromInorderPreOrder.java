package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Prob105_ConstructBinaryTreeFromInorderPreOrder {

    public static void main(String[] args) {
        int[] preorder = {3,9,1,0,20,15,7};
        int[] inorder = {1,0,9,3,15,20,7};
        System.out.println(createBinaryTree(inorder, preorder));
    }
    static int node = 0;
    public static TreeNode createBinaryTree(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) inorderMap.put(inorder[i], i);
        return createBinaryTree(0, preorder.length, preorder, inorderMap);
    }

    private static TreeNode createBinaryTree(int leftanchor, int rightanchor, int[] preorder, Map<Integer, Integer> inorderMap) {
        if (leftanchor == rightanchor) return null;
        var tempNode = new TreeNode(preorder[node]);
        var inorderLocation = inorderMap.get(preorder[node]);
        node++;
        tempNode.left = createBinaryTree(leftanchor, inorderLocation, preorder, inorderMap);
        tempNode.right = createBinaryTree(inorderLocation+1, rightanchor, preorder, inorderMap);

        return tempNode;
    }

}
