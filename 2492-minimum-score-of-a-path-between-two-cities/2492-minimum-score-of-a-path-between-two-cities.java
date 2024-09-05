class Solution {
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {

        boolean [] vis = new boolean [n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] road : roads) {
            int sv = road[0];
            int ev = road[1];
            int wt = road[2];

            adj.get(sv-1).add(new Pair(ev-1 , wt));
            adj.get(ev-1).add(new Pair(sv-1 , wt));
        }
        ans = Integer.MAX_VALUE;
        
        for(int i=0; i<n ; i++) {
            if(!vis[i]) {
                dfs(i  ,  vis , adj );
            }
        }


        return ans;
    }

    public void dfs(int curr , boolean [] vis , List<List<Pair>> adj) {
        vis[curr] = true;

        for(Pair neigh : adj.get(curr)) {
            int node = neigh.node;
            int wt = neigh.wt;

            ans = Math.min(ans , wt);

            if(!vis[node]) {
                dfs(node  , vis , adj );
            }
        }
    }
}

class Pair{
    int node;
    int wt;
    Pair(int node , int wt) {
        this.node = node;
        this.wt = wt;
    }
}