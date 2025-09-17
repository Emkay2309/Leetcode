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

 Initial call: dfs(3, 3)
│
├─ Node 3: val=3, maxSoFar=3 → 3>=3 ✓ count=1
├─ Update maxSoFar = max(3,3) = 3
├─ Call dfs(1, 3) for left child
│  │
│  ├─ Node 1: val=1, maxSoFar=3 → 1<3 ✗ count=0  
│  ├─ Update maxSoFar = max(3,1) = 3
│  ├─ Call dfs(3, 3) for left child
│  │  │
│  │  ├─ Node 3: val=3, maxSoFar=3 → 3>=3 ✓ count=1
│  │  ├─ No children, return 1
│  │  
│  ├─ Call dfs(null, 3) for right child → return 0
│  ├─ Total from left subtree: 0 + 1 + 0 = 1
│  
├─ Call dfs(4, 3) for right child  
│  │
│  ├─ Node 4: val=4, maxSoFar=3 → 4>=3 ✓ count=1
│  ├─ Update maxSoFar = max(3,4) = 4
│  ├─ Call dfs(1, 4) for left child
│  │  │
│  │  ├─ Node 1: val=1, maxSoFar=4 → 1<4 ✗ count=0
│  │  ├─ No children, return 0
│  │  
│  ├─ Call dfs(5, 4) for right child
│  │  │
│  │  ├─ Node 5: val=5, maxSoFar=4 → 5>=4 ✓ count=1  
│  │  ├─ No children, return 1
│  │  
│  ├─ Total from right subtree: 1 + 0 + 1 = 2
│
├─ Grand total: 1 + 1 + 2 = 4 good nodes!
 */


class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val); // start DFS with root value
    }

    private int dfs(TreeNode root, int maxSoFar) {
        if (root == null) return 0; // base case
        
        // good node?
        int count = root.val >= maxSoFar ?  1 : 0; 

        int left = dfs(root.left , Math.max(maxSoFar , root.val) );
        int right = dfs(root.right ,  Math.max(maxSoFar , root.val) );

        return count+right+left;
    }
}
