class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n= nums.length;
        int[][] dp= new int[n+1][n+1];
        
        //base case
        //if(ind == n) return 0;
        int len=0;

        for(int ind=n-1; ind>= 0; ind--)
        {
            for(int previ= ind-1; previ>=-1; previ--)
            {

                //if(dp[ind][previ+1] != -1) return dp[ind][previ+1];
                //ntake
                   len= 0+ dp[ind+1][previ+1];//f(nums, n, ind+1, previ, dp);
                //take
                   if(previ == -1 || nums[ind]> nums[previ])
                   {
                    len= Math.max(len, 1 + dp[ind+ 1][ind+1]);
                   }

                   dp[ind][previ+1] = len;
            }
        }
        //recurrence
        

        return dp[0][-1+1];
    }
}