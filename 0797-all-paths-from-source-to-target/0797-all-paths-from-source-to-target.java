class Solution {
    // Time Complexity: 
    // \U0001d442(\U0001d449+\U0001d438+\U0001d443) where \U0001d443 can be as large as O(2 power v)  in the worst case.
    // Space Complexity:  O(V+P×V), where 
    //P is the number of paths from the source to the destination.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //Create start and dest points
        int start = 0;
        int dest = graph.length - 1;

        //create ans and temp ans lists
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        //do a dfs call from start to end and keep storig the ans
        dfs( start , dest , temp , ans , graph);

        return ans;
    }

public void dfs(int curr,int dest , List<Integer> temp , List<List<Integer>> ans , int [][] graph) {
        //add the curr node in the temp , coz this is in the path
        temp.add(curr);

        //if at any point curr reaches to dest so , we have found 1 path 
        //so store in the ans
        if(curr == dest) {
            ans.add(new ArrayList<>(temp));
        }
        //if not then traverse to the neighs , in order to find dest
        else {
            for(int neigh : graph[curr]) {
                dfs(neigh , dest , temp , ans , graph);
            }
        }

        // if we dont find any path 
        //while coming back to start keep removing the paths
        temp.remove(temp.size() - 1);
    }
}