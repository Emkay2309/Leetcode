class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        //create graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                if(checkSimilar(strs[i] , strs[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean [] vis = new boolean [n];
        int count = 0;
        for(int i=0 ;i<n ; i++) {
            if(!vis[i]) {
                dfs(i , vis ,adj);
                count++;
            }
        }
        return count;
    }

    public boolean checkSimilar(String s1 , String s2) {
        int n = s1.length();
        int diff = 0;

        for(int i=0 ; i<n ; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 2 || diff == 0;
    }

    public void dfs(int curr , boolean [] vis , List<List<Integer>> adj) {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , adj);
            }
        }
    }
}