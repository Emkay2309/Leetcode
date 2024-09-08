class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<=n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int [] colors = new int [n+1];
        Arrays.fill(colors , -1);

        for(int i=1 ; i<=n ; i++) {
            if(colors[i] == -1) {
                boolean check = bfs( i , colors , adj);
                if(!check) return false;
            }
        }

        return true;
    }

    public boolean bfs(int node , int [] colors , List<List<Integer>> adj ) {
        Queue<Integer> q  = new LinkedList<>();
        q.add(node);
        colors[node] = 1;

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int neigh : adj.get(curr)) {
                if(colors[neigh] == colors[curr]) return false;

                if(colors[neigh] == -1) {
                    q.add(neigh);
                    colors[neigh] = 1 - colors[curr];
                }
            }
        }
        return true;
    }
}