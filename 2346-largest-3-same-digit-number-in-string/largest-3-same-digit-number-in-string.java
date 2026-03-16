class Solution {
    public String largestGoodInteger(String num) 
    {
        int n= num.length();
        String best= "";
        for(int i=0; i<n-2; i++)
        {
            char ch= num.charAt(i);
            char ch1= num.charAt(i+1);
            char ch2= num.charAt(i+2);

            if( ch == ch1 && ch1 == ch2 && ch2 == ch)
            {
                String candidate= num.substring(i, i+3);
                if(best.compareTo(candidate) < 0)
                {
                    best = candidate;
                }              
            }
        }
        return best;
    }
}