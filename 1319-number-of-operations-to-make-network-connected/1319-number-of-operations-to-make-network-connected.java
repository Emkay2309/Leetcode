class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length) return -1;
        List<List<Integer>> adj = create(n , connections);

        boolean [] vis = new boolean [n];
        Queue<Integer> q = new LinkedList<>();

        // BFS component counting
        boolean[] visBfs = new boolean[n];
        int componentsBfs = 0;
        for (int i = 0; i < n; i++) {
            if (!visBfs[i]) {
                bfs(i, visBfs, adj);
                componentsBfs++;
            }
        }

        // DFS component counting
        boolean[] visDfs = new boolean[n];
        int componentsDfs = 0;
        for (int i = 0; i < n; i++) {
            if (!visDfs[i]) {
                dfs(i, visDfs, adj);
                componentsDfs++;
            }
        }

        return componentsDfs-1;
    }

    public void bfs(int node , boolean [] vis ,  List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int neigh : adj.get(curr)) {
                if(!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
    }

    public void dfs(int curr , boolean [] vis , List<List<Integer>> adj) {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , adj);
            }
        }
    }

    public List<List<Integer>> create(int n , int [][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] e : connections) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } 
        return adj;
    }
}