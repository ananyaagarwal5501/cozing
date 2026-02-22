class Solution {
    public int search(int[] nums, int target) 
    {
        int n= nums.length;
        int l=0;
        int e= n-1;


        while(l<=e)
        {
        int m= l+ (e-l)/2;
        if(nums[m] == target)
        {
            return m;
        }

        else if(target> nums[m])
        {
            l= m+1;
        }

        else 
        {
            e= m-1;
        }
    }
    return -1;
    
}
}