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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int start = 0;
        int end = preorder.length-1;

        int [] index = {0};

        return createTree(preorder , inorder , index , start , end);
    }

    public TreeNode createTree(int [] pre , int [] in , int [] index , int start , int end) {
        if(start > end) return null;

        //find root in preorder // create root with the value found in preOrder
        int rootVal = pre[index[0]];
        TreeNode root = new TreeNode(rootVal);

        //find at what point the root is in Inorder to get the left and right child
        int i=start;
        for(; i<=end ; i++) {
            //find root in Inorder 
            if(in[i] == rootVal) {
                break;
            }
        }

        //move to the next index for the iteration so that we can add the left and right child
        index[0]++;

        root.left  = createTree(pre , in , index , start , i-1 );
        root.right = createTree(pre , in , index , i+1 , end);

        return root;
    }
}