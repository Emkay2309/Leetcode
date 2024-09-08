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
        List<TreeNode> ans = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int a : to_delete) {
            set.add(a);
        }

        dfs(root  , set , ans);

        if(!set.contains(root.val)) {
            ans.add(root);
        }
        return ans;
    }

    public TreeNode dfs(TreeNode root , Set<Integer> set , List<TreeNode> ans) {
        if(root == null) return null;

        root.left = dfs(root.left , set , ans);
        root.right = dfs(root.right , set , ans);

        //if the node is to be deleted
        if(set.contains(root.val)) {

            // Before deleting add children to ans if present
            if(root.left != null) {
                ans.add(root.left);
            }
            if(root.right != null) {
                ans.add(root.right);
            }

            //delete node
            return null;
        }
        else {
            // if it is not be deleted
            return root;
        }
    }
}
