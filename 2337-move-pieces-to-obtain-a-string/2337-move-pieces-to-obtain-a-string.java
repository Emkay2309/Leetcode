class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        // Remove all underscores and check if sequence of 'L' and 'R' matches
        while (i < n || j < n) {
            // Skip underscores in start
            while (i < n && start.charAt(i) == '_') i++;
            // Skip underscores in target
            while (j < n && target.charAt(j) == '_') j++;

            // Both i and j should reach the end together, else mismatch
            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            // The characters must match
            if (start.charAt(i) != target.charAt(j)) return false;

            // Ensure the movement constraints
            if (start.charAt(i) == 'L' && j > i) return false; // L can only move left
            if (start.charAt(i) == 'R' && j < i) return false; // R can only move right

            i++;
            j++;
        }

        return true;
    }
}
