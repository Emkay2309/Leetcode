class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = create(numCourses , prerequisites);

        boolean [] vis = new boolean [numCourses];
        boolean [] rec = new boolean [numCourses];

        for(int i=0 ; i<numCourses ; i++) {
            if(!vis[i]) {
                boolean check = dfs(i , vis , rec , adj);
                if(check) return false;
            }
        }
        return true;
    }

    public boolean dfs(int curr , boolean [] vis , boolean [] rec , List<List<Integer>> adj) {
        vis[curr] = true;
        rec[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(dfs(neigh , vis , rec , adj)) return true;
            }
            else if(rec[neigh]) {
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public List<List<Integer>> create(int n , int [] [] edges ) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] e : edges) {
            int sv = e[1];
            int ev = e[0];

            adj.get(sv).add(ev);
        }
        return adj;
    }
}