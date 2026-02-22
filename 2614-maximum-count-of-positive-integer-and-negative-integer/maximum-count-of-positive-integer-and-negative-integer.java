class Solution {
    public int maximumCount(int[] nums) 
    {
        int n= nums.length;
        int ln= -1;
        int l= 0;
        int e= n-1;
        int fp=n;
        int neg=0;
        int pos=0; 

        while(l<=e)
        {
            int m= l+ (e-l)/2;
            if(nums[m] <0)
            {
                ln= m; //possible answer
                l= m+1;               
            }
            else
            {
                e= m-1;
            }
        }
        neg= ln+1;

        e=n-1;
        l=0;
        while(l<=e)
        {
            int m= l+ (e-l)/2;
            if(nums[m] >0)
            {
                fp= m; //possible answer
                e= m-1;         
            }
            else
            {
                
                l= m+1;
            }
        }
        pos= n-fp;

        return Math.max(neg, pos);
    }
}