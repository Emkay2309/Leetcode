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
    public boolean isCompleteTree(TreeNode root) {
        //count total nodes in the tree
        int total = count(root);
        //root       --> i
        //left child --> 2*i
        //right child--> 2*i+1;

        return dfs(root , total , 1);
    }
    public int count (TreeNode root) {
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    public boolean dfs(TreeNode root , int count , int i) {
        if(root == null) return true;

        //At any point if i is more than total nodes ,
        //means we have added null so it will have a null so not CBT
        if(i > count) return false;
        return dfs(root.left , count , 2*i) && dfs(root.right , count , 2*i+1);
    }
}