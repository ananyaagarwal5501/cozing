class Solution 
{
    class DisjointSet
    {
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> rank= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();

        public DisjointSet(int n)
        {
            for(int i=0; i<n; i++)
            {
                parent.add(i);
                rank.add( 0);
                size.add(1);
            }            
        }

        public int findUp(int node)
        {
            if(parent.get(node) == node) return node;
            else
            {
                int ulp= findUp( parent.get(node));
                parent.set(node, ulp);
                return parent.get(node);
            }           
        }

        void unionByRank(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return; //same leader of both, no need further

            if(rank.get(pu) < rank.get(pv))
            {
                parent.set(pu, pv);
            }

            else if(rank.get(pu) > rank.get(pv))
            {
                parent.set(pv, pu);
            }

            else //both ranks same, rank+1, join any 
            {
                parent.set(pu, pv);
                rank.set(pv, rank.get(pv) +1);
            }
        }

        void unionBySize(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return;

            if(size.get(pu) < size.get(pv))
            {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
            else
            {
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            }
        }
    }

    public int removeStones(int[][] stones) 
    {
        int maxRow=0;
        int maxCol=0;
        for(int[] stone: stones)
        {
            maxRow = Math.max(maxRow, stone[0]); //know the max size of row
            maxCol = Math.max(maxCol, stone[1]); //know the max size of col
        }

        DisjointSet ds= new DisjointSet(maxRow+ maxCol+ 2);//+1 for safety
      
        Set<Integer> usedNodes = new HashSet<>();

        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1;

            ds.unionBySize(rowNode, colNode);
            usedNodes.add(rowNode);
            usedNodes.add(colNode);
        }

        int components = 0;
        for (int node : usedNodes) {
            if (ds.findUp(node) == node)
                components++;
        }

        return stones.length - components;
    }
}

        
    
