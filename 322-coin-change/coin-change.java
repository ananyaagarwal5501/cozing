class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n= coins.length;
        int[] prev= new int[amount +1];
        int[] curr= new int[amount +1];

        //int[][] dp= new int[n][amount + 1];
        
        //base case
          for(int sum=0; sum<= amount; sum++)
            {
                if(sum % coins[0] == 0)
                {
                 prev[sum]= sum/coins[0];
                }
                else
                {
                  prev[sum]= (int)1e9;
                }
            }
        

        //for loop
        for(int ind=1; ind<n; ind++)
        {
            for(int sum=1; sum<= amount; sum++)
            {
                int ntake= prev[sum];
                int take=(int)1e9;

                 if(coins[ind] <= sum)
                 {
                  take= 1 + curr[sum- coins[ind]];
                 }

                curr[sum] = Math.min(take, ntake);
            }
            prev= curr;
        }
        return prev[amount] >= (int)1e9 ? -1 : prev[amount] ;
    }
}