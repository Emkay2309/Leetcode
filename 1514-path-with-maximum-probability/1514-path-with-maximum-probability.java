class Solution {

    //Using Dijkstra's Algorithm
    //T.C : O(E*log(V))
    //S.C : O(V + E)

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Build the graph
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ;i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<edges.length ; i++) {
            int sv = edges[i][0];
            int ev = edges[i][1];
            double prob = succProb[i];

            adj.get(sv).add(new Pair(ev , prob));
            adj.get(ev).add(new Pair(sv , prob));
        }

        // Array to store the maximum probability to reach each node
        double [] probability = new double[n];
        probability[start] = 1d;

        // Max-heap priority queue to explore the highest probability first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1d));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            double currProb = curr.prob;
            int currNode = curr.node;

            // If the current node is the end node, return the probability
            if (currNode == end) {
                return currProb;
            }

            // Explore the neighbors
            for (Pair neigh : adj.get(currNode)) {
                int neighNode = neigh.node;
                double neighProb = neigh.prob;

                // Update the probability if a higher one is found
                if (currProb * neighProb > probability[neighNode]) {
                    probability[neighNode] = currProb * neighProb;

                    pq.add(new Pair( neighNode , probability[neighNode]));
                }
            }
        }

        // If the end node is not reachable, return 0
        return 0d;
    }
}

class Pair{
    int node;
    double prob;
    Pair(int node , double prob) {
        this.node = node;
        this.prob = prob;
    }
}

