class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        int n= nums.length;
       
        List<List<Integer>> power= new ArrayList<>();

        for(int num=0; num< Math.pow(2,n); num++)
        {
             List<Integer> list= new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                if((num & (1<<i))!=0) //means bit is not set (means non-zero)
                {
                    list.add(nums[i]);
                }
            }
              power.add(list);
        }
        return power;
    }
}