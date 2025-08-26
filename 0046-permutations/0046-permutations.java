class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        boolean [] vis = new boolean [nums.length];
        //backtrack(list, new ArrayList<>(), nums);

        solve(list , new ArrayList<>() , vis , nums);
        return list;
    }

    void solve(List<List<Integer>> ans , List<Integer> curr , boolean [] vis , int [] arr) {
        if(curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0 ; i<arr.length ; i++) {
            if(!vis[i]) {
                vis[i] = true;

                curr.add(arr[i]);
                solve(ans , curr , vis , arr);
                curr.remove(curr.size()-1);

                vis[i] = false;
            }  
        }
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i]))
                continue; // element already exists, skip
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }
}