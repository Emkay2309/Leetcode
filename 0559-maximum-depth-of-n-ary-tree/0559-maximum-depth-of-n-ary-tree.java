/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        return dfs(root, 1); 
    }

    private int dfs(Node node, int level) {
        int max = level;

        for (Node child : node.children) {
            max = Math.max(max, dfs(child, level + 1));
        }

        return max;
    }
}