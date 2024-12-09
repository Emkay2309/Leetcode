class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>(2);
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int [] match : matches) {
            int winner = match[0];
            int looser = match[1];
            
            // Increment the loss count for the loser
            map.put(looser , map.getOrDefault(looser , 0)+1);

            // Winner has 0 losses (ensure they are in the map)
            map.putIfAbsent(winner , 0);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int player = entry.getKey();
            int looses = entry.getValue();

            if(looses == 0) {
                ans.get(0).add(player);
            }
            else if(looses == 1) {
                ans.get(1).add(player);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));

        return ans;
    }
}