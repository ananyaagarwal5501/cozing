class Solution {
    public int mySqrt(int x) 
    {
        //range for the ansewwer, bs will run in the range
        int l= 1;
        int e= x/2;

        if(x<2) return x;
        while(l<=e)
        {
            //largest m such that m*m ≤ x
            int m= l+(e-l)/2;
            if((long)m*m <= x)
            {
                //m could be the answer but we can go more right
                l= m+1;
            }
            else
            {
                e= m-1;
            }
        }
        //l ends at first false
        //e ends at last true ✅
        //return e

        return e;       
    }
}