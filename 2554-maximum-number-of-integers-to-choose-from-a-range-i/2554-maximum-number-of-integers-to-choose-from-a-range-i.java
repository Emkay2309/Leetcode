class Solution {
    public int maxCount(int [] banned, int n, int maxSum) {
        
        int count = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int a : banned) {
            set.add(a);
        }

        for(int i=1 ; i<=n ; i++) {
            // if number in the banned , so continue
            if(set.contains(i)) {
                continue;
            }

            if(sum + i <= maxSum) {
                sum += i;
                count++;
            }
            else {
                break;
            }
            
        }
        return count;
    }
}