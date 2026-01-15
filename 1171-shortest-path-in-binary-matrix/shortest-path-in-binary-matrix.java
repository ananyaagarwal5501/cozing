class Solution {
    class Pair
    {
        int row;
         int colmn;
          int cnt;
        Pair(int _row, int _colmn, int _cnt)
        {
            this.row= _row;
            this.colmn= _colmn;
            this.cnt= _cnt;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        //bfs: as unweughted and undirected, going to neghbors just
        //needful        
        int n= grid.length;

        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) //edge case
        {
        return -1;
        } 


        Queue<Pair> q= new LinkedList<>();
        
        int[][] vis= new int[n][n]; //vis array

        q.add(new Pair(0, 0, 1)); // 1 source entry of bfs
        vis[0][0] = 1;//marked source as visited

    
        //padosi
        // 8 directions
        int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};

            //bfs
            while(!q.isEmpty())
            {
                int r= q.peek().row;
                int c= q.peek().colmn;
                int cnt= q.peek().cnt;
                q.remove();

                 // reached destination
                if (r == n-1 && c == n-1) 
                {
                return cnt;
                }
            

                for(int i=0; i<8; i++)
                {
                int nr= r + dr[i];
                int nc= c + dc[i];

                if(nr >= 0 && nr < n &&  nc < n && nc >=0 && 
                grid[nr][nc] == 0 && 
                vis[nr][nc] == 0)
                {
                    vis[nr][nc] = 1;//marked visited
                    q.add(new Pair(nr, nc, cnt+1));
                    
                }               
                }
            }

          return -1;
            
}
}