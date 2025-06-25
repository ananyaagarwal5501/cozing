class Solution {
    public boolean isPalindrome(String s)
     {
        int n= s.length();
        s= s.toLowerCase();
        StringBuilder sb= new StringBuilder(s); 
        

        StringBuilder sb2= new StringBuilder();

        // lowercase //removing all non-alphanumeric //same forward and backward

        for(int i=0; i<n; i++)
        {
            char ch=sb.charAt(i);
            if((sb.charAt(i)>='a' && sb.charAt(i)<='z') ||(sb.charAt(i)>='0' && sb.charAt(i)<='9') )
            {
                sb2.append(ch);
            }
        }
        StringBuilder sb3= new StringBuilder(sb2).reverse(); //correct way to store the reversed stringbuilder
        //sb3= sb2.reverse();///bcccccc, here i am changing the original value of sb2 also!!! tabhi wrong


        //NO NEED OF SUCH BIF STATEMENTS, INSTEAD WRITE..line
        /*if((sb2.toString()).equals(sb3.toString()))
        {
            return true;
        }

        else
       {
        return false;
       }*/

       return (sb2.toString()).equals(sb3.toString());

        



        /*int z=sb2.length();
        int st=0;
        int e= z-1;
        while(st<=e)
        {
            if(sb2.charAt(st)==sb2.charAt(e))
            {
                st++;
                e--;
            }
        }
        boolean h=true;
        if(st==e)
        {
            h= true;

        }
        else 
        {
            h=false;
        }
        */
        
        //return h;
        


        
    }
}