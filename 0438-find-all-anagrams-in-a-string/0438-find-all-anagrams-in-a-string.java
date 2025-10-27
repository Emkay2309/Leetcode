class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if(n < m) return ans;

        int [] sfreq = new int [26];
        int [] pfreq = new int [26];

        for(int i=0 ; i<m ; i++) {
            char ch = p.charAt(i);
            pfreq[ch-'a']++;
        }

        for(int i=0; i<m ; i++) {
            char ch = s.charAt(i);
            sfreq[ch-'a']++;
        }

        for(int i=m ; i<n ; i++) {
            if(Arrays.equals(sfreq,pfreq)) {
                ans.add(i-m);
            }

            char add = s.charAt(i);
            char remove = s.charAt(i-m);

            sfreq[add-'a']++;
            sfreq[remove-'a']--;
        }

        if(Arrays.equals(sfreq,pfreq)) {
            ans.add(n-m);
        }
        return ans;
    }
}