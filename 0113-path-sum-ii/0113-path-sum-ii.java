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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        dfs(root, 0 , targetSum , new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root , int sum , int target ,  List<Integer> temp ) {
        if(root == null) return;

        sum += root.val;
        temp.add(root.val);

        //if leaf node
        if(root.left == null && root.right == null) {
            if(sum == target) {
                ans.add(new ArrayList<>(temp));
            }
        }
        else {
            dfs(root.left , sum , target, temp);
            dfs(root.right , sum , target , temp);
        }
        temp.remove(temp.size() - 1);
    }
}