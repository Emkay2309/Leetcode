class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        ArrayList<Integer> mins = new ArrayList<>();
        for(String s : timePoints) {
            String [] parts = s.split(":");

            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            int val = h*60 + m;
            mins.add(val);
        }

        Collections.sort(mins);

        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<mins.size()-1 ; i++) {
            int prev = mins.get(i);
            int curr = mins.get(i+1);

            int diff = curr - prev;
            ans = Math.min(diff , ans);
        }

        int circularDiff = (1440 - mins.get(mins.size() - 1)) + mins.get(0);
        ans = Math.min(ans, circularDiff);
        
        return ans;
    }
}