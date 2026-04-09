class Solution {
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
}