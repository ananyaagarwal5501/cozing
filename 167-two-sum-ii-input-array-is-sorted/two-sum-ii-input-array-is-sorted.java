/*class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        // already sorted in non-decreasing order-> Binary Search!!
        int n= numbers.length;

        int[] a= new int[2];
        //1 <= index1...st
        //int st=0;
        int e= n-1; //st<e tak only

        for(int st=0; st<n-1; st++)
        {
            
        while(st<e)
        {
            if(numbers[st]+ numbers[e] == target)
            {
                a[0]=st+1;
                a[1]= e+1;
            }
            e--;

        }
        }

        return a; 
    }
}
*/

//LET'S DO NAHI WALA CASE THEN WHOLE

/*class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        // already sorted in non-decreasing order-> Binary Search!!
        int n= numbers.length;

        int[] a= new int[2];
        //1 <= index1...st
        //int st=0;
        int e= n-1; //st<e tak only

        for(int st=0; st<n/2; st++)
        {
            
        while(st<e)
        {
            if(numbers[st]+ numbers[e] != target)
            {
                e--;
            }

            a[0]= st+1;
            a[1]= e+1;

        }
        }

        return a;
    }
}*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // Start pointer
        int right = numbers.length - 1; // End pointer

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++; // Need a bigger number
            } else {
                right--; // Need a smaller number
            }
        }

        // Default return, though problem says there will always be one solution
        return new int[] {-1, -1};
    }
}