class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int n= text1.length();
        int m= text2.length();
        char[] c1= text1.toCharArray();
        char[] c2= text2.toCharArray();

        int[][] dp= new int[n+1][m+1];

        //base case: Index Shifting
        //if(ind1 == 0 || ind2 == 0) return 0;
        for(int j=0; j<m; j++)
        {
            dp[0][j] = 0;
        }
        for(int i=0; i<n; i++)
        {
            dp[i][0] = 0;
        }

        //if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        for(int ind1=1; ind1<=n; ind1++)
        {
            for(int ind2=1; ind2<=m; ind2++)
            {
                 if(c1[ind1-1] == c2[ind2-1])
                 {
                  dp[ind1][ind2]= 1+ dp[ind1-1][ind2-1];
                 }
                 else
                  {
                  dp[ind1][ind2]= 0+ Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                  }

            }
        }
       
        return dp[n][m];
    }
}