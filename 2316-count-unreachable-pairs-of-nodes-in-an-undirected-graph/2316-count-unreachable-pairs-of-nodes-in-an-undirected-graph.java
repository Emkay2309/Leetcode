class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU (n);

        for(int [] e : edges) {
            dsu.union(e[0] , e[1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            int root = dsu.find(i);
            map.put( root , map.getOrDefault(root,0)+1); 
        }

        long ans = 0;
        long rem = n;

        for(int size : map.values()) {
            rem -= size;
            ans += (long) size*rem;
        }
        return ans;
    }
}


class DSU {
    int [] par;
    int [] rank;
    int [] size;

    DSU(int n) {
        par = new int [n];
        rank = new int [n];
        size = new int [n];

        for(int i=0 ; i<n ; i++) {
            par[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if(u == par[u]) return u;
        return par[u] = find(par[u]);
    }

    public void union(int u , int v) {
        int up = find(u);
        int vp = find(v);

        if(up == vp) return;

        if(rank[up] > rank[vp]) {
            par[vp] = up;
            size[up] += size[vp];
        }
        else if(rank[up] < rank[vp]) {
            par[up] = vp;
            size[vp] += size[up];
        }
        else {
            par[vp] = up;
            rank[up]++;
            size[up] += size[vp];
        }
    }
}