//by binary: in any 2 power: no of set bits==1 && the most left bit should be 1 &&  n& n-1 is 0.
/*class Solution {
    public boolean isPowerOfTwo(int n) 
    {
        //Testcases: -ve numbers and zero-> false
        int count=0;
        if(n<=0)
        {
            return false;
        }
        while(n!=0)
        {
            n=n&(n-1);
            count++;
        }
        return (count==1);
    }
}*/

//approach 2: For 2ki poer-> if n& n-1 is 0.

class Solution {
    public boolean isPowerOfTwo(int n) 
    {
       int count=0;
       if(n<=0)
       {
        return false;
       }
      if ((n&(n-1)) ==0)
      {
        return true;
      }
      return false;

    }
}



