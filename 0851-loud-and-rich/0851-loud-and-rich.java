class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        int[] ans = new int[n];

        // initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ans[i] = i; // same as iota in C++
        }

        // build graph
        for (int[] rich : richer) {
            graph.get(rich[0]).add(rich[1]);
            indegree[rich[1]]++;
        }

        // topological order BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph.get(node)) {
                // if quieter, update
                if (quiet[ans[node]] < quiet[ans[nei]]) {
                    ans[nei] = ans[node];
                }

                if (--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return ans;
    }
}
