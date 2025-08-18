class Solution {
    public int catMouseGame(int[][] graph) {
        int i,j,k,n=graph.length;
        int[][][] dp= new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        Queue<int[]> qu = new LinkedList<>();
        for(i=0;i<n;i++){
            for(j=0;j<2;j++){
                dp[0][i][j]=1;
                qu.add(new int[]{i,i,j,2});
                if(i>0){
                    qu.add(new int[]{0,i,j,1});
                    dp[i][i][j]=2;
                }
            }
        }

        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                degree[i][j][0]=graph[i].length;
                degree[i][j][1]=graph[j].length;
                for (int x: graph[j]) if (x == 0) {
                    degree[i][j][1]--;
                    break;
                }
            }
        }

        while(!qu.isEmpty()){
            int[] arr=qu.poll();
            int mouse=arr[0],cat=arr[1],turn=arr[2],win=arr[3];
            if(mouse==1 && cat==2 && turn==0)return win;
            for(int val: graph[turn==0?cat:mouse]){
                int prevturn  = 1-turn;
                int prevmouse = (prevturn==0)?val:mouse;
                int prevcat   = (prevturn==1)?val:cat;
                if(prevcat==0)continue;
                if(dp[prevmouse][prevcat][prevturn]>0)continue;
                if(prevturn==0 && win==1 || prevturn==1 && win==2 
                || --degree[prevmouse][prevcat][prevturn]==0)
                {
                    dp[prevmouse][prevcat][prevturn]=win;
                    qu.offer(new int[]{prevmouse,prevcat,prevturn,win});
                }
            }
        }

        return 0;
    }
}