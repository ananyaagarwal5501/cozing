class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1); // empty prefix sum
        int sum = 0, result = 0;

        for (int num : nums) {
            sum += num;

            // check how many times (sum - goal) has occurred
            result += count.getOrDefault(sum - goal, 0);

            // update the prefix sum count
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
