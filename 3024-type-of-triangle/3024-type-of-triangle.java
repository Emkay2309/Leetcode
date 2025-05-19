class Solution {
    public String triangleType(int[] nums) {
        int v1 = nums[0];
        int v2 = nums[1];
        int v3 = nums[2];

        if(v1+v2 <= v3 || v2+v3 <= v1 || v3+v1 <= v2) return "none";

        return v1==v2 && v2==v3 ? "equilateral" 
            :  v1==v2 || v2==v3 || v3==v1 ? "isosceles"
            :  "scalene";
    }
}