/*class Solution {
    public int singleNumber(int[] nums)
    {
        int c=0;
        int n= nums.length;
        for(int i=0; i<n; i++)
       {
        int h= nums[i];
        for(int j=i+1; j<n; j++)
        {
            if(nums[j]==h)
            {
                c++;
            }
        }

       }


    }
}*/
/*
class Solution {
    public int singleNumber(int[] nums)
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= nums.length;
        int traverse=0;
        int c=0;
      

        int i=0;
        while(i<n)
        {
            
            if(map.containsKey(nums[i]))
            {
                c++;
            }

            if( c==0)
            {
                return nums[i];

            }

            map.put(nums[i], traverse );
            i++;
            traverse++;

        }

     return 0;
    }
}*/

//OPTIMAL= USING XOR OPERATION!!!!
class Solution {
    public int singleNumber(int[] nums)
    {
        int result=0;
        for(int num: nums)
        {
            result ^= num;
        }
        return result;
    }
}
         