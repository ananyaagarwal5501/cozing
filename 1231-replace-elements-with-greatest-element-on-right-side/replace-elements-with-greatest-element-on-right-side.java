class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];
        int max=arr[n-1];
        res[n-1]= -1;
        for(int i=n-2; i>=0; i--)
        {
             max= Math.max(max, arr[i+1]);
             res[i]= max;
        }
            /*while(!st.isEmpty() && st.peek() <= max)
            {
                st.pop();
            }
            if(st.isEmpty()) res[i] = -1;
            else
            {
                res[i] = st.peek();
            }
            st.push(arr[i]);
           
        }
        */
        return res;
    }
}