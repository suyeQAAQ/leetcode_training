/**
 * @author Linh
 * @Description Given a n-ary tree, find its maximum depth.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < root.children.size(); i++) {
            l.add(maxDepth(root.children.get(i)));
        }
        int maxDepth = 0;
        for (int i = 0; i < l.size(); i++) {
            int temp = l.get(i);
            if (temp > maxDepth) maxDepth = temp;
        }
        return maxDepth + 1;
    }
}