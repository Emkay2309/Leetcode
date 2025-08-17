class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj  = create( numCourses , prerequisites);
        int n = numCourses;

        int [] c1 = solve1( n , adj);
        //int [] c2 = solve2( n , adj);

        return c1;
    }

    public int [] solve1(int n , List<List<Integer>> adj ) {
        boolean [] vis = new boolean [n];
        boolean [] rec = new boolean [n];
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++) {
            if(!vis[i]) {
                if(dfs( i , vis , rec , st , adj)) {
                    return new int [] {};
                }
            }
        }

        int[] ans = new int[n];
        int j = 0;
        while (!st.isEmpty()) {
            ans[j++] = st.pop();
        }
        return ans;
    }

    public boolean dfs(int curr , boolean [] vis , boolean [] rec , Stack<Integer> st , List<List<Integer>> adj) {
        vis[curr] = true;
        rec[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(dfs(neigh , vis , rec , st , adj)) return true;
            }
            else if(rec[neigh]) {
                return true;
            }
        }
        rec[curr] = false;
        st.push(curr);
        return false;
    }

    public static List<List<Integer>> create(int n , int [][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] e : edges) {
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
}