class Solution {
    public boolean reorderedPowerOf2(int n) {
        String sig = signature(n);

        for (int i = 0; i < 31; i++) { // since 2^30 < 10^9
            int pow = 1 << i; // 2^i
            if (signature(pow).equals(sig)) {
                return true;
            }
        }
        return false;
    }

    private String signature(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
