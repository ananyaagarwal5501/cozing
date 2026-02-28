class Solution {
    public int peakIndexInMountainArray(int[] arr) 
    {
        int n= arr.length;

        if(n==1) return 0;
        //edge cases for the corner elements
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int l=1; 
        int e= n-2;

        while(l<=e)
        {
            int m= l+(e-l)/2;

            if(arr[m] > arr[m-1] && arr[m]> arr[m+1])
            {
                return m;
            }

            else if(arr[m] > arr[m-1] && arr[m] <  arr[m+1]) //m on increasing slope 
            {
                l= m+1;
            }

            else //(arr[m] < arr[m-1] && arr[m] >  arr[m+1]) //m on decreasing slope 
            {
                e= m-1;
            }
        }
        return -1;
        
    }
}