class Solution {
    public int maxArea(int[] height) 
    {
        int l= height.length;
        int s=0;
        int e= l-1;
        int max= 0;

        while(s<e)
        {
            int v=0;
            int h=0;
            if(height[s]<height[e]) 
            {
            h= Math.min(height[s] , height[e]);
            v= h*(e-s);
            max= Math.max(v, max);
            s++;
            }

            else if(height[s]>height[e])
            {
            h= Math.min(height[s] , height[e]);
            v= h*(e-s);
            max= Math.max(v, max);
            e--;
            }

            else
            {
            h= Math.min(height[s] , height[e]);
            v= h*(e-s);
            max= Math.max(v, max);
                s++;
            }
        }
        return max;
    }
}