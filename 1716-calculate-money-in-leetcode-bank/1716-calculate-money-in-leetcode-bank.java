class Solution {
    public int totalMoney(int n) {
        int q = n / 7;  // Complete weeks
        int r = n % 7;  // Remaining days
        
        // Sum for complete weeks
        int completeWeeksSum = 28 * q + 7 * q * (q - 1) / 2;
        
        // Sum for remaining days
        int remainingDaysSum = 0;
        for (int i = 1; i <= r; i++) {
            remainingDaysSum += (q + i);
        }
        
        return completeWeeksSum + remainingDaysSum;
    }
}

// 1 ,2 , 3, 4, 5 ,6 ,7     =  (n)n+1/2 = 7*8/2 = 28
// 2 ,3 , 4, 5 ,6 ,7 ,8     =  28 + (7*1)
// 3 , 4, 5 ,6 ,7 ,8 ,9
// 4, 5 ,6 ,7 ,8 , 9 ,10
// 5 ,6 ,7 ,8 ,10,11,12

//Quotient = n/7