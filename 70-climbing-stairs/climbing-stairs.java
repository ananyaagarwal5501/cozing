class Solution { //tabulation tc=0(n), sc=0(1)
    public int climbStairs(int n) 
    {
        int[] dp= new int[n+1]; //doesnt signify the number of ways count, but for each step, the computation stored for it
       Arrays.fill(dp, -1);

        //start from base
        dp[0]= 1;
        dp[1]= 1;

        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
       





/*class Solution { //memoization tc=0(n), sc=0(n)+ aarylist 0(n)
    public int climbStairs(int n) 
    {
        int[] dp= new int[n+1]; //doesnt signify the number of ways count, but for each step, the computation stored for it
       Arrays.fill(dp, -1);
       return helper(dp, n);
    }

       int helper(int[] dp, int n)
       {
        //edge cases
        if(n==0) return 1;
        if(n==1) return 1;

        if(dp[n] != -1) return dp[n];

        dp[n]= helper(dp, n-1) + helper(dp, n-2);
        return dp[n];

           
    }
}*/