class Solution {
    public int findGCD(int[] nums) {

        int n= nums.length;
        int min= nums[0];
        int max= nums[0];
        

        for(int i=0; i<n ; i++)
        {
           
            if(nums[i]>= max)
            {
                max=nums[i];
            }
            if(nums[i]<= min)
            {
                min= nums[i];
            }
            
        }
         
         int c=0;
        
        for(int i=1; i<= max; i++)
        {
            if(min% i==0 && max%i ==0)
            {
                c=i;
            }
        }

       return c;
        
    }
}