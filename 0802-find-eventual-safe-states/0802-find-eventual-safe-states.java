class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int n = graph.length;

        for(int i=0 ; i<n ; i++ ) {
            int size = graph[i].length;

            if(size == 0) {
                count++;
                set.add(i);
                ans.add(i);
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0; j<graph[i].length ; j++) {
                if(set.contains(graph[i][j]) ) {
                    ans.add(i);
                }
            }
        }

        Collections.sort(ans);

        return ans;



    }
}