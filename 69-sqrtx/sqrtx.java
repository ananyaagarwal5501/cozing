/*class Solution {
    public int mySqrt(int x) 
    {
        int s= 0;
        for(int i=1; i<=x; i++)
        {
            if(i*i<=x)
            {
                s=i;
            }
        }

        int p= Math.floor(s);
        return p;
    }
}*/
//tooo much complexity, goes O(n*n) , thus to reduce the space, we will do by binary serach: optimisation

//Obv.1: the square root of the no. would be definately <=half of that no., thus apply BS

class Solution {
    public int mySqrt(int x) 
    {
        //edge case
        if(x<2)
        {
            return x;
        }

        int ans=0;
        int s=1;
        int e= x/2;

        while(s<=e)
        {
        int m= s+ (e-s)/2;

        long sqrt= (long)m*m;

        if(sqrt==x)
        {
            return m;
        }

        else if(sqrt>x)
        {
            e=m-1;
        }
        else
        {
            s=m+1;
            ans= m; //prints the last valid result

        }
        }
return ans;
    }
}

