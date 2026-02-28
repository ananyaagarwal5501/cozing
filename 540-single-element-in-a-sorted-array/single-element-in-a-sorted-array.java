class Solution {
    public int singleNonDuplicate(int[] nums) 
    {
        int n= nums.length; //always odd
        //TOO MANY edge cases for the corner elements if checking for pairs, thus, handling them seperately. Thus; l=1 and e= n-2
       
        if(n== 1) return nums[0]; //edge case
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int l=1;
        int e= n-2;
        while(l<=e)
        {
            int m= l+ (e-l)/2;
            if(nums[m] != nums[m-1] && nums[m] != nums[m+1]) //single element
            {
                return nums[m];    
            }
            
            //eliminatinon part:
            //if(evn,od)= The Left Half-> ele on right half, x remove left 
            //if(od, evn)= The Right Half-> ele on left half, x remove right

            //We are in left
            if((m %2 != 0 && nums[m] == nums[m-1]) || (m%2 == 0 && nums[m] == nums[m+1])) // (even, od) Left Half-> remove it
            {
                l= m+1; //eliminates the left half
            }

            else
            {
                e= m-1;
            }
        }
            return -1; //dummy statement just here
        }
    }


        
   