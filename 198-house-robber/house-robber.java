class Solution {
    public int rob(int[] nums) 
    {
        int n= nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp, -1);

        return solve( n-1 ,dp, nums);
    }

    int solve(int ind, int[] dp, int[] nums)
    {
        //base cases
        if(ind == 0) return nums[0];
        if(ind == -1) return 0;

        if(dp[ind] != -1) return dp[ind];
        
        int pick= nums[ind] + solve(ind-2, dp, nums);
        int npick= 0 + solve(ind-1, dp, nums);

        dp[ind]= Math.max(pick, npick);
        
        return dp[ind];
    }
}