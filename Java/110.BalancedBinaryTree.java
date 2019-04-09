/**
 * @author Linh
 * @Description Given a binary tree, determine if it is height-balanced.
 * <p>
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode tn) {
        if(tn == null)  return 0;
        return Math.max(maxDepth(tn.left), maxDepth(tn.right)) + 1;
    }
}