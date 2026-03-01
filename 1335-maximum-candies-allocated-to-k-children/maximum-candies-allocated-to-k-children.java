class Solution {
    public int maximumCandies(int[] candies, long k) 
    {
        
       int n= candies.length;
        int l=1;
        int e=0;
        for(int p: candies)
        e= Math.max(e, p);

        while(l<=e)
        {
            int mid= l+(e-l)/2;
            long sum=0;
            for(int i=0; i<n; i++)
            {  
                sum = sum + candies[i]/mid; /////////FIRE FOR CEIL
            }
                
                if(sum >= k)
                {
                    l= mid+1;
                     //try slower
                }
                else
                {
                     e= mid-1;//try faster
                }
        }
        return e;
    }
}
  