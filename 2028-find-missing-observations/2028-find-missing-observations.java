class Solution {
    public int [] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;

        int sum = n;
        for(int roll : rolls) {
            sum += roll;
        }

        int totalSum = mean * (len + n);
        int diff = totalSum - sum;

        if(diff > (n*5) || diff < 0) {
            return new int [0];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int i = 0;
        
        while (diff > 0) {
            int increment = Math.min(diff, 6 - ans[i]);
            ans[i] += increment;
            diff -= increment;
            if (ans[i] == 6) {
                i++;
            }
        }
        return ans;
    }
}