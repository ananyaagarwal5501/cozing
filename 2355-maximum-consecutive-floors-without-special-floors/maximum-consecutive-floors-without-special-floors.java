class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {

        Arrays.sort(special);

        int max = 0;

        // before first special
        max = special[0] - bottom;

        // between specials
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }

        // after last special
        max = Math.max(max, top - special[special.length - 1]);

        return max;
    }
}
