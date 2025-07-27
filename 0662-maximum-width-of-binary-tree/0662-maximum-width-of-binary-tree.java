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
    public int max;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root , 0));

        while(!q.isEmpty()) {
            int left = q.peekFirst().idx;
            int right = q.peekLast().idx;

            max = Math.max( max , right-left+1);

            int n = q.size();

            while( n-- > 0) {
                TreeNode currNode = q.peekFirst().val;
                int currIdx = q.peekFirst().idx;
                q.poll();

                if(currNode.left != null) {
                    q.offer(new Pair(currNode.left , 2*currIdx+1));
                }
                if(currNode.right != null) {
                    q.offer(new Pair(currNode.right , 2*currIdx+2));
                }
            }
        }
        return max;
    }
}

class Pair {
    TreeNode val;
    int idx;

    Pair(TreeNode val , int idx) {
        this.val = val;
        this.idx = idx;
    }
}