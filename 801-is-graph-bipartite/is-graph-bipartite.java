class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];  // 0 = uncolored, 1 = red, -1 = blue

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {  // uncolored → new component
                if (!dfs(graph, color, i, 1))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int currColor) {
        color[node] = currColor;

        for (int neigh : graph[node]) {
            if (color[neigh] == 0) {
                // color neighbor with opposite color
                if (!dfs(graph, color, neigh, -currColor))
                    return false;
            } else if (color[neigh] == currColor) {
                // conflict: same color as parent node
                return false;
            }
        }
        return true;
    }
}
