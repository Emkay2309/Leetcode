class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        int i=0 , j=0 , sum=0 ,  ans = 0;

        while(j < n) {
            if(!set.contains(nums[j]) ) {
                sum += nums[j];
                set.add(nums[j]);
                ans = Math.max(ans , sum);
                j++;
            } 
            else {
                while(i< n && set.contains(nums[j])) {
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            }
        }
        return ans;
    }
}