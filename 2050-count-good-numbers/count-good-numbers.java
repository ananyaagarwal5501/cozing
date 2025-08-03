class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // positions for even digits
        long oddPositions = n / 2;        // positions for odd digits

        long power5 = modPow(5, evenPositions);  // 5 choices for even places
        long power4 = modPow(4, oddPositions);   // 4 choices for odd places

        return (int)((power5 * power4) % MOD);
    }

    private long modPow(long base, long exp) {
        if (exp == 0) return 1;

        long half = modPow(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }
}





/*class Solution {
    public int countGoodNumbers(long n) 
    {
        int result=1;

        

       
        while(n>=0)
        {

            /*if(n==0) //BASE CASE
        {
            return 1;
        }

        if(n>0)
        {
            countGoodNumbers(n-1);
        }   

        if(n %2==1) //odd 
        {
            result*= 4;
        }

         result *= 5 ;
        
    }

    return result;
}
}
*/