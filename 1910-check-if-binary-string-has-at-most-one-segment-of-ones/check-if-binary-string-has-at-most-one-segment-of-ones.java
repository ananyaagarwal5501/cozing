class Solution {
    public boolean checkOnesSegment(String s) 
    {
        int n= s.length();
        if(n<=2) return true;
        
        int c=0;
        char ch;
        char ch1;
        for(int i=0; i<n-1; i++)
        {
            ch= s.charAt(i);
            ch1= s.charAt(i+1);

            if(ch =='0' && ch1 == '1')
            {
                return false;     
            }
        }
         return true;
        
    }
}