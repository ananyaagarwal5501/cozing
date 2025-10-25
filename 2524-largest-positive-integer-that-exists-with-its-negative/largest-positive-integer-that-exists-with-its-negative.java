//USE OF HASH-SET, WHEN TO CHECK FOR DUPLICATES OR PRESENCE OF AN ITEM
class Solution {
    public int findMaxK(int[] nums) 
    {
        HashSet<Integer> set= new HashSet<>();

        int n= nums.length;
        int max=-1;

        for(int i=0; i<n; i++)//hashset feeding
        {
            set.add(nums[i]);
        }

        //CHECKING 
        for(int i=0; i<n; i++)
        {
            if (set.contains(-nums[i]))
            {
                max= Math.max(max, nums[i]);
            }
        }
        return max;
        
    }
}