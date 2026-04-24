class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n= coins.length;
        int[][] dp= new int[n][amount + 1];
        
        //base case
          for(int sum=0; sum<= amount; sum++)
            {
                if(sum % coins[0] == 0)
                {
                 dp[0][sum]= sum/coins[0];
                }
                else
                {
                  dp[0][sum]= (int)1e9;
                }
            }
        

        //for loop
        for(int ind=1; ind<n; ind++)
        {
            for(int sum=1; sum<= amount; sum++)
            {
                int ntake= dp[ ind-1] [sum];
                int take=(int)1e9;

                 if(coins[ind] <= sum)
                 {
                  take= 1 + dp[ ind] [sum- coins[ind]];
                 }

                dp[ind][sum] = Math.min(take, ntake);
            }
        }
        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount] ;
    }
}