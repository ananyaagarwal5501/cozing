class Solution {
    public int minDays(int[] bloomDay, int m, int k) 
    {
        int n= bloomDay.length;
        if(n< (long) m*k) //not toatl days available as per bouquets //edge case
        {
            return -1;
        }

        int l=Integer.MAX_VALUE;
        int e= 0;

        for(int i: bloomDay)
        {
        l= Math.min(l,i);
        e= Math.max(e, i);
        }

        while(l<=e)
        {
            int mid= l+(e-l)/2;

            if(canmakeornot(mid, k, m, bloomDay))
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

    boolean canmakeornot(int day, int k, int m, int[] arr)
    {
        int countb=0;
        int c=0;

        for(int i: arr)
        {
            if(i <= day) //blooming possible of this 'i'th flower //day==mid
            {
                c++;
            }
            else
            {
                countb=  countb + (c/k);  //cal the number of bouq from these counts
                c=0;//again turn back the counter 0.
            }
        }
              countb=  countb + (c/k); //dont forget to add the last counts
        
        return (countb >= m) ;
    }

}