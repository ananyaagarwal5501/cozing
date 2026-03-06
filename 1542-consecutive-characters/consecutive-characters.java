class Solution {
    public int maxPower(String s) 
    {
        int n= s.length();
        int count=1;
        char c;
        char c1;
        int max=1;
        for(int i=0; i<n-1; i++)
        {
            c= s.charAt(i);
            c1= s.charAt(i+1);

            if(c != c1)
            {
                count=1;
            }
            else
            {
                count+= 1;

                max= Math.max(max, count);
            }
        }
        return max;
        
    }
}