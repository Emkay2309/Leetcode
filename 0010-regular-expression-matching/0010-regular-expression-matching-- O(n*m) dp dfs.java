class Solution {
    Boolean[][] memo;  // memo[i][j] stores result of s[i:], p[j:]

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        // if we already computed this state
        if (memo[i][j] != null) return memo[i][j];

        boolean ans;

        if (j == p.length()) {
            ans = (i == s.length()); // both must end
        } else {
            boolean firstMatch = (i < s.length() &&
                    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // skip "x*" OR use "x*"
                ans = dfs(i, j + 2, s, p) || (firstMatch && dfs(i + 1, j, s, p));
            } else {
                ans = firstMatch && dfs(i + 1, j + 1, s, p);
            }
        }

        return memo[i][j] = ans;  // save result
    }
}
