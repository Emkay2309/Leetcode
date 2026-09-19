class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int distance = nearestPointOfRectangleToCircle(radius , xCenter , yCenter , x1 , y1 , x2 , y2);
        return distance <= radius;
    }

    public int nearestPointOfRectangleToCircle(int radius ,int xcenter, int ycenter , int x1 , int y1 , int x2 , int y2 ) {
        int nx = xcenter ,  ny = ycenter;

        if(xcenter < x1) {
            nx = x1;
        }
        else if(xcenter > x2) {
            nx = x2;
        }
        else if(ycenter < y2 && ycenter > y1){
            ny = ycenter;
        }

        if(ycenter < y1) {
            ny = y1;
        }
        else if(ycenter > y2) {
            ny = y2;
        }
        else if(ycenter < y2 && ycenter > y1){
            ny = ycenter;
        }

        int dx = xcenter - nx;
        int dy = ycenter - ny;
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}