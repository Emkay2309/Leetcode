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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        return dfs(inorder , postorder , 0 , n-1 , 0 , n-1);
    }

    public TreeNode dfs(int [] in , int [] po , int inStart , int inEnd , int poStart , int poEnd) {
        
        if(inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(po[poEnd]);

        int i = inStart;

        for(; i <= inEnd ; i++) {
            if(in[i] == root.val)   break;
        }

        int leftSize  = i-inStart;
        int rightSize = inEnd-i;

        root.left  = dfs(in , po , inStart , i-1 , poStart , poStart+leftSize-1 );
        root.right = dfs(in , po , i+1 , inEnd , poEnd-rightSize , poEnd-1 );

        return root;
    }
}