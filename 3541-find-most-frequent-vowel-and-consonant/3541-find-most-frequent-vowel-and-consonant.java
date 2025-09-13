class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();
        int [] freq = new int [26];

        for(int i=0 ; i<n ; i++) {
            char ch = s.charAt(i);
            int val = s.charAt(i)-'a';
            if("aeiouAEIOU".indexOf(ch) != -1) {
                freq[val]--;
            }
            else {
                freq[val]++;
            }
        }

        // Step 2: find max consonant freq and max vowel freq (in absolute terms)
        int maxConsonant = 0;
        int maxVowel = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { // consonant
                maxConsonant = Math.max(maxConsonant, freq[i]);
            } else if (freq[i] < 0) { // vowel
                maxVowel = Math.max(maxVowel, -freq[i]); // take absolute value
            }
        }

        // Step 3: return their sum
        return maxConsonant + maxVowel;
    }
}