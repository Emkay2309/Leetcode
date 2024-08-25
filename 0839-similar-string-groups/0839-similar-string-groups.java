class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        //create graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        DSU dsu = new DSU(n);
        int group = n;
        for(int i=0; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                if(checkSimilar(strs[i] , strs[j]) && dsu.find(i) != dsu.find(j)) {

                    dsu.union(i,j);
                    group--;
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        return group;

        // boolean [] vis = new boolean [n];
        // int count = 0;
        // for(int i=0 ;i<n ; i++) {
        //     if(!vis[i]) {
        //         dfs(i , vis ,adj);
        //         count++;
        //     }
        // }
        // return count;
    }

    public boolean checkSimilar(String s1 , String s2) {
        int n = s1.length();
        int diff = 0;

        for(int i=0 ; i<n ; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 2 || diff == 0;
    }

    public void dfs(int curr , boolean [] vis , List<List<Integer>> adj) {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , adj);
            }
        }
    }

}

class DSU {
    int [] rank ;
    int [] par;
    DSU(int n) {
        this.rank = new int [n];
        this.par = new int [n];

        for(int i=0; i<n ; i++) {
            rank[i] = 1;
            par[i] = i;
        }
    }

    public int find(int u) {
        if(u == par[u]) return u;
        return par[u] = find(par[u]);
    }

    public void union(int u  ,int v) {
        int up = find(u);
        int vp = find(v);

        if(up == vp) return;

        if(rank[up] > rank[vp]) {
            par[vp] = up; 
        }
        else if(rank[up] < rank[vp]) {
            par[up] = vp;
        }
        else {
            par[up] = vp;
            vp++;
        }
    }
}