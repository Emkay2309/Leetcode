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
    // Time Complexity (TC): O(n^2) 
    // Space Complexity (SC): O(h), where h is the height of the tree
    // Explanation:
    // TC: In worst case, we might need to traverse the entire inorder array for each node.
    // SC: Maximum recursion depth is equal to the height of the binary tree.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if(n == 1) return new TreeNode(inorder[0]);

        int [] index = {0};
        return solve(preorder , inorder , 0 , n-1 , index);
    }

    public TreeNode solve(int [] pre , int [] in , int start , int end , int [] idx) {
        if(start > end) return null;

        int rootVal = pre[idx[0]];
        TreeNode root = new TreeNode(rootVal);

        int i=0;
        for( ; i<=end ; i++) {
            if(in[i] == rootVal) break;
        }

        idx[0]++;

        root.left = solve(pre , in , start , i-1 , idx);
        root.right = solve(pre , in , i+1 , end , idx);

        return root;
    }
}