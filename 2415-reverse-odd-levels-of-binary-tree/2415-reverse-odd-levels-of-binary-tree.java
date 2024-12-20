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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<TreeNode> levelNodes = new ArrayList<>();

            while(size-- > 0) {
                TreeNode temp = q.poll();
                levelNodes.add(temp);

                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }

            if(level % 2 == 1) { //Odd Level
                int i=0;
                int j=levelNodes.size()-1;

                while( i < j) {
                    int tempVal = levelNodes.get(i).val;
                    levelNodes.get(i).val = levelNodes.get(j).val;
                    levelNodes.get(j).val = tempVal;

                    i++;
                    j--;
                }
            }
            level++;
        }

        return root;
    }
}