class Solution {
    public long[] sumOfThree(long num) 
    {
        //range has to be less than num/2 
        //3 consecutive integres only

        //need to find the start integer, n
        //then, n+1 + n+2 + n = num 
        //thus, num= 3(n+1)
        //thus, num needs to be div by 3
        
        long[] ans= new long[3];

        if(num % 3 != 0)  return new long[0];

        long n= (long)((num / 3)-1);
        
        ans[0]= n;
        ans[1]= n+1;
        ans[2]= n+2;

        return ans;

    }
}