package MustDoQuestions.Trees;

import Utilities.TreeNode;

import java.util.Stack;

public class RemoveKeyFromBST {

    public static void main(String[] args) {
        var node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        var r = new RemoveKeyFromBST();
        TreeNode del = r.deleteNode(node, node.left);
        System.out.println(del);
    }
    /*
    Given a root node to BST and another node remove it from a bst and return root node
                2
            1       5
          0       4
                3

                2
            1       10
          0       5
                3     6
                  4    8
                      7
      if leaf node: delete (set it to null)
      if not leaf node:
        if has right subtree:
            replace it with leftmost leaf node of right subtree = 7
        else: replace it with left subtree
      parent pointers?
            1->2->3->4
            1<-2<-3<-4


     */
    private TreeNode deleteNode(TreeNode root, TreeNode deleteNode) {
        if (deleteNode.left == null && deleteNode.right == null) {
            return findAndDeleteLeaf(root, deleteNode);
        }
        else if (deleteNode.right != null && deleteNode.left == null) {
            var tempNode = deleteNode.right;
            return setParent(root, deleteNode, tempNode);
        } else if (deleteNode.right == null) {
            return replaceDeleteNodeWithRightMostLeft(root, deleteNode);
        } else {
            // go to leftmost node of right, copy it and delete it and make it the parent
            return leftMostDeleteOfRight(root, deleteNode);
        }
    }

    private TreeNode leftMostDeleteOfRight(TreeNode root, TreeNode deleteNode) {
        var tempNode = deleteNode.right;
        while (tempNode.left != null) tempNode = tempNode.left;
        deleteNode(root, tempNode);
        var parent = findParentOfNode(root, deleteNode);
        if (parent == deleteNode) {
            tempNode.left = parent.left;
            tempNode.right = parent.right;
            return tempNode;
        } else {
            tempNode.left = deleteNode.left;
            tempNode.right = deleteNode.right;
            if (parent.right == deleteNode) parent.right = tempNode;
            else parent.left = tempNode;
            return root;
        }
    }

    // deleteNode.left != null
    private TreeNode replaceDeleteNodeWithRightMostLeft(TreeNode root, TreeNode deleteNode) {
        var parent = findParentOfNode(root, deleteNode);
        var tempNode = deleteNode.left;
        while (tempNode.right != null) {
            tempNode = tempNode.right;
            if (tempNode.right == null && tempNode.left != null) tempNode = tempNode.left;
        }
        tempNode.left = deleteNode.left;
        if (parent.left == deleteNode) parent.left = tempNode;
        else parent.right = tempNode;
        return root == deleteNode ? tempNode : root;
    }

    // set root.left = rightNode if root.left = deleteNode else root.right = rightNode and return root
    private TreeNode setParent(TreeNode root, TreeNode deleteNode, TreeNode rightNode) {
        if (root == deleteNode) return root.left == rightNode ? root.left : root.right;
        TreeNode parent = findParentOfNode(root, deleteNode);
        if (parent.left == deleteNode) parent.left = rightNode;
        else parent.right = rightNode;
        return root;
    }

    // set parent left or right to null
    private TreeNode findAndDeleteLeaf(TreeNode root, TreeNode leaf) {
        if (root == leaf) return null;
        TreeNode parent = findParentOfNode(root, leaf);
        if (parent.left == leaf) parent.left = null;
        else if (parent.right == leaf) parent.right = null;
        return root;
    }

    private TreeNode findParentOfNode(TreeNode root, TreeNode node) {
        if (root == node) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var temp = stack.pop();
            if (temp.left == node || temp.right == node) {
                return temp;
            }
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
        return root;
    }
}
