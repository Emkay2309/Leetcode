class Solution {

    public int [] par;
    public int [] rank;

    public boolean equationsPossible(String[] equations) {
        int V = 26;
        rank = new int [V];
        par = new int [V];

        for(int i=0 ; i<26 ; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        //Union if chars are same
        for(String s : equations) {
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            char equ = s.charAt(1);

            if(equ == '=') {
                union(u , v);
            }
        }

        //Union if chars are not same , check validity
        for(String s : equations) {
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            char equ = s.charAt(1);

            if(equ == '!') {
                int up = find(u);
                int vp = find(v);

                if(up == vp) return false;
            }
        }
        return true;
    }

    public int find(int u) {
        if(u == par[u]) return u;
        return par[u] = find(par[u]);
    }

    public void union(int u , int v) {
        int up = find(u);
        int vp = find(v);

        if(up == vp) return;

        if(rank[up] < rank[vp]) {
            par[up] = vp;
        }
        else if(rank[up] > rank[vp]) {
            par[vp] = up;
        }
        else {
            par[vp] = up;
            rank[up]++;
        }
    }
}