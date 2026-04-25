class Solution {
    public int change(int amount, int[] coins) 
    {
        int n= coins.length;
        int[][] dp= new int[n][amount+1];
        
        //base case
        if(amount == 0) 
        {
          for(int i=0; i<n; i++)
          {
            dp[i][0] = 1;
          }
        }
         for(int i=0; i<=amount; i++)
            {
                if(i % coins[0] == 0) dp[0][i] = 1;
                else
                dp[0][i] = 0;
            }
        for(int ind=1; ind<n; ind++)
        {
            for(int tar=0; tar<= amount; tar++)
            {
                int ntake= dp[ind-1][tar];
                int take=0;
                if(coins[ind]<= tar)
                {
                 take= dp[ind][tar- coins[ind]];
                }
                dp[ind][tar]= take + ntake;
            }
        }
        

        return dp[n-1][amount];


    }
}