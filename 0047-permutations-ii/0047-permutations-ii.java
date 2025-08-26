import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to group duplicates
        boolean[] used = new boolean[nums.length];
        solve(ans, new ArrayList<>(), used, nums);
        return ans;
    }

    void solve(List<List<Integer>> ans , List<Integer> curr , boolean [] vis , int [] arr) {
        if(curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0 ; i<arr.length ; i++) {
            if(i>0 && arr[i]==arr[i-1] && !vis[i-1]) continue;
            if(!vis[i]) {
                vis[i] = true;

                curr.add(arr[i]);
                solve(ans , curr , vis , arr);
                curr.remove(curr.size()-1);

                vis[i] = false;
            }  
        }
    }
}
