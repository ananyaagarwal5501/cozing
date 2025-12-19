

        class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // color[i] = -1 → not colored
        // color[i] = 0 or 1 → two different sets
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // graph may be disconnected
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                // start BFS
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            // color with opposite color
                            color[nei] = 1 - color[node];
                            q.add(nei);
                        } 
                        // conflict found
                        else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
