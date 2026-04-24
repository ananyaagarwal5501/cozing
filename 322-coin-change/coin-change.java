class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n= coins.length;
        int[][] dp= new int[n][amount + 1];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        int ans= f(coins, n-1, amount, dp);
        return (ans >= (int)1e9) ?  -1 : ans;
    }

    int f(int[] coins, int ind, int sum, int[][] dp )
    {
        //base case
        if(sum == 0) return 0;
        if(ind== 0) 
        {
            if(sum % coins[ind] == 0)
            {
                return sum / coins[ind];
            }
            return (int)1e9;
        }

        if(dp[ind][sum] != -1) return dp[ind][sum];
         //stuff
         int ntake= f(coins, ind-1, sum, dp);
         int take=(int)1e9;

        if(coins[ind] <= sum)
        {
         take= 1 + f(coins, ind, sum- coins[ind], dp);
        }

         //min
         return dp[ind][sum]= Math.min(take, ntake);
    }
}