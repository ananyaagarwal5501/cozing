class Solution {
    public int binaryGap(int n) 
    {
        int dis=0;
        StringBuilder st= new StringBuilder();
        while(n>0)
        {
            st.append(n%2);
            n= n/2;
        }
        st.reverse(); // as in append, ulta binary string os stored.
        int low= 0; //pehla one 
        int h= 0;
        int l= st.length();
        for(int i=1; i<l; i++)
        {
            char c= st.charAt(i); //1
            if(c == '0') continue;
            if(c == '1')
            {
                h=i;
                int d= h-low;
                dis= Math.max(d, dis);
                low= h;

            }

        }
        return dis;
    }
}