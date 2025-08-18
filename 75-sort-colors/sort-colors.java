//brute: bubble sort simple, done OR DO By Merge Sort
//TC= 0(N^2): NOT GOOD 
/*class Solution { 
    public void sortColors(int[] nums) 
    {
        int n= nums.length;
        for(int i=0; i<n; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (nums[j] > nums[j + 1]) {
                  
                    // swap temp and arr[i]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
        }
        }
        
    }
}
*/
//Better: count all 0, 1 and 2s, then run loop to print all thses
//TC= 0(N)
class Solution { 
    public void sortColors(int[] nums) 
    {
        int n= nums.length;
        int c=0;
        int v=0;
        int w=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i]==0)
            {
                c++;

            }
            else if(nums[i]==1)
            {
                v++;
            }
            else
            {
                w++;
            }

        }

        //printing the array: though 3 loops but TC is 0(N) only
        for(int i=0; i<c; i++)
        {
            nums[i]=0;
        }
        for(int i=c; i<v+c; i++)
        {
            nums[i]=1;
        }
        for(int i=v+c; i<n; i++)
        {
            nums[i]=2;
        }
    }
}