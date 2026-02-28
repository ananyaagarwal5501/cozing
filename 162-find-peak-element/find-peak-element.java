class Solution {
    public int findPeakElement(int[] nums) 
    {
        int n= nums.length;

        if(n==1) return 0;
        //edge cases for the corner elements
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int l=1; 
        int e= n-2;

        while(l<=e)
        {
            int m= l+(e-l)/2;

            if(nums[m] > nums[m-1] && nums[m]> nums[m+1])
            {
                return m;
            }

            else if(nums[m] > nums[m-1] && nums[m] <  nums[m+1]) //m on increasing slope 
            {
                l= m+1;
            }

            else if(nums[m] < nums[m-1] && nums[m] >  nums[m+1]) //m on decreasing slope 
            {
                e= m-1;
            }
            //extra case for multiple peaks, as peaks all sides-> go any side
            else
            {
                e= m-1;
            }
        }
        return -1; //dummy return

        
    }
}