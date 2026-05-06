class Solution {
    public int maxProfit(int[] prices, int fee) 
    {
        int n= prices.length;
        //int buy=1;

        int[][] dp= new int[n+1][2];
        
        //base
        dp[n][0] =0;
        dp[n][1]=0;

        //loops
        for(int ind= n-1; ind>=0; ind--)
        {
            for(int buy=0; buy<=1; buy++)
            {
                if(buy == 1)
                {
                   dp[ind][buy]= Math.max(-prices[ind] + dp[ind+1][0], 0+ dp[ind+1][1]);
                }
                else
                {
                    dp[ind][buy]= Math.max(prices[ind] + dp[ind+1][1] - fee, 0+ dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];

    }
}