class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ans= new int[2];
        Arrays.fill(ans, -1);
        int n= nums.length;

        int l=0;
        int e= n-1;

        int floor= -1;
        int ceil= n-1;

        while(l<=e)
        {
            int m= l+ (e-l)/2;

            if(nums[m] == target)
            {
                ans[0]= m;
                e= m-1;
            }
             else if (nums[m] < target)
            {
                l = m + 1;
            }
           // else if(nums[m] >= target)
           else
            {
                //ans[1]= m;
                e= m-1;
            }
        }

        l=0;
        e= n-1;

         while(l<=e)
        {
           int m= l+ (e-l)/2;
           if(nums[m] == target)
            {
                ans[1]= m;
                l= m+1;
            }
             else if (nums[m] < target)
            {
                l= m+1;
            }
            else
            {
                e= m-1; 
            }
        }


            //ans[0] +=1;
            //ans[1] = ans[1] -1;
            
        
        return ans;
        
    }
}