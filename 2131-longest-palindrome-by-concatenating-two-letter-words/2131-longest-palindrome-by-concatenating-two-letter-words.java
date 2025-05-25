import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        int unpaired = 0; // For words like "aa" that can be in the middle

        for (String s : words) {
            String reversed = "" + s.charAt(1) + s.charAt(0);
            
            if (map.containsKey(reversed) && map.get(reversed) > 0) {
                ans += 4;
                map.put(reversed, map.get(reversed) - 1);
                if (s.charAt(0) == s.charAt(1)) {
                    unpaired--;
                }
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (s.charAt(0) == s.charAt(1)) {
                    unpaired++;
                }
            }
        }
        
        if (unpaired > 0) {
            ans += 2; // Can add one unpaired "aa" type word in the middle
        }
        
        return ans;
    }
}