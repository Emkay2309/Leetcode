class Solution {
    public int findClosest(int x, int y, int z) {
        
        int firstDist = Math.abs(x-z);
        int secondDist = Math.abs(y-z);

        return (firstDist == secondDist) ? 0 : (firstDist < secondDist ? 1 : 2);
    }
}