class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] < 0){
                continue;
            }
            nums[idx] *= -1;
        }

        for(int i  = 0; i < n; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}