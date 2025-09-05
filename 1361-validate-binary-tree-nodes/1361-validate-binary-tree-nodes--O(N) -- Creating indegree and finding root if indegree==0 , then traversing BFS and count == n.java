class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int [] inDegree = new int [n];

        // 1. create indegree
        for(int i=0; i<n ; i++) {
            int lc = leftChild[i];
            int rc = rightChild[i];

            if(lc != -1) {
                inDegree[lc]++;
                if(inDegree[lc] > 1) return false;
            }
            if(rc != -1) {
                inDegree[rc]++;
                if(inDegree[rc] > 1) return false;
            }
        }

        // 2. Find root which is inDegree 0 index
        int root = -1;
        for(int i=0; i<n ; i++) {
            if(inDegree[i] == 0) {
                if(root != -1) return  false;  // more than 1 root
                root = i;
            }
        }

        if(root == -1) return false; //no root found

        // 3. check if the tree is fully connected
        boolean [] vis = new boolean [n];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(vis[curr]) return false;
            vis[curr] = true;

            int lc = leftChild[curr];
            int rc = rightChild[curr];

            if(lc != -1) q.add(lc);
            if(rc != -1) q.add(rc);
        }

        // 4. Ensure all nodes are visited
        for(boolean v : vis) {
            if(!v) return false;
        }
        return true;
    }
}