/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return createString(root );
    }

    public String createString(TreeNode root) {
        if(root == null) return "N,";
        
        String ans = root.val + ",";
        ans += createString(root.left );
        ans += createString(root.right );
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = new int[]{0};  
        return createTree(nodes, index);
    }

    private TreeNode createTree(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("N")) {
            index[0]++;  // move past 'N'
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]++]));
        root.left = createTree(nodes, index);
        root.right = createTree(nodes, index);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));