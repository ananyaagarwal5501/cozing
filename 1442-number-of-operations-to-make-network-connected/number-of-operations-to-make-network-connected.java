class Solution
{
    class DisjointSet
    {
        //needful for disjoint
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> rank= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();

        //filling the needful lists
        public DisjointSet(int n)
        {
            for(int i=0; i<n; i++)
            {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        //finding the ultimate parent of a node
        public int findUP(int node)
        {
            if(node == parent.get(node))
            {
                return node;
            }
            int ulp = findUP(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        

        //now, union by rank
        void unionByRank(int u, int v)
        {
            int pu= findUP(u);
            int pv= findUP(v);

            if(pu == pv)
            {
                return;
            }
            if(rank.get(pu) < rank.get(pv))
            {
                parent.set(pu, pv);
            }
            else if(rank.get(pu) > rank.get(pv))
            {
                parent.set(pv, pu);
            }
            else
            {
                parent.set(pu, pv);
                rank.set(pu, rank.get(pu) +1);
            }
        }

        //by size
        void unionBySize(int u, int v)
        {
            int pu= findUP(u);
            int pv= findUP(v);

            if(pu == pv) return;
            if(size.get(pu) < size.get(pv))
            {
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            }
            else
            {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }

    public int makeConnected(int n, int[][] connections) 
    {
        //edge case: the number of connections should be atleast n-1
        if(connections.length < n-1)
        {
            return -1;
        }

        DisjointSet ds= new DisjointSet(n); //calling the disjoint ds we just made

        int cntExtras=0;
        int m= connections.length;

        for(int i=0; i<m; i++)
        {
            int u= connections[i][0];
            int v= connections[i][1];
            if(ds.findUP(u) == ds.findUP(v))
            {
                cntExtras++;
            }
            else
            {
                ds.unionBySize(u, v);
            }
        }

        int cntC=0;
        for(int i=0; i<n; i++)
        {
            if(ds.parent.get(i) == i) cntC++;
        }

        int ans = cntC -1;
        if(cntExtras >= ans) return ans;
        return -1;
        
        
    }
}