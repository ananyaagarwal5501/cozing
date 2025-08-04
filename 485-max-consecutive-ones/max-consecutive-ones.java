class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }
}


/*class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int n= nums.length;
        int count=0;
        int max= 0;
        int sum=0;

       
        for(int j=0; j<n; j++)
        {
           sum= sum+ nums[j];
        }
        if(sum==0)
        {
            return 0;
        }
        

         int i=0;
        while(i<n)
        {
            if(nums[i]==0)
            {
                count=0;
                i++;
                        
            }                       
            count++;
            i++;

            if(count>=max)
            {
                max= count;
            }

        }
        return max;
        
    }
}
*/
/*class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int n= nums.length;
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n;j++)
            {
                if()
            }
        }*/
        