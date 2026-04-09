class Solution {
    public int uniquePaths(int m, int n) 
    {
      int[][] dp= new int[m][n];
      for(int i=0; i<m; i++)
      {
        Arrays.fill(dp[i], -1);
      }  
      return f(m-1, n-1, dp); //starting point 
    }

    int f(int i, int j, int[][] dp)
    {
        //base cases
        if(i == 0 && j == 0) return 1; //reached dest, count path
        if(i<0 || j<0) return 0; //out of boundary

        if(dp[i][j] != -1) return dp[i][j];
        int left= f(i, j-1, dp);
        int up= f(i-1, j, dp);

        return dp[i][j] = left + up;
    }
}