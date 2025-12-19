class Pair {
    int time;
    int person;

    Pair(int time, int person) {
        this.time = time;
        this.person = person;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] m : meetings) {
            graph.get(m[0]).add(new Pair(m[2], m[1]));
            graph.get(m[1]).add(new Pair(m[2], m[0]));
        }

        int[] timeKnown = new int[n];
        Arrays.fill(timeKnown, Integer.MAX_VALUE);
        timeKnown[0] = 0;
        timeKnown[firstPerson] = 0;

        // Min-heap by time
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(0, 0));
        pq.offer(new Pair(0, firstPerson));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.time > timeKnown[cur.person]) continue;

            for (Pair next : graph.get(cur.person)) {
                if (next.time >= cur.time &&
                    timeKnown[next.person] > next.time) {

                    timeKnown[next.person] = next.time;
                    pq.offer(new Pair(next.time, next.person));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (timeKnown[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
