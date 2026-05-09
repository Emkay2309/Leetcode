class Solution {
    public List<List<String>> printTree(TreeNode root) {
        // Step 1: Find height of tree
        int height = getHeight(root);
        
        // Step 2: Calculate dimensions
        // rows = height
        // cols = 2^height - 1
        int rows = height;
        int cols = (1 << height) - 1;  // 2^height - 1
        
        // Step 3: Create result matrix filled with empty strings
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            result.add(row);
        }
        
        // Step 4: Fill the matrix using DFS
        fillMatrix(result, root, 0, 0, cols - 1);
        
        return result;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    private void fillMatrix(List<List<String>> result, TreeNode node, int row, int left, int right) {
        if (node == null) return;
        
        // Calculate middle position for current node
        int mid = left + (right - left) / 2;
        
        // Place current node's value in the matrix
        result.get(row).set(mid, String.valueOf(node.val));
        
        // Recursively place left and right children
        fillMatrix(result, node.left, row + 1, left, mid - 1);
        fillMatrix(result, node.right, row + 1, mid + 1, right);
    }
}