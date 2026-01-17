class Solution 
{
    class Pair
    {       
        int node;
        int dist;
        Pair( int _dist, int _node)
        {           
            this.node= _node;
            this.dist= _dist;
        }
    }
    //directed, weighted
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        //adj list for directed graph
       ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) //Java ArrayList is ALWAYS 0-based
        {
            adj.add(new ArrayList<>());
        }

        //build graph
        for(int[] edge: times)
        {
            int u= edge[0]-1;
            int v= edge[1]-1;
            int w= edge[2];

            adj.get(u).add(new Pair(w, v));
        }
        //matter of consideration here: return the->[min-time] for all n nodes ro recieve 

        //therefore, mim path to travel to reach a node, and uodate its time, then take the max of all thee times and return it.

        //thus, by Dij, as shortest path and weighted.
        int[] dist= new int[n];
        for(int i=0; i<n; i++)
        {
            dist[i] = (int)1e9;
        }
        dist[k-1] =0; // as 1-based indexing

        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)-> a.dist - b.dist);
        pq.add(new Pair( 0, k-1)); 

        while(pq.size() != 0)
        {
            Pair p= pq.poll();
            int nd= p.node;
            int d= p.dist;
            //pq.remove();

            if (d > dist[nd]) continue;

            //padosi
            for(Pair pr: adj.get(nd))
            {
                int currNode = pr.node;
                int timeedge= pr.dist;

                int ntime= timeedge + d;

                if(dist[currNode] > ntime)
                { 
                    dist[currNode] = ntime;
                    pq.add(new Pair(dist[currNode], currNode));
                }
            }
        }

        int ans=0;
        for(int i=0; i<n; i++)
        {
            if(dist[i] == (int)1e9) return -1;
            ans= Math.max(ans, dist[i]);
        }

        return ans;




    }
}