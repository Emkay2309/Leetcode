class Solution {
    public int minimumCost(int[] cost) {
        int[] freq = new int[101];
        for (int c : cost) {
            freq[c]++;
        }
        
        int total = 0;
        int count = 0;
        
        for (int i = 100; i >= 1; i--) {
            while (freq[i] > 0) {
                if (count == 2) {
                    count = 0;
                } else {
                    total += i;
                    count++;
                }
                freq[i]--;
            }
        }
        
        return total;
    }
}