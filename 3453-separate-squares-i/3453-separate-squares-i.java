class Solution {
    public double separateSquares(int[][] a) {
        int n = a.length;
        double l = Double.MAX_VALUE;
        double r = Double.MIN_VALUE;
        for(int row[]:a) {
            l = Math.min(l,row[1]);
            r = Math.max(r,row[1] + row[2]);
        }
        double p = 1e-6;
        while(l+p < r){
            double ym = l + (r - l)/2.0f;
            double above = 0.0f;
            double below = 0.0f;
            for(int i=0;i<n;i++){
                double side = a[i][2];
                double area = side * side;
                double y = a[i][1];
                if(y >= ym){
                    above += area;
                }else if(y <= ym - side){
                    below += area;
                }else{
                    above += (y + side - ym) * side;
                    below += (ym - y) * side;
                }
            }
            if(above > below){
                l = ym;
            }else {
                r = ym;
            }
        }

        return l;
    }
}