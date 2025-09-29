class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; 
        k--;      
        
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // skip this whole subtree
                curr++;
                k -= steps;
            } else {
                // go deeper into the subtree
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    // Count steps between prefix n1 and n2
    private long countSteps(int n, long n1, long n2) {
        long steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}












// class Solution {
//     int count = 0;   
//     int ans = -1;    

//     public int findKthNumber(int n, int k) {
//         for (int i = 1; i <= 9; i++) {  
//             dfs(i, n, k);
//             if (ans != -1) break;     
//         }
//         return ans;
//     }

//     private void dfs(long num, int n, int k) {
//         if (num > n || ans != -1) return;

//         count++;

//         if (count == k) {
//             ans = (int) num;
//             return;
//         }

//         for (int i = 0; i <= 9; i++) {
//             dfs(num * 10 + i, n, k);
//             if (ans != -1) return;  
//         }
//     }
// }
