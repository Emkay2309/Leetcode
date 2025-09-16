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
        
        ArrayList<Integer> check = new ArrayList<>();

        return dfs(0 , root , check);
    }

    public boolean dfs(int level , TreeNode root , ArrayList<Integer> check) {
        if(root == null) return true;

        if (level % 2 == 0 && root.val % 2 == 0) return false; 
        if (level % 2 == 1 && root.val % 2 == 1) return false; 

        if(level >= check.size() ) {
            check.add(root.val);
        }
        else {
            int prev = check.get(level);

            if(level%2==0) { // check in odd cases
                if(root.val <= prev) {
                    return false;
                }
                else {
                    check.set(level,root.val);
                }
            }
            else { //check for even cases
                if(root.val >= prev) {
                    return false;
                }
                else {
                    check.set(level,root.val);
                }
            }
        }

        return dfs(level+1 , root.left , check) && dfs(level+1 , root.right , check);
    }
}