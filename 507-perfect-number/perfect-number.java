class Solution {
    public boolean checkPerfectNumber(int num) 
    {
        int s=1;
        int n=0;

        for(int i=2; i*i<=num; i++)
        {
            if(num%i==0)
            {
                n= num/i;
                s=s+i+n;
            }

        }

        if(num==1)
        {
            return false;
        }

        
        if(num==s)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
        /*if(s==num)
        {
            return true;
        }
        else{
            return false;
        }
        
    }
}*/