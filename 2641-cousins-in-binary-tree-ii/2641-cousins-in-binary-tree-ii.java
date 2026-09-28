class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        dfs(root,  0, levelSum);
        dfs2(root, 0, levelSum);

        return root;
    }
    private void dfs(TreeNode n, int depth, List<Integer> levelSum) {
        if (n != null) {
            if (depth == levelSum.size()) {
                levelSum.add(0);
            }
            levelSum.set(depth, levelSum.get(depth) + n.val);
            dfs(n.left, depth + 1, levelSum);    
            dfs(n.right, depth + 1, levelSum);    
        }
    }
    private void dfs2(TreeNode n, int depth, List<Integer> levelSum) {
        if (n != null) {
            n.val = levelSum.get(depth) - n.val;
            if (n.left != null && n.right != null) {
                int siblingsSum = n.left.val + n.right.val;
                n.left.val = n.right.val = siblingsSum;
            }
            dfs2(n.left, depth + 1, levelSum);
            dfs2(n.right, depth + 1, levelSum);
        }
    }
}