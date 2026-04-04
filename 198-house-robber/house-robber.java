class Solution {
    public int rob(int[] nums) 
    {
        int n= nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp, -1);

        return solve( n,n-1 ,dp, nums);
    }

    int solve(int n, int ind, int[] dp, int[] nums)
    {
        //base cases
        int prev= nums[0]; //if(ind == 0) return nums[0];
        int prev2= 0;      //if(ind == -1) return 0;

       // if(dp[ind] != -1) return dp[ind];
        for(int i=1; i<n; i++)
        {
        int pick= nums[i];
        if(i>1) pick += prev2;

        int npick= 0 + prev;

        int curri=  Math.max(pick, npick);
        prev2= prev;
        prev= curri;
        }
        return prev;
    }
}