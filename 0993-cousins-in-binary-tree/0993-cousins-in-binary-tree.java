class Solution {
    TreeNode xp,yp;
    int xd , yd;
    public boolean isCousins(TreeNode root, int x, int y) {
        xp = null;
        yp = null;
        xd = -1;
        yd = -2;

        dfs(root , x , y , null , 0);
        return xd == yd && xp != yp;
    }

    public void dfs(TreeNode root , int x , int y , TreeNode parent , int depth) {
        if(root == null) return;

        if(x == root.val) {
            xp = parent;
            xd = depth;
        }
        else if(y == root.val) {
            yp = parent;
            yd = depth;
        }
        else {
            dfs(root.left , x , y , root , depth+1);
            dfs(root.right , x , y , root , depth+1);
        }
    }
}