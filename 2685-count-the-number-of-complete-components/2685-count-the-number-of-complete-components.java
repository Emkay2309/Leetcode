import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Initialize DSU
        int[] parent = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // Find function with path compression
        class DSUHelper {
            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }
            
            void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                
                if (rootX == rootY) return;
                
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
        
        DSUHelper dsu = new DSUHelper();
        int[] degree = new int[n];
        
        // Process edges
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        
        // Group nodes by root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        int completeComponents = 0;
        
        // Check each group
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int root = entry.getKey();
            List<Integer> nodes = entry.getValue();
            int componentSize = size[root];
            
            boolean isComplete = true;
            for (int node : nodes) {
                if (degree[node] != componentSize - 1) {
                    isComplete = false;
                    break;
                }
            }
            
            if (isComplete) {
                completeComponents++;
            }
        }
        
        return completeComponents;
    }
}