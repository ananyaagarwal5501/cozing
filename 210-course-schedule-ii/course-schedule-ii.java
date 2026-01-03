class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        //topo hai toh yes o/w no: bfs
        int V= numCourses;
        //needful
        Queue<Integer> q= new LinkedList<>();

        int[] indegree= new int[V];
        //ArrayList<Integer> result= new ArrayList<>();
        int[] result= new int[V];

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
        int i=0;
        while(!q.isEmpty())
        {
            int node= q.peek();
            q.remove();

            result[i++]= node;

            for(int it: adj.get(node))
            {
                indegree[it]--;
            

            
            if(indegree[it] == 0)
            {
                q.add(it);
            }
            }
        }

        if(i == V)
        {
            return result;
        }

        return new int[0];
        }
    }
































