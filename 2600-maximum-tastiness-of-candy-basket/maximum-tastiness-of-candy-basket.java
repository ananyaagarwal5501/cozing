class Solution {
    public int maximumTastiness(int[] price, int k) 
    {
        Arrays.sort(price);
        int l=1;
        int h=0;
        for(int num: price)
        {
        h= Math.max(h, num);
        }

        while(l<=h)
        {
            int mid= l+ (h-l)/2;

            if(canput(mid, price, k))
            {
                l= mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return h;
    }

    boolean canput(int diff, int[] price, int k)
    {
        int c=1;
        int last= price[0];
        for(int i=0; i<price.length; i++)
        {
            if(price[i]- last >= diff)
            {
                c++;
                last= price[i];
            }
            if(c>= k) return true;
        }
        return false;
    }
}