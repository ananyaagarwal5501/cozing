// BRUTE FORCE: SET APPROACH 
// TWO POINTER APPROACH- compare and swap
class Solution {
    public int removeDuplicates(int[] nums) 
    {
         int n= nums.length;

        int i=0;
       
        int j=i+1;

        while(j<=n-1)
        {
            if(nums[j]== nums[i])
            {
                j++;
                continue;
            }

            swap(nums,j, i+1);
            i= i+1;
            j++;
        }
        

        return i+1;
    }

    static void swap(int arr[], int f, int s)
    {
        int t=0;
        t=arr[s];
        arr[s]=arr[f];
        arr[f]=t;
    }
}



/*class Solution {
    public int removeDuplicates(int[] nums) 
    {
         ArrayList<Integer> a = new ArrayList<>();
         a.add(nums[0]);
         int n= nums.length;

         int c=0;
         for(int i=0; i<n; i++)
         {
            c= nums[i];

            int j= i+1;
            while(j<n)
            {
                if(nums[j]==nums[i])
                {
                    continue;
                }
                else{
                    a.add(nums[j]);
                }
                j++;
            }
         }

         int k= a.size();
         return k;
        

        
    }
}
*/