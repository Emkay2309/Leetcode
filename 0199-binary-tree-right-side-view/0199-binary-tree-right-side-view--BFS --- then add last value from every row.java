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
    public List<Integer> rightSideView(TreeNode root) {
        
        if( root == null) {
            return new ArrayList<>();
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        Queue <TreeNode> q = new LinkedList<>();
        
        q.add(root);
        q.add(null);
        
        while( q.size()> 1 ) {
            TreeNode curr = q.poll();
            
            if( curr != null) {
                temp.add( curr.val);
                if( curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            else {
                ans.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
                q.add(null);
            }
        }
        ans.add(new ArrayList<>(temp));
        
        ArrayList<Integer> check = new ArrayList<>();
        
        for(int i=0 ; i<ans.size(); i++) {
            check.add(ans.get(i).get(ans.get(i).size()-1));
        }
        return check;
    }
}