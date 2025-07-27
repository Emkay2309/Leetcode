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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String , Integer> map = new HashMap<>();
        getSubTreeString(root , map , ans);
        return ans;
    }

    public String getSubTreeString(TreeNode root , Map<String,Integer> map , List<TreeNode> ans ) {
        if(root == null) return "N";

        String left = getSubTreeString(root.left , map , ans);
        String right = getSubTreeString(root.right , map , ans);

        String currSubTreeString = root.val + "," + left + "," + right;

        map.put(currSubTreeString , map.getOrDefault(currSubTreeString,0)+1);

        if(map.get(currSubTreeString) == 2) {
            ans.add(root);
        }
        return currSubTreeString;
    }
}