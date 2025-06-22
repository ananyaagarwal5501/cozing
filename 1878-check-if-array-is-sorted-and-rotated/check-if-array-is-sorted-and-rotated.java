/*me before lesrning the pattern, not solved!
class Solution {
    public boolean check(int[] nums) {
        
        
        int n= nums.length;
        int[] ar= new int[n];
        boolean b=true;
        for(int i=0; i<n ;i++)
        {
            if(ar[i]= nums[(i+x)% n]);
            {
                return b;
            }
            if(nums[i+1]>nums[i]){

            }
        }
    }
}*/

/*class Solution {
    public boolean check(int[] nums) 
    {
        int n= nums.length;
        int k;
        boolean b=true;
        int[] temp= new int[n];//rotated array

        for(int i=0; i<n ; i++)
        {
            temp[(i+k)%n]= nums[i];
        }

        for(int i=0; i<n ; i++)
        {
            if(temp[i]== nums[(i+k)%n])
            {
                b= true;;
            }
            else
            {
                b= false;
            }
        }  

        return b; 
    }
}*/

class Solution {
    public boolean check(int[] nums) 
    {
        int n= nums.length;
        boolean b=true;
        int c=0;

        for(int i=1; i<n ; i++) //start loop from 1 to avoid out of bounds but,
        {
            if(nums[i-1]> nums[i])
            {
                
                c++;
            }
        }
             if(nums[n-1]> nums[0]) // not leaving the 1st element to check also
             {
                c++;

             }
        

             if(c<=1)
             {
                b=true;
             }
             else
             {
                b= false;
             }
             return b;



    }
}
//LOGIC: For a rotated and sorted array: only 1 pair should exists with condition 
// a[n-1]>a[n], thus the ciunt should be=1 only!
                            