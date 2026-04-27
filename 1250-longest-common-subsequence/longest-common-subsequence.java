class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int n= text1.length();
        int m= text2.length();
        char[] c1= text1.toCharArray();
        char[] c2= text2.toCharArray();

        int[][] dp= new int[n][m];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return f(c1, c2, n-1, m-1, dp);
    }
    int f(char[] c1, char[] c2, int ind1, int ind2, int[][] dp)
    {
        //base case
        if(ind1 < 0 || ind2 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(c1[ind1] == c2[ind2])
        {
        return dp[ind1][ind2]= 1+ f(c1, c2, ind1-1, ind2-1, dp);
        }
        else
        return dp[ind1][ind2]= 0+ Math.max(f(c1, c2, ind1-1, ind2, dp), f(c1, c2, ind1, ind2-1, dp));
        
    }
}