class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int [] dist1 = new int [n];
        int [] dist2 = new int [n];
        boolean [] vis1 = new boolean [n];
        boolean [] vis2 = new boolean [n];

        Arrays.fill(dist1 , Integer.MAX_VALUE);
        Arrays.fill(dist2 , Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;

        dfs(edges , node1 , dist1 , vis1);
        dfs(edges , node2 , dist2 , vis2);

        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++) {
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i] , dist2[i]);

                if(maxDist < minDist) {
                    minDist = maxDist;
                    ans = i;
                }
            }
        }
        return ans;
    }


    public void dfs(int [] edges , int curr , int [] dist , boolean [] vis) {
        vis[curr] = true;
        int neigh = edges[curr];

        if(neigh != -1 && !vis[neigh]) {
            dist[neigh] = 1 + dist[curr];
            dfs(edges , neigh , dist , vis);
        }
    }
}