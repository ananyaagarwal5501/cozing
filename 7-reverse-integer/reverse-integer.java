class Solution {
    public int reverse(int x) {
        //int ori=x;

int rev=0;
        while(x!=0 )
        {
            int d= x%10;

            //for point2
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && d>7 )
            {
                return 0;
            }
             if(rev< Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && d<-8 )
        {
          return 0;
        }
            rev= rev*10+d;
            x=x/10;
        }

        
       // return (x < 0) ? (-rev) : rev; 
        //return (x>0)? rev : (-rev);
        //return (x<0)? (-rev) : rev;
        return rev;
    
}
}

//important points: 1. int ki max value: Integer.MAXIMUM_VALUE 

// 2. Java me, overflow chla jata h jab, toh woh error throw nahi karta, balki ek galat number bna ke output dta h, so, reverse number build karne se pehle, i need to throw the overflow checker of max and min range value of reversed number.