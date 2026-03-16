class Solution {
    public String removeOuterParentheses(String s) 
    {
        int depth=0;
        int l= s.length();
        String res="";

        for(int i=0; i<l; i++)
        {
            char ch= s.charAt(i);
            if(ch == '(')
            {
                if(depth > 0)
                    res= res + ch;

                depth++;
            }

            else
            {
                depth--;

                if(depth > 0 )
                res= res+ ch;     
            }
        }
        return res;
    }
}