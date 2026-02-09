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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return null;
        getInorder(root , arr);

        return createBST( 0 , arr.size()-1 , arr );
    }
    public TreeNode createBST(int start , int end , ArrayList<Integer> arr ) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createBST(start , mid-1 , arr);
        root.right = createBST(mid+1 , end , arr);

        return root;
    }
    public void getInorder(TreeNode root , ArrayList<Integer> arr) {
        if(root == null) return ;

        getInorder(root.left , arr);
        arr.add(root.val);
        getInorder(root.right , arr);
    }
}