class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int V= graph.length;  
        int[] indegree= new int[V];

        ArrayList<Integer> result= new ArrayList<>();

        Queue<Integer> q= new LinkedList<>();

        //REVERSE THE GRAPH, normal topo
        // Create 'rev' instead of 'adj'
        //creating rev
        ArrayList<ArrayList<Integer>> rev= new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            rev.add(new ArrayList<>());
        }

        //filing the arraylist
        for(int i=0; i<V; i++)
        {
            for(int e: graph[i]) //here, e-> child of the present i, i.e, [i -> e]
            {
                //reversing
                rev.get(e).add(i); //In e’s list, Add its parent i #REVERSED
            }
        }

        //logic starts here, simple topo
        //1.indegree bharte hain, jo zero, add to result
        for(int i=0; i<V; i++)
        {
            for(int it: rev.get(i))
            {
                indegree[it]++;
            }
        }

        //2. checkfor terminals
        for(int i=0; i<V; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        //
        while(!q.isEmpty())
        {
            int node= q.peek();
            q.remove();

            result.add(node);

                for(int it: rev.get(node))
                {
                    indegree[it]--;
                
                if(indegree[it] == 0)
                {
                    q.add(it);
                }
                }
            
        }

        //sorting and returning the answer
        Collections.sort(result);
        return result;
    }
}


        


        




























/*class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=safe
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {

        // if already processed, return if safe
        if (state[node] != 0)
            return state[node] == 2;

        // mark as visiting
        state[node] = 1;

        // visit neighbors
        for (int neigh : graph[node]) {
            if (!dfs(neigh, graph, state)) {
                return false; // leads to cycle
            }
        }

        // all neighbors safe → mark safe
        state[node] = 2;
        return true;
    }
}
*/