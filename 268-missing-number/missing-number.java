//Brute
class Solution {
    public int missingNumber(int[] nums) 
    {
        int l= nums.length;
        int h=0;

        for(int i=0; i<=l; i++)
        
       {
        int flag=0;
        for(int j=0; j<l; j++)
        {
            if(nums[j]== i)
            {
            flag=1;
            break;
            }
        }

        if(flag==0)
        {
            h=i;
        }
        

       }
       return h;
    }
}


/*class Solution {
    public int missingNumber(int[] nums) 
    {
        int l= nums.length;
        int c=0;

        for(int i=0; i<=l; i++)
        {
            int j=0;
            while(j<l) 
            {
                if(nums[j]==i)
                {
                    j++;
                }
            }
           c=i;
        }
        return c;
    }
}



/*class Solution {
    public int missingNumber(int[] nums) 
    {
        int l= nums.length;
        int c=0;
        int b=0;
        for(int i=1; i<=l; i++)
        {
            //does this i exist in the array or not?
            
            for(int j=0; j<l-1; j++) //index elements running
            {
                
                if(nums[j]==i)
                {
                    c++;
                    break;
                }
            }
        
            if(c==0)
            
                b=i;
        }
        return b;
            
        
        
    }
}

       /* int l= nums.length;
        int i=0;

        while(i<l)
        {
            int ci= nums[i];
            if(ci != i && ci < l)
            {
                swap(nums, i, ci);
            }
            else
            {
                i++;
            }
        }

        int p=0;
        for(int j=0; j<l; j++)
        {
            if(nums[j] != i)
            {
                p=j;
            }
        }
        return p;
    }

    void swap(int[] arr, int f, int s)
    {
        int t= arr[f];
        arr[f]= arr[s];
        arr[s]= t;
    }
}
*/