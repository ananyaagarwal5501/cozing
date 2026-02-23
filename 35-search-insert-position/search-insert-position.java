class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int n= nums.length;
        int l=0;
        int e= n-1;
        int fp=n;

        while(l<=e)
        {
            int m= l+(e-l)/2;

            if(nums[m] == target)
            {
                return m;
            }

            else if(nums[m] >= target)
            {
                e= m-1; 
            }

            else
            {
              l= m+1;
            }
        }
        return l;
        
    }
}