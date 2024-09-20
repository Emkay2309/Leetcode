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


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a hashmap to store the index of each value in inorder
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Call the helper function to build the tree
        return buildTreeHelper(preorder, inorderIndexMap, 0, preorder.length - 1, new int[]{0});
    }

    private TreeNode buildTreeHelper(int[] preorder, HashMap<Integer, Integer> inorderIndexMap, 
                                      int start, int end, int [] index) {
        // Base case
        if (start > end) {
            return null;
        }

        // Get the root value from preorder
        int rootVal = preorder[index[0]];
        TreeNode root = new TreeNode(rootVal);

        // Increment the preorder index
        index[0]++;

        // Find the index of the root in inorder
        int inOrderRoot = inorderIndexMap.get(rootVal);

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, inorderIndexMap, start, inOrderRoot - 1, index);
        root.right = buildTreeHelper(preorder, inorderIndexMap, inOrderRoot + 1, end, index);

        return root;
    }
}