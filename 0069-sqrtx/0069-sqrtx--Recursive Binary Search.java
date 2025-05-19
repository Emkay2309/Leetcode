class Solution {
    public int mySqrt(int x) {
        int s = 0;
        int e = x;

        while ( s <= e) {
            int mid = s+(e-s)/2;
            long sq = (long)mid*mid;

            if(sq == x) return mid;
            else if(sq < x) s = mid+1;
            else e = mid-1;
        }
        return e;
    }
}