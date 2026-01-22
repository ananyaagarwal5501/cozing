class Solution {
    public int longestConsecutive(int[] nums) 
    {
        //just need to figure out the start:[whose before doesnt exist]
        //for 0(n), cant use while loop, thus set to check for duplicates and presence
        //

        int n= nums.length;
        int anslen=0;

        Set<Integer> set= new HashSet<>();
        for(int i=0; i<n; i++)
        {
            set.add(nums[i]);
        }


        for(int a: set)
        {
            if(!set.contains(a-1))
            {
                int current= a;
                int length= 1;
            

            while(set.contains(current + 1))
            {
                current= current + 1;
                length += 1;
            }
            anslen= Math.max(anslen, length);
        }
        }
        return anslen;
      
    }
}