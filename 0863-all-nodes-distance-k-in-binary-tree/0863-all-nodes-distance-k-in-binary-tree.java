/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode , TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        createParentConnections(root);

        Set<Integer> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.add(target.val);

        while(!q.isEmpty()) {
            int n = q.size();
            
            if(k == 0) break;

            for(int i=1 ; i<=n ; i++) {
                
                //get curr node to add all the connections left , right , parent
                TreeNode curr = q.poll();

                //left child if not vis 
                if(curr.left != null && vis.contains(curr.left.val)==false) {
                    q.add(curr.left);
                    vis.add(curr.left.val);
                }

                //right child if not vis 
                if(curr.right != null && vis.contains(curr.right.val)==false) {
                    q.add(curr.right);
                    vis.add(curr.right.val);
                }

                //par if available and not vis
                if(parent.containsKey(curr) && vis.contains(parent.get(curr).val)==false) {
                    q.add(parent.get(curr));
                    vis.add(parent.get(curr).val);
                }
            }
            k--;
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    public void createParentConnections(TreeNode root) {
        if(root == null) return;

        if(root.left != null) {
            parent.put(root.left , root);
        }
        createParentConnections(root.left);

        if(root.right != null) {
            parent.put(root.right , root);
        }
        createParentConnections(root.right);
    }
}