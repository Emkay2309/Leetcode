class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for(int a : chalk) {
            sum += a;
        }

        int rem = (int)(k % sum);

        if(rem == 0) return 0;

        for(int i=0 ; i<chalk.length ; i++ ) {
            int val = chalk[i];

            if(val > rem) {
                return i;
            }
            rem -= val;
        }

        return 0;
    }
}