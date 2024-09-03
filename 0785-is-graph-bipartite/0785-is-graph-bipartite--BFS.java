class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int [] colors = new int [V];
        Arrays.fill(colors,-1);

        for(int i=0 ; i<V ; i++) {
            if(colors[i] == -1) {
                boolean checkDfs = dfs( i , 0 , colors , graph );
                boolean checkBfs = bfs( i , 0 , colors , graph );

                if(checkDfs == false) return false;
            }
        }
        return true;
    }

    public boolean dfs(int curr , int c , int [] colors , int [][] mat) {
        colors[curr] = c;
        int size = mat[curr].length;

        for(int neigh=0 ; neigh<size ; neigh++) {
            int neighNode = mat[curr][neigh];
            if(colors[neighNode] == -1) {
                if(dfs(neighNode , 1-c , colors , mat) == false) {
                    return false;
                }
            }
            else if(colors[neighNode] == colors[curr]) {
                return false;
            }
        }
        return true;
    }

    public boolean bfs(int curr , int c , int [] colors , int [][] mat) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        colors[curr] = c;

        while(!q.isEmpty()) {
            int currNode = q.poll();
            int size = mat[currNode].length;

            for(int neigh=0 ; neigh < size ; neigh++) {
                int neighNode = mat[currNode][neigh];

                if(colors[neighNode] == -1) {
                    q.add(neighNode);
                    colors[neighNode] = 1 - colors[currNode];
                }
                else if(colors[neighNode] == colors[currNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}