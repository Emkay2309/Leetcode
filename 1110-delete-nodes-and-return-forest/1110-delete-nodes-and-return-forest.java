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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();
        for(int a : to_delete) {
            set.add(a);
        }

        root = dfs(root , set , ans);
        if(root != null) {
            ans.add(root);
        }
        return ans;
    }

    public TreeNode dfs(TreeNode root , HashSet<Integer> set , List<TreeNode> ans) {
        if(root == null) return null;

        root.left = dfs(root.left , set , ans);
        root.right = dfs(root.right , set , ans);

        if(set.contains(root.val)) {
            if(root.left != null) {
                ans.add(root.left);
            }
            if(root.right != null) {
                ans.add(root.right);
            }
            return null;
        }
        else {
            return root;
        }
    }
}