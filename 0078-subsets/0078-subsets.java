class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        solve( 0 , n , nums , temp , ans);
        return ans;
    }

    public void solve(int curr , int len , int [] nums , List<Integer> temp , List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));

        for(int i=curr ; i<len ; i++) {
            temp.add(nums[i]);

            solve(i+1 , len , nums , temp , ans);

            temp.remove(temp.size()-1);
        }
    }
}