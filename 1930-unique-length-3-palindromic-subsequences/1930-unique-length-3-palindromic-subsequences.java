class Solution {
    public int countPalindromicSubsequence(String s) {
        // Set to store unique characters encountered so far
        HashSet<Character> set = new HashSet<>();
        
        // Array to keep track of the number of unique characters up to each index
        int [] arr = new int[s.length()];
        
        // Populate the array
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            arr[i] = set.size();
        }

        int ans = 0; // Final count of palindromic subsequences \U0001f4af

        // Loop through each unique character in the set
        for (char c : set) {
            int i = -1, j = -1;
            // Find the first and last occurrence of character 'c'
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == c) {
                    if (i == -1)
                        i = k; // First occurrence \U0001f947
                    else
                        j = k; // Last occurrence \U0001f3c1
                }
            }

            // Check if there is space between the first and last occurrence
            if (j - i > 1) {
                HashSet<Character> between = new HashSet<>();
                i++; // Move to the index after the first occurrence
                while (i < j) {
                    between.add(s.charAt(i)); // Add characters between \U0001f356
                    i++;
                }
                ans += between.size(); // Add the size of the set to the answer \U0001f389
            }
        }

        return ans; // Return the final count \U0001f3c6
    }
}