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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode ptree = q1.poll();
            TreeNode qtree = q2.poll();

            if(ptree.val != qtree.val) return false;

            if(ptree.left != null && qtree.left != null) {
                q1.add(ptree.left);
                q2.add(qtree.left);
            } else if(ptree.left != null || qtree.left != null) return false;

            if(ptree.right != null && qtree.right != null) {
                q1.add(ptree.right);
                q2.add(qtree.right);
            } else if(ptree.right != null || qtree.right != null) return false;
        }
        return true;
    }
}