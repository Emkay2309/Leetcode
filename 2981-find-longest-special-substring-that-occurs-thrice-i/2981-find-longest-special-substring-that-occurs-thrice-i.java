// O(N3)

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;

        // Build the map with substring frequencies
        for (int i = 0; i < n; i++) {  // O(N)
            StringBuilder curr = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) { // O(N)
                    curr.append(s.charAt(j));
                    String key = curr.toString();
                    map.put(key, map.getOrDefault(key, 0) + 1);  // O(N)
                } else {
                    break;
                }
            }
        }

        // Find the substring with the maximum frequency
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            String word = entry.getKey();

            if (frequency >= 3 ) {
                ans = Math.max(ans , word.length());
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
