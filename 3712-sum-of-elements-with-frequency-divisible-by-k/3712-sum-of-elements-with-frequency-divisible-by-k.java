class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : nums) {
            map.put(a , map.getOrDefault(a,0)+1);
        }

        int ans = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            if(freq%k==0) {
                ans += (ele*freq);
            }
        }

        return ans;
    }
}