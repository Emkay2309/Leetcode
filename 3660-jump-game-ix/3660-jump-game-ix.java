import java.util.*;

class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();  // Each: {value, left, right}
        
        for (int i = 0; i < n; i++) {
            int[] curr = {nums[i], i, i};
            
            while (!stack.isEmpty() && stack.peekLast()[0] > nums[i]) {
                int[] top = stack.removeLast();
                curr[0] = Math.max(curr[0], top[0]);  // Merge max
                curr[1] = top[1];  // Extend left
            }
            stack.addLast(curr);
        }
        
        // Fill ans
        while (!stack.isEmpty()) {
            int[] seg = stack.removeFirst();
            for (int j = seg[1]; j <= seg[2]; j++) {
                ans[j] = seg[0];
            }
        }
        return ans;
    }
}