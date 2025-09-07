/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeftChain(root);
    }
    
    public int next() {
        // get the next smallest node
        TreeNode node = st.pop();
        
        // if node has a right child, push its left chain
        if (node.right != null) {
            pushLeftChain(node.right);
        }
        
        return node.val; // return value
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLeftChain(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    } 
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */