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
    public int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return dfs(0,n-1,preorder,inorder);
    }

    public TreeNode dfs(int start , int end , int [] pre , int [] in) {
        if(start > end) return null;

        int rootVal = pre[idx];
        int i=start;

        for(; i<=end ; i++) {
            if(rootVal == in[i]) {
                break;
            }
        }
        idx++;
        TreeNode root = new TreeNode(rootVal);

        root.left = dfs(start,i-1,pre,in);
        root.right= dfs(i+1,end,pre,in);

        return root;
    }
}