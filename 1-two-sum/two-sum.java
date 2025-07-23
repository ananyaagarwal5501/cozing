class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n=nums.length;
        int[] b= new int[2];

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(nums[i]+ nums[j]== target)
                {
                   b[0]=i;
                b[1]=j;  
                }
            }
        }
        return b;
    }
}


/*
//2-pointer
class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n=nums.length;
        int[] b= new int[2];

        int s=0;
        int e= n-1; 

        //isme dikkat ki as s<=e hai, so e does nt goes till the position that comtains 7. 

        while(s<=e)
        {
            if(nums[s]+ nums[e]== target)
            {
                b[0]=s;
                b[1]=e;
            }
           
                s++;
                e--;
            
        }

        return b;
    }
}

//runs but cannot submit
/*class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int n=nums.length;
        int[] b= new int[2];
        for(int i=0; i<n-1; i++)
        {
            if((nums[i]+ nums[i+1]) == target)
            {
                b[0]= i;
                b[1]= i+1;
                //b[i+1]= nums[i+1];
            }
        }

        return b;
        
    }
}*/