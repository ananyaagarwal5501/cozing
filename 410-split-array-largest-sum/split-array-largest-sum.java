class Solution {
    public int splitArray(int[] nums, int k) 
    {
        int n= nums.length;
        int low= 0;
        int high=0;
        int sum=0;
        for(int i=0; i<n; i++)
        {
            low= Math.max(nums[i], low);
            sum= sum+ nums[i];
        }
        high= sum;

        while(low<= high)
        {
            int mid= low+ (high- low)/2;

            if(cansep(nums, mid, k))
            {
                high= mid-1;
            }
            else
            {
                low= mid+1;
            }
        }
            return low;
        }

        boolean cansep(int[] arr, int sum, int k)
        {
            int nsubs=1;
            int crtsum=0;
            int max=0;

            for(int i=0; i<arr.length; i++)
            {
                //nsum= nsum+arr[i];
               // max= Math.max(nsum, max);
                if(crtsum + arr[i] > sum) //max sum needed
                {
                    nsubs++;
                    crtsum= arr[i]; //stores the 1st ele of the 2nd subarray
                }
                else
                {
                    crtsum = crtsum + arr[i] ;
                }
                     
                
            }
        return (nsubs <= k );
        }
}