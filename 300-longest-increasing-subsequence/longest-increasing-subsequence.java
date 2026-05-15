class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n= nums.length;
        int c=0;
        int[][] dp= new int[n][n+1];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return f(nums, 0, -1, n, dp);
    }

    int f(int[] nums, int ind, int prev, int n, int[][] dp)
    {
        //base case
        if(ind == n) return 0;

        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        //recurrece
        int ntake= 0 + f(nums, ind+1, prev, n, dp);
        int take=0;
        if(prev == -1 || nums[ind]> nums[prev])
        {
            take= 1+ f(nums, ind+1, ind, n, dp);
        }

     int max= Math.max(take, ntake);

     return  dp[ind][prev+1] =  max;   
    }
}