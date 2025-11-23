class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans=0,i=1;
        boolean is0=(colors[0]==0);
        int temp=0;
        if(colors[1]==colors[colors.length-1] && colors[0]!=colors[1]) ans++;

        while(i<colors.length){
            if(colors[i]==1 && is0 && colors[(i+1)%colors.length]==0){
                is0=false;
                ans++;
            }
            if(colors[i]==0 && !is0 && colors[(i+1)%colors.length]==1){
                is0=true;
                ans++;
            }
            is0=(colors[i]==0);
            i++;
        }
        return ans;
    }
}