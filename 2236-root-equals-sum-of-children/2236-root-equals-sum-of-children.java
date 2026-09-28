class Solution {
    public boolean checkTree(TreeNode root) {
        if(root.left==null && root.right==null && root.val==0) return true;
        return root.val == root.left.val+root.right.val;  
    }
}