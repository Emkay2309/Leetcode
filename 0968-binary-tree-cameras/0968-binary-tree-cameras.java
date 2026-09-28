public class Solution {
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    // states: 0 = needs camera, 1 = covered, 2 = has camera
    private int dfs(TreeNode node) {
        if (node == null) return 1;

        int left = dfs(node.left);
        int right = dfs(node.right); 

        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        }

        if (left == 2 || right == 2) {
            return 1;
        }

        return 0;
    }
}
