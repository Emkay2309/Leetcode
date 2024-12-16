class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.element==b.element ? a.index-b.index : a.element - b.element);
        int n = nums.length;

        for(int i=0 ; i<n ; i++) {
            Pair pair = new Pair(nums[i] , i);
            pq.add(pair);
        }

        while(k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            int currEle = curr.element;
            int currInd = curr.index;
            int newValue = currEle * multiplier;
            nums[currInd] = newValue;

            Pair pair = new Pair(newValue , currInd);
            pq.add(pair);
        }
        return nums;
    }
}

class Pair {
    int element;
    int index;

    Pair(int element , int index) {
        this.element = element;
        this.index = index;
    }
}