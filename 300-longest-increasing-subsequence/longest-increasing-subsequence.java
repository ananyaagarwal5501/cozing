class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n= nums.length;
        int[][] dp= new int[n][n+1];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i] , -1);
        }
        return f(nums, n, 0, -1, dp);
    }

    int f(int[] nums, int n, int ind, int previ, int[][] dp)
    {
        //base case
        if(ind == n) return 0;
        int len=0;

        //recurrence
        if(dp[ind][previ+1] != -1) return dp[ind][previ+1];
        //ntake
        len= 0+ f(nums, n, ind+1, previ, dp);
        //take
        if(previ == -1 || nums[ind]> nums[previ])
        {
        len= Math.max(len, 1 + f(nums, n, ind+1, ind, dp));
        }

        dp[ind][previ+1] = len;

        return dp[ind][previ+1];
    }
}