class Solution {
    public int search(int[] nums, int target) 
    {
        int n= nums.length;
        int peak=n-1;
        for(int i=0; i<n-1; i++)
        {
            if(nums[i]> nums[i+1])
            {
                peak= i; //peak got of rotated array
                break;
            }
        }
        int l=0;
        int e=n-1;

        if(target == nums[peak]) return peak;
        if(target == nums[l]) return l;

         if(target< nums[peak] && target >= nums[l])
        {
            l=0;
            e= peak-1;           
        }
        else
        {
            l= peak+1;
            e=n-1;
        }



         
        //if(target< nums[peak] && target < nums[l])
        
            while(l<=e)
            {
                int m= l+ (e-l)/2;
                if(nums[m] == target)
                {
                    return m;
                }
                else if(nums[m] > target)
                {
                    e= m-1;
                }
                else
                {
                    l= m+1;
                    
                }
            }
        

        return -1;
        
    }
}