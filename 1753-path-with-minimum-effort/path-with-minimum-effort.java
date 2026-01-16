class Solution {
    class Pair
    {
        int diff;
        int row;
        int col;
        Pair(int _diff, int _row, int _col)
        {
            this.diff= _diff;
            this.row = _row;
            this.col= _col;        }
    }
    public int minimumEffortPath(int[][] heights) 
    {
        //naap
        int n= heights.length;
        int m= heights[0].length;

       
        //diff : dijkstras

        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)-> a.diff - b.diff);
        pq.add(new Pair(0, 0, 0)); //the start

        int[][] dist= new int[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;

        //padosi: 4 directions
        int[] dr= {0, 1, 0, -1};
        int[] dc= {1, 0, -1, 0};

        while(pq.size() != 0)
        {
            int r= pq.peek().row;
            int c= pq.peek().col;
            int dif= pq.peek().diff;
            pq.remove();

            for(int i=0; i<4; i++)
            {
            int nr= r+ dr[i];
            int nc= c+ dc[i];

            if(r== n-1 && c == m-1) return  dif;

            if(nr>=0 && nr < n && nc>=0 && nc< m)
            {
                int newEffort= Math.max( Math.abs(heights[nr][nc] - heights[r][c]), dif); 

                if(newEffort < dist[nr][nc])
                {
                pq.add(new Pair(newEffort, nr, nc));
                dist[nr][nc] =newEffort;
                }
            }
            }

        }
        return 0;
        
    }
}