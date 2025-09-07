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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return dfs(1,n);
    }

    public List<TreeNode> dfs(int s , int e) {
        List<TreeNode> ans = new ArrayList<>();

        if(s > e) {
            ans.add(null);
            return ans;
        }

        if(s==e) {
            List<TreeNode> last = new ArrayList<>();
            last.add(new TreeNode (s));
            return last;
        }

        for(int i=s ; i<=e ; i++) {  // i=1 ===>  Left { (1,0)=null ; (1,1) ; (1,2)}
            //where is root          // i=1 ===> right { (2,3) ; (3,3) ; (4,3)=null}

            List<TreeNode> left = dfs(s , i-1);
            List<TreeNode> right = dfs(i+1 , e);

            for(TreeNode l : left) {
                for(TreeNode r : right) {

                    TreeNode root = new TreeNode(i);

                    root.left = l;
                    root.right = r;

                    ans.add(root);
                }
            }
        }
        return ans;
    }
}