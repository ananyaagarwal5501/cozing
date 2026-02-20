
//OPTIMAL: Boyer-Moore Voting Algorithm 
class Solution { 
    public int majorityElement(int[] nums) 
    {
        //BY MOORE'S VOTING ALGO
        int el=nums[0];
        int ct=1;
        for(int i=1; i< nums.length-1; i++)
        {
            if(el != nums[i])
            {
                ct--;
                if(ct == 0)
                {
                    el= nums[i+1];
                }
            }
            else
            {
                ct++;
            }
        }
          return el;
    }
  
}

       









//BRUTE: HASHMAP     done
/*class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        return -1; // won't happen
    }
}*/

