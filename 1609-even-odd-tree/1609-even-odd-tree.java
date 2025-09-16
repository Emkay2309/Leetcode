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
    public boolean isEvenOddTree(TreeNode root) {
        
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();

            int prev = (level % 2 == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i=1 ; i<=n ; i++) {
                TreeNode curr = q.poll();

                if(level % 2 == 1) { //odd check increasing
                    if(curr.val%2==0 || curr.val <= prev) {
                        return false;
                    }
                }
                else { // even check decreasing
                    if(curr.val%2==1 || curr.val >= prev) {
                        return false;
                    }
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                prev = curr.val;

            }
            level++;
        }

        return true;
    }
}