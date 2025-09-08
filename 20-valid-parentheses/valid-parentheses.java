class Solution {
    public boolean isValid(String s) 
    {
        int n= s.length();
        Stack<Character> st= new Stack<>();

        for(int i=0; i<n; i++)
        {
            //1. WHEN OPENING BRACKETS: JUST PUSH
            if(s.charAt(i)== '(' || s.charAt(i)=='{' || s.charAt(i)== '[')
            {
                st.push(s.charAt(i));
            }
        
        else{

        
        //2. WHEN CLOSING BRACKETS: CHECK IN STACK

         //edge case: if stack is empty
        if(st.isEmpty())
        {
            return false;          
        }
       
        if((s.charAt(i)== ')' && st.peek()!= '(') ||
        (s.charAt(i)== '}' && st.peek()!= '{') || 
        (s.charAt(i)== ']' && st.peek()!= '[') )
        {
           return false; 
        }

        st.pop(); //if matched, thn pop it out bitch
        }
        }

    //3. valid if nothing is unmatched
    return (st.isEmpty());
}
}