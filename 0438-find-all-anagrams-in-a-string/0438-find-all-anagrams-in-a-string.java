class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        
        // Fix 1: Check if s is shorter than p
        if (n < m) {
            return ans;
        }

        for (int i = 0; i <= n - m; i++) {
            String s1 = s.substring(i, i + m);
            if (isAnagram(s1, p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) {
            return false;
        }

        int [] sFreq = new int [26];
        //int [] tFreq = new int [26];

        for(int i=0 ; i < n ; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            sFreq[sch - 'a']++;
            sFreq[tch - 'a']--;
        }

        for(int a : sFreq) {
            if(a != 0) return false;
        }
        return true;
    }
}