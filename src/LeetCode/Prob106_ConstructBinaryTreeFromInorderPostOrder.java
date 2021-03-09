package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Prob106_ConstructBinaryTreeFromInorderPostOrder {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        System.out.println(createBinaryTree(inorder, postorder));
    }


    static int node = 0;
    public static TreeNode createBinaryTree(int[] inorder, int[] postorder) {
        node = postorder.length - 1;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return createBinaryTree(inorder, postorder, inMap, 0, postorder.length);
    }

    private static TreeNode createBinaryTree(int[] inorder, int[] postorder, Map<Integer, Integer> inMap, int leftanchor, int rightanchor) {
        if (leftanchor == rightanchor) return null;
        var inorderLoc = inMap.get(postorder[node]);
        var tempNode = new TreeNode(postorder[node]);
        node--;
        tempNode.right = createBinaryTree(inorder, postorder, inMap, inorderLoc + 1, rightanchor);
        tempNode.left = createBinaryTree(inorder, postorder, inMap, leftanchor, inorderLoc);
        return tempNode;
    }


}
