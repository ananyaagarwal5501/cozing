class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m= grid.length;
        int n= grid[0].length;
        int[][] dp= new int[m][n];

         dp[0][0]= grid[0][0];
         //first row
         for(int j= 1; j<n; j++)
         {
            dp[0][j] = grid[0][j] + dp[0][j-1];
         }
         //first col
         for(int i=1; i<m; i++)
         {
            dp[i][0]= grid[i][0] + dp[i-1][0];
         }

        for(int i= 1; i<m; i++)
        {
             for(int j=1; j<n; j++)
             {
                 int left= grid[i][j] + dp[i][j-1];
                 int up= grid[i][j] + dp[i-1][j];
                dp[i][j] = Math.min(left, up);
             }
        }
        return dp[m-1 ][ n-1];
    }
}


/*class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m= grid.length;
        int n= grid[0].length;
        int[][] dp= new int[m][n];
        for(int i=0; i<m; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return f(grid, m-1, n-1, dp);
    }

    int f(int[][] grid, int i, int j, int[][] dp)
    {
       
        if(i == 0 && j == 0) return grid[0][0];
        if(i <0 || j<0) return (int)1e9;;

        if(dp[i][j] != -1) return dp[i][j];
           int left = grid[i][j] + f(grid, i, j-1, dp);
           int up = grid[i][j] + f(grid, i-1, j, dp);       
    
        
        return dp[i][j]= Math.min(left, up);
    }
}*/