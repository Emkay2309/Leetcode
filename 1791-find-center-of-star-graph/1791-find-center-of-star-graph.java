class Solution {
    public int findCenter(int[][] edges) {

        int x = edges[0][0];
        int y = edges[0][1];

        int a = edges[1][0];
        int b = edges[1][1];

        if(x == a) return x;
        else if(x == b) return x;
        else if(y == a) return y;
        else return y;


    }
}