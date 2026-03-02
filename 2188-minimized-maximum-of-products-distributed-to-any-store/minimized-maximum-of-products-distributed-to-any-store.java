class Solution {
    public int minimizedMaximum(int n, int[] quantities) 
    {
        int l=1; // as if mid =0, then x/0 not possible.
        int e= 0;
        for(int q: quantities)
        {
            e= Math.max(e, q);
        }

        while(l<=e)
        {
            int mid= l+(e-l)/2;
            int stores=0;
            for(int q: quantities)
            {
                stores= stores+ (q+ mid-1) / mid; //ceil 
            }

            if(stores <= n) //stores are less, so to inc stores, we can dec the mid, thus go left
            {
                 e= mid-1;
            }
            else
            {
                l= mid+1;
                
            }
        }
        return l;
    }
}