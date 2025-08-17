/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node node) {
        if (node == null) return;

        // Connect left → right if both exist
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                node.left.next = getNext(node.next);
            }
        }

        if (node.right != null) {
            node.right.next = getNext(node.next);
        }

        //Important: recurse on right first, then left
        dfs(node.right);
        dfs(node.left);
    }

    // Find the next child in the same level
    private Node getNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}
