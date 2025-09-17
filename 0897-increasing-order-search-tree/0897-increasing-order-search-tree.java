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
    ArrayList<Integer> ans ;
    public TreeNode increasingBST(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);

        return createTree(ans);

    }

    public TreeNode createTree(ArrayList<Integer> ans) {
        TreeNode root = new TreeNode(ans.get(0));
        TreeNode dummy = root;
        for(int i=1; i<ans.size() ; i++) {
            TreeNode curr = new TreeNode(ans.get(i));
            dummy.right = curr;
            dummy.left = null;

            dummy = curr;
        }
        return root;
    }

    public void dfs(TreeNode root) {
        if(root==null) return;

        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}