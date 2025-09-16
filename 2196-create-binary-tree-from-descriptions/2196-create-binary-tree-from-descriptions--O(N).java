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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int [] a : descriptions) {
            int par = a[0];
            int child = a[1];
            int isLeft = a[2];

            if(!map.containsKey(par)) {
                map.put(par , new TreeNode(par));
            }
            
            if(!map.containsKey(child)) {
                map.put(child , new TreeNode(child));
            }

            TreeNode parent = map.get(par);
            if(isLeft == 1) {
                parent.left = map.get(child);
            }
            else {
                parent.right = map.get(child);
            }

            set.add(child);
        }

        //find root
        for(int a [] : descriptions) {
            int parent = a[0];
            if(!set.contains(parent)) return map.get(parent);
        }

        return null;
    }
}