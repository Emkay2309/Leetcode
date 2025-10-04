class Solution {
    // public int maxArea(int[] height) {
    //     int leftMax [] = new int [height.length];
    //     int rightMax [] = new int [height.length];
        
        
    //     leftMax[0] = height[0];
    //     int Lmax = Integer.MIN_VALUE;
        
    //     for(int i=1 ; i<height.length ; i++) {
    //         if(Lmax < height[i]) {
    //             Lmax = height[i];
    //             leftMax[i]= Lmax;
    //         }
    //         else {
    //             leftMax[i]= Lmax;
    //         }
    //     }
        
    //     rightMax[0] = height[height.length-1];
    //     int Rmax = Integer.MIN_VALUE;
        
    //     for(int i=height.length-2 ; i>=0 ; i--) {
    //         if(Rmax < height[i]) {
    //             Rmax = height[i];
    //             rightMax[i]= Rmax;
    //         }
    //         else {
    //             rightMax[i]= Rmax;
    //         }
    //     }     
    // }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;

        while(left < right) {
            int left_height = height[left];
            int right_height = height[right];

            int min_height = Math.min(left_height , right_height);
            int water_trapped_in_window = min_height * (right - left);

            ans = Math.max(ans , water_trapped_in_window);

            if(left_height < right_height) {
                left++;
            }
            else {
                right--;
            }
        }
        return ans;
    }
}