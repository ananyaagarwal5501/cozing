class Solution {
    public int countNegatives(int[][] grid) 
    {
        int m= grid.length;
        int n= grid[0].length;

        int c=0;
        for(int i=0; i<m ;i++)
        {
            int e= n-1;
            int l=0;
            int fn= n;

            while(l<=e)
            {
                int mid= l+ (e-l)/2;
                if(grid[i][mid] < 0)
                {
                    fn= mid; //first mid
                    e= mid-1;
                }
                else
                {
                    l= mid+1;
                }
            }
          c= c+ (n-fn);
            
        }

         return c;
    }
   
}