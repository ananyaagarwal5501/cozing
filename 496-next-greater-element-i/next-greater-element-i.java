//brute
/*class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n1= nums1.length;
        int n2= nums2.length;
        int index=0;
        int locEle=0;

        int[] ar= new int[n1];

        int i=0;
        while( i<n1)
        {
            //searching for the ith element of nums1 in nums2
            //Abhi Linear Searching
            for(int j=0; j<=n2-1; j++)
            {
                if(nums1[i]== nums2[j])
                {
                    if( j== n2-1)
                    {
                        locEle= -1;
                    }

                    /*if (j!= n2-1) 
                    {
                        while(j<= n)
                       locEle = nums2[j+1];
                    }*/
                    
                    /*
                    else  
                    {   
                        while(j< n2)
                        {
                            if(nums2[j]> nums1[i])
                            {
                                locEle= nums2[j];
                            }
                            else
                            {
                                locEle= -1;
                            }
                            j++;

                        }

                    }
                  
                }
            }

            ar[index]= locEle;
            index++;

            i++;
        }

        return ar;
         
        
    }
}*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1];  // answer array

        int index = 0;

        // For each element in nums1
        for (int i = 0; i < n1; i++) {
            int locEle = -1; // default answer = -1

            // Find nums1[i] inside nums2
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    // Now search to the right of nums2[j]
                    for (int k = j + 1; k < n2; k++) {
                        if (nums2[k] > nums1[i]) {
                            locEle = nums2[k]; // found next greater
                            break;             // stop here
                        }
                    }
                    break; // no need to keep searching in nums2
                }
            }

            result[index++] = locEle; // store answer for nums1[i]
        }

        return result;
    }
}
