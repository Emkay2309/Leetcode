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
    TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {

        first = middle = last = prev = null;

        // Run inorder DFS to find the two nodes
        inOrder(root);

        // If two non-adjacent nodes were swapped, swap first and last
        if (first != null && last != null) {
            int tmp = first.val;
            first.val = last.val;
            last.val = tmp;
        }
        // Otherwise the swapped nodes were adjacent, swap first and middle
        else if (first != null && middle != null) {
            int tmp = first.val;
            first.val = middle.val;
            middle.val = tmp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        // detect violation
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                // first time we see a violation: mark first and middle
                first = prev;
                middle = root;
            } else {
                // second time: mark last
                last = root;
            }
        }
        prev = root;

        inOrder(root.right);
    }
}
