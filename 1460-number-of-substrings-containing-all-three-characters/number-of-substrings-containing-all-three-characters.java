class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // a,b,c
        int res = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']++;

            // shrink from left while substring still contains all three
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(l) - 'a']--;
                l++;
            }

            // all substrings ending at r and starting before l are valid
            res += l;
        }

        return res;
    }
}
