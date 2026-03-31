class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n= heights.length;
        int maxa=0;
        int nse=0;
        int pse=0;
        int ele=0; 

        Stack<Integer> st= new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && heights[i] < heights[st.peek()])
            {
                ele= st.pop();
                nse= i;
                pse= st.isEmpty()? -1 : st.peek();
                maxa= Math.max(maxa, heights[ele]*(nse- pse -1));
            }
            st.push(i);
        }

        while(!st.isEmpty())
        {
            ele= st.pop();
            nse= n;
            pse= st.isEmpty()? -1 : st.peek();
            maxa= Math.max(maxa, heights[ele]*(nse- pse -1));
        }

        return maxa;
        
    }
}