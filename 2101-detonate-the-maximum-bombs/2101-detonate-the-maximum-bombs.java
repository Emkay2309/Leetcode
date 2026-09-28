class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for (int j = 0; j < n; j++) {

                if (i == j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;

                long distanceSquared = dx * dx + dy * dy;
                long radiusSquared = r1 * r1;

                if (distanceSquared <= radiusSquared) {
                    adj.get(i).add(j);
                }
            }
        }

        int ans = 0;
        for(int i=0 ; i<n ; i++) {
            HashSet<Integer> vis = new HashSet<>();
            dfs(i , adj , vis );
            int count = vis.size();
            ans = Math.max(ans , count);
        }

        return ans;
    }

    public void dfs(int curr , ArrayList<ArrayList<Integer>> adj  , HashSet<Integer> vis ) {
        vis.add(curr);
        for(int neigh : adj.get(curr)) {
            if(!vis.contains(neigh)) {
                dfs(neigh , adj , vis);
            }
        }
    }
}