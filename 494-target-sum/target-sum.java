class Solution {
    public int findTargetSumWays(int[] nums, int target) 
    {
        int n= nums.length;
        int ts=0;
        for(int i=0; i<n; i++)
        {
            ts= ts+ nums[i];
        }
        int k= (ts +target);
        if(Math.abs(target) > ts) return 0;
        if(k%2 != 0) return 0;
        if(k < 0) return 0;
        k= k/2;
        int[][] dp= new int[n][k+1];
       
        //base cases
        //if(k ==0 ) return 1;
        if (nums[0] == 0) {
            dp[0][0] = 2; // take or not take
        } else {
            dp[0][0] = 1; // not take
            if (nums[0] <= k)
                dp[0][nums[0]] = 1; // take
        }


        for(int ind= 1; ind<n; ind++)
        {
            for(int sum=0; sum<= k; sum++)
            {
                //stuff
              int ntake= dp[ind-1][sum];
              int take= 0;
              if(nums[ind] <= sum)  take = dp[ind-1][sum- nums[ind]];
              dp[ind][sum]= take + ntake;
            }
        }
        
        return dp[n-1][k];
    }
}