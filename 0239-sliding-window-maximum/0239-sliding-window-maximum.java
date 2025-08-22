class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //edge
        if(nums == null || k<=0) {
            return new int[0];
        }

        int n = nums.length;
        int [] ans = new int [n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n ; i++) {

            // remove out of window indices
            while(!dq.isEmpty() && dq.peek() < i-k+1) {
                dq.poll(); //remove from the front
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] ) {
                dq.pollLast(); //remove from last
            }

            dq.offer(i);

            if(i >= k-1) {
                ans[i-k+1] = nums[dq.peek()];
            }
        }
        return ans;
     }
}


// O(n*k);

// i =0-n   
 //  j=0,1,2    --k 

 // 1,3,-1 = Math.max(arr[j],max) = max;