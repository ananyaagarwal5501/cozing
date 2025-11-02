class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        // 1️⃣ Clean extra spaces
        int n = cleanSpaces(chars);

        // 2️⃣ Reverse the entire valid portion
        reverse(chars, 0, n - 1);

        // 3️⃣ Reverse each word individually
        reverseEachWord(chars, n);

        return new String(chars, 0, n);
    }

    // Function to remove extra spaces
    private int cleanSpaces(char[] a) {
        int i = 0, j = 0;
        int n = a.length;

        // Skip leading spaces
        while (i < n && a[i] == ' ') i++;

        while (i < n) {
            // Copy non-space characters
            if (a[i] != ' ') a[j++] = a[i];
            else if (j > 0 && a[j - 1] != ' ') a[j++] = ' ';
            i++;
        }

        // Remove trailing space if present
        if (j > 0 && a[j - 1] == ' ') j--;

        return j; // new valid length
    }

    // Function to reverse characters in a range
    private void reverse(char[] a, int left, int right) {
        while (left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    // Function to reverse each word individually
    private void reverseEachWord(char[] a, int n) {
        int start = 0, end = 0;
        while (start < n) {
            // Move end to end of word
            while (end < n && a[end] != ' ') end++;

            // Reverse the word
            reverse(a, start, end - 1);

            // Move to next word
            end++;
            start = end;
        }
    }
}
