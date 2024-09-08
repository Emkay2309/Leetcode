class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);

        // Union all edges
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        // Check if source and destination belong to the same component
        return dsu.find(source) == dsu.find(destination);
    }
}

class DSU   {
    int rank [] ;
    int par [] ;

    DSU(int V) {
        rank = new int [V];
        par = new int [V];

        for(int i=0; i<V ; i++ ) {
            rank[i] = 1;
            par[i] = i;
        }
    } 

    public int find(int u) {
        if(par[u] == u) return u;
        return par[u] = find(par[u]);
    }

    public void union(int u , int v) {
        int up = find(u);
        int vp = find(v);

        if(up == vp) return;

        if(rank[up] > rank[vp] ) {
            par[vp] = up;
        }
        else if(rank[vp] > rank[up]) {
            par[up] = vp;
        }
        else {
            par[vp] = up;
            rank[up]++;
        }
    }
}