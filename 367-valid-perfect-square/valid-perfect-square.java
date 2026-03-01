class Solution {
    public boolean isPerfectSquare(int num) 
    {
        int l=1;
        int e= num;

        if(num==1) return true;
        //if(num <= 3) return false;
        while(l<=e)
        {
            int mid= l+ (e-l)/2;
            if((long) mid*mid == num)
            {
                return true;
            }
            else if((long) mid*mid < num)
            {
                l= mid+1;
            }
            else
            {
                e= mid-1;
            }
        }
        return false;
    }
}