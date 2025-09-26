class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                int ab = nums[i] + nums[j];
                int count = getCount(j + 1, n - 1, ab, nums);
                ans += count;
            }
        }
        return ans;
    }

    public int getCount(int left, int right, int k, int[] arr) {
        int ans = left-1;
        int start = left-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(k > arr[mid]) {
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return ans-start;
    }
}
