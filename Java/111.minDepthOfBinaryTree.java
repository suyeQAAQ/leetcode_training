/**
 * @author Linh
 * @Description Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 * <p>
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
    public int run(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int minDepth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode temp;
        while (!q.isEmpty()) {
            minDepth += 1;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                temp = q.poll();
                if (temp.left == null && temp.right == null) return minDepth;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
        return 0;
    }
}