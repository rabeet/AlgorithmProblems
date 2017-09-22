import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Prob199_BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (i == len-1)
                    list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return list;
    }

}
