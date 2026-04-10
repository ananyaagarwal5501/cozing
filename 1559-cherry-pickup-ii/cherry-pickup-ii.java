class Solution {
    public int cherryPickup(int[][] grid) 
    {
        int m = grid.length;
        int n= grid[0].length;

        int[][][] dp= new int[m][n][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
            Arrays.fill(dp[i][j], -1);
            }
        }
        return f(grid, 0, 0, n-1, dp);
    }

        int f(int[][] a, int i, int j1, int j2, int[][][] dp)
        {
        //base case
        if(j1<0 || j1>= a[0].length || j2<0 || j2>= a[0].length) return (int)-1e9;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        if(i == a.length-1)
        {
            if( j1 == j2)  return dp[i][j1][j2]= a[i][j1];
            else
            {
                 return dp[i][j1][j2]= a[i][j1] + a[i][j2];
            }
        }

        int maxi=0;
        for(int dj1=-1; dj1<=1; dj1++)
        {
            for(int dj2=-1; dj2<=1; dj2++)
            {
                if(j1 == j2)  maxi= Math.max(maxi, a[i][j1] + f(a, i+1, j1+dj1, j2+dj2, dp));
                else
                {
                    maxi= Math.max(maxi, a[i][j1] + a[i][j2] + f(a, i+1, j1+dj1, j2+dj2, dp));
                }
            }
        }
        return dp[i][j1][j2]= maxi;
        
    }
}