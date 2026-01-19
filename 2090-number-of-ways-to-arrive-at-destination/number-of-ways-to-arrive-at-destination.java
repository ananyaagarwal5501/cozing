class Solution {
    class Pair
    {
        long time;
        int node;
        Pair(long _time, int _node)
        {
            this.time= _time;
            this.node= _node;
        }
    }
    public int countPaths(int n, int[][] roads) 
    {
        //sabka time nikal ke min time and then ciount \number of it.
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] road: roads)
        {
            int u= road[0];
            int v= road[1];
            int w= road[2];

            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));

        }
        int mod= (int)(1e9 + 7);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)-> Long.compare(x.time, y.time));
        pq.add(new Pair(0, 0)); //dist, src

        int[] ways= new int[n];
        ways[0] =1;

        long[] dist= new long[n];        
        for(int i=0; i<n; i++)
            {
             dist[i]= (long)1e18;
            }        
        dist[0] = 0;

        while(pq.size() != 0)
        {
            Pair pr= pq.peek();
            int node= pr.node;
            long distance= pr.time;
            pq.remove();

            if (distance > dist[node]) continue;

            //go to padosi, add distance and put in pq.
            for(Pair p: adj.get(node))
            {
                //padosies
                int adjnode= p.node;
                long edW= p.time;

                //1st time arriving with such short path
                //will take the ways of the previous node, either 1 or any other 
                if(edW + distance < dist[adjnode])
                {
                    dist[adjnode]= edW + distance;
                    pq.add(new Pair(dist[adjnode], adjnode));
                    ways[adjnode] = ways[node];
                }

                //when coming to the same node again through the same min distance
                else if(dist[adjnode] == edW + distance)
                {
                    ways[adjnode] = (ways[adjnode] + ways[node])% mod;
                }
            }
        }
        return ways[n-1]; //of the destination node, marked at -1 indexing in the ways array.

    }
}