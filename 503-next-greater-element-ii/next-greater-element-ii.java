class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        int n= nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        int[] res= new int[n];
        Stack<Integer> st= new Stack<>();

        for(int i= 2*n-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i%n])
            {
                st.pop();
            }
            if (i <n)
            {
            res[i] = st.empty() ? -1 : st.peek();
            }

            st.push(nums[i%n]);
        }
     return res;   
    } //0(4n)
}