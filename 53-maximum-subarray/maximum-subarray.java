class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // Include the current element, or start fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum if needed
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
