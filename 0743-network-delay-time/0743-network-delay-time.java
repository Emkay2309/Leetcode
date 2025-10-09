class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = create(times , n );
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.wt));
        pq.offer(new Pair(k,0));
        int [] dist = new int [n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currWt = curr.wt; // 1

            if(currWt > dist[currNode]) continue;
            
            for(Pair neighPair : adj.get(currNode)) { // (1,1) ; (3,1)
                int neigh = neighPair.node; //
                int neighWt = neighPair.wt;

                if(currWt+neighWt < dist[neigh]) {
                    dist[neigh] = currWt+neighWt;
                    pq.offer(new Pair(neigh , currWt+neighWt));
                }
            }
        }

        int max = -1;
        for(int i=1 ; i<=n ; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max , dist[i]);
        }
        return max;
    }

    public List<List<Pair>> create(int [][] edges , int n) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<=n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(v,wt));
        }
        return adj;
    }
}

class Pair{
    int node , wt;
    Pair(int node , int wt) {
        this.node = node;
        this.wt = wt;
    }
}