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
import java.util.*;

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] maxFreq = new int[1]; // to store max frequency found so far

        // DFS to fill freqMap
        postOrder(root, freqMap, maxFreq);

        // Gather all sums with max frequency
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq[0]) {
                result.add(entry.getKey());
            }
        }

        // Convert list to array
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    private int postOrder(TreeNode node, Map<Integer, Integer> freqMap, int[] maxFreq) {
        if (node == null) return 0;

        int left = postOrder(node.left, freqMap, maxFreq);
        int right = postOrder(node.right, freqMap, maxFreq);

        int sum = node.val + left + right;
        freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);

        maxFreq[0] = Math.max(maxFreq[0], freqMap.get(sum));

        return sum;
    }
}
