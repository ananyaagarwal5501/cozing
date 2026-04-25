class Solution {
    public int change(int amount, int[] coins) 
    {
        int n= coins.length;
        int[] prev= new int[amount+1];
        int[] curr= new int[amount+1];
        //int[][] dp= new int[n][amount+1];
        
        //base case
        if(amount == 0) 
        {
          for(int i=0; i<n; i++)
          {
            prev[0] = 1;
          }
        }
         for(int i=0; i<=amount; i++)
            {
                if(i % coins[0] == 0) prev[i] = 1;
                else
                prev[i] = 0;
            }
        for(int ind=1; ind<n; ind++)
        {
            for(int tar=0; tar<= amount; tar++)
            {
                int ntake= prev[tar];
                int take=0;
                if(coins[ind]<= tar)
                {
                 take= curr[tar- coins[ind]];
                }
                curr[tar]= take + ntake;
            }
            prev= curr;
        }
        

        return prev[amount];


    }
}