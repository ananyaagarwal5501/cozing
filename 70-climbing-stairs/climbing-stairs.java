/*class Solution {
    public int climbStairs(int n) 
    {
        int c=0;

        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);

        return solve(dp, n);
    }
        public int solve(int[] dp, int n)
        {
            if(n==0) return 1;
            if(n==1) return 1;

            if(dp[n] != -1) return dp[n];
            dp[n] = solve(dp, n-1)+ solve(dp, n-2);
        return dp[n];
       
    }
}*/
class Solution {
    public int climbStairs(int n) 
    {
        int prev= 1;
        int prev1= 1;

        for(int i=2; i<=n; i++)
        {
            int curr= prev+prev1;
            prev1= prev;
            prev= curr;
        }
        return prev;
    }
}