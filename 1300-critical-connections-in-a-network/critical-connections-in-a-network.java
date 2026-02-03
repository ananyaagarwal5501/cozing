import java.util.*;

class Solution {

    List<List<Integer>> adj;
    List<List<Integer>> bridges;
    int[] tin, low;
    boolean[] visited;
    int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // build graph
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (List<Integer> e : connections) {
            int u = e.get(0), v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bridges = new ArrayList<>();
        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];

        // graph is connected, but still safe to loop
        dfs(0, -1);

        return bridges;
    }

    void dfs(int u, int parent) {
        visited[u] = true;
        tin[u] = low[u] = timer++;

        for (int v : adj.get(u)) {

            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u);

                // update low-link value
                low[u] = Math.min(low[u], low[v]);

                // bridge condition
                if (low[v] > tin[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } 
            else {
                // back edge
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }
}
