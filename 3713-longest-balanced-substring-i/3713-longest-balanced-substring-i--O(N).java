class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                char curr = s.charAt(j);
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);

                // collect counts of letters
                Set<Integer> counts = new HashSet<>(freq.values());

                if (counts.size() == 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}