class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = create(numCourses , prerequisites);
        int [] indegree = new int [numCourses];

        for(int e [] : prerequisites) {
            indegree[e[0]]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    q.add(neigh);
                    count++;
                }
                
            }
        }
        return count == numCourses ? true : false;
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