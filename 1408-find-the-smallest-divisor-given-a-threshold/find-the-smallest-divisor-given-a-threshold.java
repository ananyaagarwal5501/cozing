class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        //smallest mid(divisor)
        int n= nums.length;
        int sum=0;
        int l= 1;
        int e=0;
        for(int i: nums)
        {
            e= Math.max(i, e);
        }

        while(l<=e)
        {
            int mid= l+ (e-l)/2; //divisor
            if(canbedivisor(mid, threshold, nums)) //can tr smaller
            {
                e= mid-1;
            }
            else
            {
                l= mid+1;;
            }

        }
        return l; //dummy return
    }

    boolean canbedivisor(int div, int threshold, int[] nums)
    {
        int s=0;
        for(int i: nums)
        {
            s= s+(i + div - 1)/div;
        }
        return s<= threshold;
    }
}