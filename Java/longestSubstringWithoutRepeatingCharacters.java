
/*
*@author Linh
*@hints: 1. care about empty string
*        2. care about the end of the second loop
*        3. be careful it does not require subsequence
*
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we could play a trick by using ASC code of alphanumerics
        int[] m = new int[256];

        // simply fill the array with -1, -1 means the element does not appear before
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
}