class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        solve( 0 , n , nums , curr , ans);
        return ans;
    }

    public void solve(int start , int len , int [] nums , List<Integer> temp , List<List<Integer>> ans) {

        ans.add(new ArrayList<>(temp));

        for(int i=start; i<len ; i++) {
            if( i > start && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);

            solve(i+1 , len , nums , temp , ans);

            temp.remove(temp.size()-1);
        }
    }
}