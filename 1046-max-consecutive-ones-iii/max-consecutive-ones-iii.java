/*class Solution {
    public int longestOnes(int[] nums, int k) 
    
    {
        int n= nums.length;
        int l=0; 
        int r=0;
        int tempk =k;
        int len=0;
        int maxl= 0;

        while(r<n)
        {
            if(nums[r]==0 && (nums[r+1]==1 || nums[k+r]==1))
            {
                if(k>0)//invert 1 to 0, until k becomes 0
                {
                len =r-l+1;
                maxl= Math.max(len, maxl);
                k--;
                }

                else 
                {
                l = r+1;
                k= tempk; // restorng the k. as we move the left pointer
                }

                //yahan ek case ki when there is a 1 after the 0, then too we should flip it am=nd also,,, right after the k=0 once, immediately, if the next is 1 OR the after k elements is 1, then start flipping.
            }

            if(nums[r]== 1)
            {
                len = r-l+1;
                maxl= Math.max(len, maxl);
            }
            r++;
        }
        

        return maxl;
        
    }
}*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (r < nums.length) {
            // expand window
            if (nums[r] == 0) {
                zeroCount++;
            }

            // shrink window until it’s valid again
            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            // update answer
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
