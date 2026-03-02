class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        // Step 1: count trailing zeros
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        // Step 2: greedy placement
        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;

            // find suitable row
            while (j < n && zeros[j] < needed) {
                j++;
            }

            if (j == n) return -1;

            // bring row up via adjacent swaps
            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }
}