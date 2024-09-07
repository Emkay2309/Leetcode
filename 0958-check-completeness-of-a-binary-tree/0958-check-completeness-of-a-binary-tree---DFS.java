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
        boolean past = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            //if the curr is null , so make past true
            if(curr == null) {
                past = true;
            }
            else {// curr not null so add child , but before check 
                 // past me null kvi mila h kya 
                if(past == true) return false;

                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}