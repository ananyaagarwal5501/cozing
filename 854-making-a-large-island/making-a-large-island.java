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
                rank.add(0);
                size.add(1);
            }
        }

        int findUp(int node)
        {
            if(parent.get(node) == node) return node;
            else
            {
                int ulp= findUp( parent.get(node));
                parent.set(node, ulp);
                 return parent.get(node);
            }
        }

        //union by rank
        public void unionByRank(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return;
            if(rank.get(pu) > rank.get(pv))
            {
                parent.set(pv, parent.get(pu));
            }
            else if(rank.get(pv) > rank.get(pu))
            {
                parent.set(pu, parent.get(pv));
            }
            else
            {
                parent.set(pv, parent.get(pu));
                rank.set(pu, rank.get(pu)+1);
            }
        }
        
        //union by size
        public void unionBySize(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return;
            if(size.get(pu) > size.get(pv))
            {
                parent.set(pv, parent.get(pu));
                size.set(pu, size.get(pu) + size.get(pv));
            }
            else
            {
                parent.set(pu, parent.get(pv));
                size.set(pv, size.get(pu) + size.get(pv));
            }
        }       
    }
    
    public int largestIsland(int[][] grid) 
    {
        //needful
        int n= grid.length;
        DisjointSet ds= new DisjointSet(n*n);   
        //int[][] vis= new int[n][n];

        //step 1, make the pre-existing islands
        for(int r=0; r<n; r++)
        {
            for(int c=0; c<n; c++)
            {
                    if(grid[r][c] == 0) continue;                
                    //vis[r][c] = 1;
                    int[] dr= {-1, 0, 1, 0}; //padosi
                    int[] dc= {0, 1, 0, -1};                    
                    for(int i=0; i<4; i++)
                    {
                        int nr= r + dr[i];
                        int nc= c + dc[i];
                        if(nr>=0 && nr<n && nc>=0 && nc<n)
                        {//if padosi is an island, 
                           if(grid[nr][nc] == 1)
                           {
                            //need to check if node and padosi are bhai[by node ids], obv not pagal! rn, sab alag nodes hain
                               int nodeid= r*n + c;
                               int adjnodeid= nr*n + nc;
                                //connect then
                                  ds.unionBySize(nodeid, adjnodeid);    
                        }       }    
                    }
            }
        }

        //step 2, now, turning the left zeros of the grid and with the help of Set, finding the max size of islands.
        
        int max= Integer.MIN_VALUE;

        for(int r=0; r<n; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(grid[r][c] == 1) continue;
                int[] dr= {-1, 0, 1, 0}; //padosi
                int[] dc= {0, 1, 0, -1};    
                HashSet<Integer> set= new HashSet<>();   //for each 0 
                for(int i=0; i<4; i++)
                 {
                    int nr= r + dr[i];
                    int nc= c + dc[i];
                    if(nr>=0 && nr<n && nc>=0 && nc<n)
                        { //if padosi island hai
                            if(grid[nr][nc] == 1)
                            { //then, uska ulp store karlo in set
                               set.add(ds.findUp(nr*n + nc));
                            }
                        }
                 }
                 //bas ab per 0 ke per size sum in the set ka max return kardo
                 int sizeTotal=0;
                 for(Integer parent: set)
                 {
                    sizeTotal +=  ds.size.get(parent);
                 }
                 max= Math.max(max, sizeTotal + 1); //GOT THE MAX SIZE ISLAND AFTER CHANGING
            }
        }

        //edge: what if no zeros present, just find the ulp.. [step 2 never runs]
        for(int celln=0; celln< n*n; celln++)
        {
            max= Math.max(max, ds.size.get(ds.findUp(celln)));
        }
        return max;

    }
}