class Solution {
    public int findMin(int[] nums) 
    {
        int n= nums.length;
        int peak= n-1;
        for(int i=0; i<n-1; i++)
        {
            if(nums[i]> nums[i+1])
            {
                peak= i;
            }
        }
        int least= 0;
        if(peak != n-1) least= peak+ 1;
        
        //int e= n-1;
        
        return nums[least];
    }
}