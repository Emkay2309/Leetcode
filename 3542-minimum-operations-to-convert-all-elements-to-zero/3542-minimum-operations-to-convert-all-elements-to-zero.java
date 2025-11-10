class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int n : nums) {

            while (!st.isEmpty() && st.peek() > n) {
                st.pop();
            }

            if(n == 0) continue;

            if (st.isEmpty() || st.peek() < n) {
                ans++;
                st.push(n);
            }
        }
        return ans;
    }
}