class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // Step 1: take first k cards
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        
        int maxScore = leftSum;
        int rightSum = 0;

        // Step 2: gradually replace from right
        for (int i = 0; i < k; i++) {
            rightSum += cardPoints[n - 1 - i];   // add one card from right
            leftSum -= cardPoints[k - 1 - i];    // remove one card from left
            maxScore = Math.max(maxScore, leftSum + rightSum);
        }
        
        return maxScore;
    }
}
