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
    List<String> ans ;
    public String smallestFromLeaf(TreeNode root) {
        ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        dfs(curr , root );
        Collections.sort(ans);
        return ans.get(0);
    }

    public void dfs(StringBuilder curr , TreeNode root) {
        if(root == null) return;

        char ch = (char) ('a' + root.val);
        curr.insert(0, ch);

        if(root.left == null && root.right == null) {
            ans.add(curr.toString());
            // backtrack before returning
            curr.deleteCharAt(0);
            return;
        }

        dfs(curr , root.left);
        dfs(curr , root.right);

        curr.deleteCharAt(0);
    }
}