class Solution {

    // Find the inorder successor (smallest node in right subtree)
    private TreeNode getNodeToReplace(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) return null;

        // recursive relation
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            // node found → perform deletion

            // case 1: no left child
            if (root.left == null) {
                return root.right;
            }
            // case 2: no right child
            else if (root.right == null) {
                return root.left;
            }
            // case 3: two children
            else {
                TreeNode nodeToReplace = getNodeToReplace(root.right);
                root.val = nodeToReplace.val;
                root.right = deleteNode(root.right, nodeToReplace.val);
            }
        }

        return root;
    }
}