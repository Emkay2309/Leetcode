class Solution {
    // public boolean canJump(int[] nums) {
    //     int sum = 0;
    //     for(int i=0;i<nums.length;i++) {
    //         sum = Math.max(sum-1, nums[i]);
    //         if(sum==0 && i<nums.length-1) return false;
    //     }
    //     return true;
    // }
    public boolean fun(int i, int [] A, int [] dp){
        if(i>= A.length) return false;
        if(i== A.length -1) return true;
        if(dp[i]!=-1){
            if(dp[i]==1) return true;
            return false;
        }
       boolean res= false;
       for(int j=1;j<= A[i];j++){
           res= (res|| fun(i+j, A,dp));
       }
       if(res==false) dp[i]=0;
       if(res== true) dp[i]=1;
       return res;
    }
    public boolean canJump(int[] nums) {
       int dp[] = new int[nums.length+1];
       for(int i=0; i<=nums.length; i++){
           dp[i]=-1;
       }
       return fun(0, nums,dp); 
    }
}