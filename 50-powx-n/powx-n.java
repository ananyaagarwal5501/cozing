class Solution {
    public double myPow(double x, int n) 
    {
       long exp= n; //converting the power to long to increase its rnge.

       if(exp<0)
       {
        exp= -exp; //negative power
        x=1/x; // 2^-3= 1/2^3
       }

       double result= 1;


       while(exp>0)
       {
        if(exp%2==1)//odd power
        {
            result*= x;
        }
        x*=x; //square of base
        exp/=2;// half of power
       }
       return result;
    }
}






/*class Solution {
    public double myPow(double x, int n) 
    {
        double g= 0.0;
        if(n>=0)
        {
        if(n==1)
        {
            return x;
            
        }

        
         g= x*myPow(x, n-1);
        
    }

    else
    {
        if(n== -1)
        {
            return 1/x;
        }

        g= 1/x * myPow(x, n+1);
    }
    return g;
}
}
*/