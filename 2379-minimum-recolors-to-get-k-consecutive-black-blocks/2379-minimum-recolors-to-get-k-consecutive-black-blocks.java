class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int i=0 , j=0;
        int ops = k;
        int w = 0;

        while( j < n  )  {
            if(blocks.charAt(j) == 'W') {
                w++;
            }

            if( j-i+1 == k) {
                ops = Math.min(ops,w);

                if(blocks.charAt(i) == 'W') {
                    w--;
                }
                i++;
            }
            j++;
        }
        return ops;
    }
}