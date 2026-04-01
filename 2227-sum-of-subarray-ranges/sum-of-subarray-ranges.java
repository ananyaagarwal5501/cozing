
class Solution {
    public long subArrayRanges(int[] nums) 
    {
        return getMax(nums) - getMin(nums);
    }

    private long getMin(int[] nums)
    {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;

        for(int i = 0; i <= n; i++)
        {
            while(!st.isEmpty() && (i == n || nums[st.peek()] > nums[i]))
            {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                sum += count * nums[mid];
            }
            st.push(i);
        }

        return sum;
    }

    private long getMax(int[] nums)
    {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;

        for(int i = 0; i <= n; i++)
        {
            while(!st.isEmpty() && (i == n || nums[st.peek()] < nums[i]))
            {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                sum += count * nums[mid];
            }
            st.push(i);
        }

        return sum;
    }
}