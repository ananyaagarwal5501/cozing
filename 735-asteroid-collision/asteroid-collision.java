class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        int[] as= asteroids;
        int n= asteroids.length;
       Stack<Integer> st= new Stack<>();

       for(int ass: as)
       {
         boolean des= false;
         while(!st.isEmpty() && st.peek() > 0 && ass<0)
         {
            if(Math.abs(st.peek()) < Math.abs(ass))
            {
                st.pop();
                continue;
            }
            else if(Math.abs(st.peek())== Math.abs(ass))
            {
                st.pop();
            }
             des= true;
                break;
         }
         if(!des)
         {
            st.push(ass);
         }
       }

       int[] res= new int[st.size()];
       for(int i= st.size()-1; i>=0; i--)
       {
         res[i]= st.pop();
       }
       
return res;      
       }
      
}