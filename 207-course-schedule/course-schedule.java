class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //topo hai toh yes o/w no: bfs
        int V= numCourses;
        //needful
        Queue<Integer> q= new LinkedList<>();

        int[] indegree= new int[V];
        ArrayList<Integer> result= new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        //creating adj
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        //filling the adj
        for(int[] e: prerequisites)
        {
            adj.get(e[1]).add(e[0]);
        }

        //Logic start
        //1. filling indegree
        for(int i=0; i<V; i++)
        {
            for(int it: adj.get(i))
            {
                indegree[it]++;
            }
        }

        //2.add to q, if indegree==0
        for(int i=0; i<V; i++)
        {
        if(indegree[i] == 0)
        {
            q.add(i);
        }
        }
        

        //remove from q, add to result, decrease the edge, if indegree==0, add to q
        while(!q.isEmpty())
        {
            int node= q.peek();
            q.remove();

            result.add(node);

            for(int it: adj.get(node))
            {
                indegree[it]--;
            

            
            if(indegree[it] == 0)
            {
                q.add(it);
            }
            }
        }

        //seeing the result
        int s= result.size();
        if(s == V)
        {
            return true;
        }

        return false;
        }
    }

































/*class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // indegree array
        int[] indeg = new int[numCourses];

        // build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);  // pre -> course
            indeg[course]++;           // course depends on pre
        }

        // queue for nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int taken = 0;

        // process queue
        while (!q.isEmpty()) {
            int cur = q.poll();
            taken++;

            for (int nei : adj.get(cur)) {
                indeg[nei]--;
                if (indeg[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // if we processed all courses => no cycle
        return taken == numCourses;
    }
}
*/