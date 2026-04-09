class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int[][] grid= obstacleGrid;
        int m= grid.length;
        int n= grid[0].length;

        int dp[][]= new int[m][n];

        //base case
        if(grid[0][0] == 1) return 0;
        //if(i<0 || j<0) return 0;
        //if(grid[i][j] == 1) dp[i][j] = 0;
        for(int i=0; i<m; i++) 
        {
         if(grid[i][0] == 1) break;
         dp[i][0] =1;
        }
        for(int j=0; j<n; j++)
        {
         if(grid[0][j] == 1) break;
         dp[0][j] =1;
         
        }

        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(grid[i][j] ==1) dp[i][j]= 0;
                else
                {
                int left= dp[i][j-1];
                int up= dp[i-1][j];
                dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

/*class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int[][] grid= obstacleGrid;
        int m= grid.length;
        int n= grid[0].length;

        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return f(grid, m-1, n-1, dp);
    }

    int f(int[][] grid, int i, int j, int[][] dp)
    {
        if(i<0 || j<0) return 0;
        if(grid[i][j] == 1) return 0;
        if(i==0 && j==0) dp[i][j] =1;

        if(dp[i][j] != -1) return dp[i][j];
        int left= f(grid, i-1, j, dp);
        int up= f(grid, i, j-1, dp);

        return dp[i][j]= left+ up;
    }
}*/