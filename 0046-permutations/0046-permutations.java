class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums , 0 , ans);
        return ans;
    }

    public void dfs(int [] nums , int start , List<List<Integer>> ans) {
        //base case
        List<Integer> temp = new ArrayList<>();
        if(start >= nums.length) {
            for(int a : nums) {
                temp.add(a);
            }
            ans.add(temp);
            return;
        }

        // generate per
        for(int curr=start; curr<nums.length ; curr++) {
            swap(start, curr, nums);

            dfs(nums , start+1 , ans);

            swap(start , curr , nums);
        }
    }

    public void swap(int a , int b , int [] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}