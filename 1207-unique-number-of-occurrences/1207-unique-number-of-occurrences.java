// Time Complexity: 
// O(n), where \U0001d45b is the size of the array, to count occurrences and check uniqueness.
// Space Complexity: 
// O(2001+1001) = O(1), as both arrays are of constant size.

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int [] freq = new int [2001];
        int n = arr.length;

        for(int a : arr) {
            int index = 1000 + a;
            freq[index]++;
        }

        //check frequency
        boolean [] seen = new boolean [1001];
        for(int a : freq) {
            if(a > 0) {
                if(seen[a]) {
                    return false;
                } 
                seen[a] = true;
            }
        }
        return true;
    }
}