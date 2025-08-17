class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int [] colors = new int [V];
        Arrays.fill(colors , -1);

        for(int i=0 ; i<V ; i++ ) {
            if(colors[i] == -1) {
                boolean check = bfs( i , 0 , colors , graph);
                if(!check) return false;
            }
        }
        return true;
    }

    public boolean bfs(int curr , int c , int [] colors , int [][] graph) {
       Queue<Integer> q = new LinkedList<>();
       q.add(curr);
       colors[curr] = c;

        while(!q.isEmpty()) {
            int currNode = q.poll();

            for(int neigh : graph[currNode]) {
                if(colors[neigh] == -1) {
                    q.add(neigh);
                    colors[neigh] = 1- colors[currNode];
                }
                else if(colors[neigh] == colors[currNode]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int curr , int c , int [] colors , int [][] mat) {
        colors[curr] = c;

        for(int neigh : mat[curr]) {
            if(colors[neigh] == -1) {
                if(dfs(neigh , 1-c , colors , mat) == false) {
                    return false;
                }
            }
            else if(colors[neigh] == colors[curr]) {
                return false;
            }
        }
        return true;
    }
}