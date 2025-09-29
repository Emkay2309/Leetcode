class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1;i<=n ; i++) {
            arr.add(i);
        }

        int i=0;

        while(arr.size()>1) {
            int del = i+k-1;
            int size = arr.size();
            del = del%size;

            arr.remove(del);
            i=del;
        }

        return arr.get(0);
    }
}