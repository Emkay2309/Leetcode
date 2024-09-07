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

    // The time complexity is O(n), where n is the number of nodes in the binary tree. 
    // This is because each node is visited once during the traversal. 
    // The space complexity is also O(n) due to the queue storing all nodes at the 
    // current level before moving to the next level. 
    // The solution efficiently handles both time and space usage for level-order traversal.
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i=0 ; i<size ; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
                temp.add(curr.val);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}