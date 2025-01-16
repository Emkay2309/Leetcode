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

    public void preOrder(TreeNode root , int level , List<Integer>ans) {
        if(root == null) return;

        if(ans.size() < level) ans.add(root.val);

        preOrder(root.right , level+1 , ans);
        preOrder(root.left , level+1 , ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        preOrder(root , 1 , ans);
        return ans;

        // List<List<Integer>> ans = levelOrder(root);

        // List<Integer> ans1 = new ArrayList<>();

        // for(int i=0 ; i<ans.size() ; i++) {
        //     for(int j=0 ; j<ans.get(i).size() ; j++) {
        //         if(j == ans.get(i).size()-1 ) {
        //             ans1.add(ans.get(i).get(j));
        //         }
        //     }
        // }

        // return ans1;
    }

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