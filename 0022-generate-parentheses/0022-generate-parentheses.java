class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun("" , 0 , 0 , n , ans);
        return ans;
    }
    public void fun(String curr,int open, int close, int n, List<String> ans) {
        if(curr.length() == 2*n) {
            ans.add(curr);
            return;
        }

        if(open < n) {
            fun(curr+"(" , open+1 , close , n , ans);
        }
        if(close < open) {
            fun(curr+")" , open , close+1 , n , ans);
        }
    }
}



























// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();
//         fun("" , 0 , 0 , n  , ans);
//         return ans;
//     }
    
//     public void fun(String curr , int openBrac , int closeBrac , int n , List<String> ans) {
//         if(curr.length() == n*2) {
//             ans.add(curr);
//             return;
//         }

//         if(openBrac < n) {
//             fun(curr+"(" , openBrac+1 , closeBrac , n , ans);
//         }
//         if(closeBrac < openBrac) {
//             fun(curr+")", openBrac , closeBrac+1 , n , ans);
//         }

//     }
// }