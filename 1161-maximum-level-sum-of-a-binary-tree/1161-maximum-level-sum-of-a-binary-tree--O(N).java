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
    Map<Integer,Integer> map;
    public int maxLevelSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root , 1);

        int maxLevel = -1;
        int maxSum = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }

    public void dfs(TreeNode root , int level) {
        if(root == null) return;
    
        map.put(level , map.getOrDefault(level,0)+root.val);

        dfs(root.left , level+1);
        dfs(root.right , level+1);
    }
}