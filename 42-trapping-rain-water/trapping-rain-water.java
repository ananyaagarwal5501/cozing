class Solution {
    public int trap(int[] height) 
    {
        int n= height.length;
        int l=0;
        int r= n-1;
        int lmax=0;
        int rmax=0;
        int t=0;

        while(l<=r)
        {
            if(height[l] < height[r])
            {
                if(lmax < height[l])
                {
                    lmax= height[l];
                }
                else
                {
                    t += lmax- height[l];
                }
                l++;
            }
            else
            {
                if(rmax < height[r])
                {
                    rmax= height[r];
                }
                else
                {
                    t += rmax- height[r];
                }
                r--;
            }
        } 
        return t;
    }
}