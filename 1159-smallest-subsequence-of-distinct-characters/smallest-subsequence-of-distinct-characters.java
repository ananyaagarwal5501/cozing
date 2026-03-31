class Solution {
    public String smallestSubsequence(String s) 
    {
         int n= s.length();

        int[] freq= new int[26];
        for(char ch: s.toCharArray())
        {
            freq[ch- 'a']++;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> st= new Stack<>();
        for(char ch: s.toCharArray())
        {
            freq[ch-'a']--;
            if(visited[ch-'a']) continue;
            
            while(!st.isEmpty() && freq[st.peek()-'a'] > 0 && ch < st.peek())
            {
                
                visited[st.pop()-'a']= false;
            }
            st.push(ch);
            visited[ch-'a']= true; // going in the stack
        }

        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty())
        {
        sb.append(st.pop());
        }

        sb= sb.reverse();        

        return sb.toString();
        
    }
}