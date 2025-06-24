
class Solution {
    public int subtractProductAndSum(int n) {
        int d;
        int s=0;
        int m=1;
        while(n>0)
        {
            d=n%10;
            s= s+d;
            m=m*d;
            n=n/10;
        }
        return m-s;
    }
}