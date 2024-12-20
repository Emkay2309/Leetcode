class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0 , currSum = 0;

        for(int ele : nums) {
            total += ele;
        }

        for(int i=0 ; i<n ; i++) {
            currSum += nums[i];
            if(currSum == total) return i;
            total -= nums[i];
        }
        return -1;
    }
}



//1. Using Logic
// int n = nums.length; 
        
//         int totalsum = 0 , currsum=0;
        
//         for(int ele : nums) {
//             totalsum += ele;
//         }
        
//         for(int i=0 ; i<n ; i++) {
//             currsum += nums[i]; 
//             if(totalsum == currsum) {
//                 return i;
//             }
//             totalsum -= nums[i];
//         }
        
//         return -1;


//2. Using Prefix Sum 
// int n = nums.length;
//         int [] PF = new int [nums.length];

//         PF[0] = nums[0];

//         for(int i=1 ; i<nums.length ; i++) {
//             PF[i] = PF[i-1] + nums[i];
//         }

//         for(int i=0 ; i < nums.length ; i++) {
//             int rightSum = 0;
//             int leftSum = 0;

//             if(i!=0) {
//                 leftSum = PF[i-1];
//             }
//             if(i!=n-1){
//                 rightSum = PF[n-1]-PF[i];
//             }
//             if(leftSum==rightSum) {
//                 return i;
//             }
//         }
//         return -1;   