class Solution {
    class Pair
    {
        int node;
        int stop;
        int wght;
        Pair(int _node, int _stop, int _wght)
        {
            this.node = _node;
            this.stop= _stop;
            this.wght = _wght;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        //directed graph, cyclic, weighted, 
        //adj list
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        //build graph
        for(int[] edge: flights)
        {
            int u= edge[0];
            int v= edge[1];
            int w= edge[2];

            adj.get(u).add(new Pair(v, 0, w));
        }

        //fetch source. see its adj padosiies, cgeck for value of k for it, 
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair( src, 0, 0)); //at source, no. of stops=0, and dist=0

        int[] dist= new int[n];
        for(int i=0; i<n; i++)
        {
            dist[i] = (int)1e9;
        }
        dist[src] = 0;

        while(!q.isEmpty())
        {
            int stps= q.peek().stop;
            int node= q.peek().node;
            int distn= q.peek().wght;
            q.remove();

            if( stps > k) continue;

                for(Pair pr: adj.get(node))
                {
                    int adjNode= pr.node;
                    int edge= pr.wght;

                    if(distn + edge <= dist[adjNode] && stps<=k)
                    {
                        dist[adjNode] = distn + edge;
                        q.add(new Pair(adjNode, stps + 1, dist[adjNode]));

                    }
                }
        }

        return dist[dst] == (int)1e9 ? -1 : dist[dst]; //checking if still the destination node is infinity or some vale, then return.
               
            
        }
       
    }
