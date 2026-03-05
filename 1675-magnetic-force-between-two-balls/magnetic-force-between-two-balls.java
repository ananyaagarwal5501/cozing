class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int n= position.length;
        Arrays.sort(position);
        int low= 1;
        int high= position[n-1]- position[0];

        

        while(low<= high)
        {
            int mid= low + (high-low)/2;

            if(canplace(position, mid, m))
            {
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }
        }
        return high;        
    }

    boolean canplace(int[] arr, int dis, int totballs)
    {
        int lastpos= arr[0];
        int cntballs=1;

        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]- lastpos >= dis)
            {
                
                lastpos= arr[i];
                cntballs++;
            }
        }
           return (cntballs >= totballs);
        
    }
}