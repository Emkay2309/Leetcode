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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        return add( root , 1 , val , depth);
    }

    public TreeNode add(TreeNode root, int currDepth , int val, int depth) {
        if(root == null) return null;

        if(currDepth == depth-1) {
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;

            TreeNode n1 = new TreeNode(val);
            TreeNode n2 = new TreeNode(val);

            root.left = n1;
            root.right = n2;

            n1.left = leftChild;
            n2.right = rightChild;

            return root;
        }
        root.left = add(root.left , currDepth+1 , val , depth);
        root.right = add(root.right , currDepth+1 , val , depth);

        return root;
    }
}