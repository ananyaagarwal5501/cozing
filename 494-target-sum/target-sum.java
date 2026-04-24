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
        return f(nums, n-1, k/2);
    }

     int f(int[] nums, int ind, int k)
    {
        //base cases
        //if(k ==0 ) return 1;
        if(ind == 0)
        {
            if(nums[ind] == 0 && k == nums[0]) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }

        //stuff
        int ntake= f(nums, ind-1, k);
        int take= 0;
        if(nums[ind] <= k) take=  f(nums, ind-1, k- nums[ind]);

        return take + ntake;
    }
}