class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n= piles.length;
        int l=1;
        int e=0;
        for(int p: piles)
        e= Math.max(e, p);

        while(l<=e)
        {
            int mid= l+(e-l)/2;
            long sum=0;
            for(int i=0; i<n; i++)
            {  
                sum = sum + (piles[i]+ mid-1)/mid; /////////FIRE FOR CEIL
            }
                
                if(sum <= h)
                {
                    e= mid-1; //try slower
                }
                else
                {
                    l= mid+1; //try faster
                }
        }
        return l;
    }
}