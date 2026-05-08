class Solution {
    public boolean isPalindrome(String s) 
    {
        int n= s.length();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(Character.toLowerCase(ch));
            }
        }

            String a= sb.toString();
            int l=a.length();  
            int st=0, e=l-1;

            Boolean ans= true;
            while(st<e)
            {
                if(a.charAt(st) != a.charAt(e))
                {
                    ans= false;
                    break;
                }
                st++;
                e--;
            }
        return ans;
        
    }
}