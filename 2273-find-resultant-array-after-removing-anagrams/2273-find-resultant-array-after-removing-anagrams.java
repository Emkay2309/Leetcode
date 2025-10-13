class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        ans.add(words[0]);

        for(int i=1 ; i<n ; i++) {
            if(!anagram(words[i] , ans.get(ans.size()-1) ))  {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public boolean anagram(String s1 , String s2) {
        if(s1.length() != s2.length()) return false;

        int [] freq = new int [26];

        for(int i=0 ; i<s1.length() ; i++) {
            freq[s1.charAt(i)-'a']++;
        }

        for(int i=0 ; i<s2.length() ; i++) {
            freq[s2.charAt(i)-'a']--;
        }

        for(int a : freq) {
            if(a != 0) return false;
        }
        return true;
    }
}