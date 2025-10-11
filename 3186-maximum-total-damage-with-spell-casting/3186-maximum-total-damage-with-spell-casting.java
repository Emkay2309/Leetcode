class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Long> map = new HashMap<>();
        for(int a : power) {
            map.put(a , map.getOrDefault(a ,0L)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        Long [] dp = new Long[keys.size()];
        return dfs(keys.size()-1 , keys , map , dp);
    }

    public long dfs(int n , List<Integer> arr , Map<Integer,Long> map , Long [] dp  )  {

        if(n < 0) return 0L;

        if(dp[n] != null) return dp[n];

        Long nPick = dfs(n-1 , arr , map, dp);

        int curr = arr.get(n);
        Long times = map.get(curr);

        Long pick = (curr*times);

        int pos = n-1;
        while(pos >= 0  &&  arr.get(pos) >= curr-2) {
            pos--;
        } 

        pick += dfs(pos , arr , map , dp);

        return dp[n] = Math.max(pick , nPick);


    }
}