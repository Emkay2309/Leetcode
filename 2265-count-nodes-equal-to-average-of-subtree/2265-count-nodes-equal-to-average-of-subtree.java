class Solution {
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        if(root == null) return 0;
        int [] val = new int [2];
        dfs(root , val);
        return ans;
    }

    public int [] dfs(TreeNode root , int [] val) {
        if(root == null) return new int [2];

        int [] left = dfs(root.left , val);
        int [] right = dfs(root.right , val);

        int totalSum = root.val + left[0] + right[0];
        int totalCount = 1 + left[1] + right[1];
        int average = totalSum / totalCount;

        if(average == root.val) ans++;

        return new int [] {totalSum , totalCount};
    }
}

// class Solution {
//     int ans;
//     public int averageOfSubtree(TreeNode root) {
//         ans = 0;
//         if(root == null) return 0;
//         dfs(root , new Pair(0,0));
//         return ans;
//     }

//     public Pair dfs(TreeNode root , Pair pair) {
//         if(root == null) return new Pair(0,0);

//         Pair left = dfs(root.left , pair);
//         Pair right = dfs(root.right , pair);

//         int totalSum = root.val + left.sum + right.sum;
//         int totalCount = 1 + left.count + right.count;
//         int average = totalSum/totalCount;

//         if(average == root.val) ans++;

//         return new Pair(totalSum , totalCount); 
//     }
// }

// class Pair {
//     int sum;
//     int count;

//     Pair(int sum , int count) {
//         this.sum = sum;
//         this.count = count;
//     }
// }