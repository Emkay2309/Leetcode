import java.util.*;
import java.util.stream.IntStream;


class Solution {
    private boolean[] grid;
    private int m, n, N;
    
    private int idx(int r, int c) {
        return r * n + c;
    }
    
    private void cross(int r, int c, UnionFind G) {
        // downwards
        for (int i = r + 1; i < m; i++) {
            if (grid[idx(i, c)]) break;
            G.Union(idx(i, c), N); // connect to N
        }
        // upwards
        for (int i = r - 1; i >= 0; i--) {
            if (grid[idx(i, c)]) break;
            G.Union(idx(i, c), N); // connect to N
        }
        // rightwards
        for (int j = c + 1; j < n; j++) {
            if (grid[idx(r, j)]) break;
            G.Union(idx(r, j), N); // connect to N
        }
        // leftwards
        for (int j = c - 1; j >= 0; j--) {
            if (grid[idx(r, j)]) break;
            G.Union(idx(r, j), N); // connect to N
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m;
        this.n = n;
        this.N = n * m;
        UnionFind G = new UnionFind(N);
        
        grid = new boolean[N + 1];
        
        // Mark walls
        for (int[] ij : walls) {
            int r = ij[0], c = ij[1];
            grid[idx(r, c)] = true;
            G.components--;
        }
        // Mark guards 
        for (int[] ij : guards) {
            int r = ij[0], c = ij[1];
            grid[idx(r, c)] = true;
            G.components--;
        }
        // connect guarded Cells to N
        for (int[] ij : guards) {
            int r = ij[0], c = ij[1];
            cross(r, c, G);
        }
        return G.components - 1;
    }
}

// UnionFind class with Size & components
class UnionFind {
    private int[] root;
    private int[] Size;
    public int components;
    
    // Constructor
    public UnionFind(int n) {
        root = new int[n + 1];
        Size = new int[n + 1];
        components = n + 1;
        
        Arrays.fill(Size, 1);
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
    }
    
    public int Find(int x) { // Path Compression O(alpha(n))
        if (x == root[x]) 
            return x;
        return root[x] = Find(root[x]);
    }

    public boolean Union(int x, int y) { // Union by Size O(alpha(n))   
        x = Find(x);
        y = Find(y);
        
        if (x == y) return false;
        
        if (Size[x] > Size[y]) {
            Size[x] += Size[y];
            root[y] = x;
        } else {
            Size[y] += Size[x];
            root[x] = y;
        }       
        components--;
        return true;
    }     
}
