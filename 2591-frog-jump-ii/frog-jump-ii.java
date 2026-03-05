class Solution {
    public int maxJump(int[] stones) 
    {
        int n= stones.length;

        if(n==1) return 1;
        if (n==2) return stones[1] - stones[0];
        int max=0;
        for(int i=2; i<n; i++)
        {
            int d= stones[i]- stones[i-2];
            max= Math.max(d, max);
        }
        return max;
    }
}