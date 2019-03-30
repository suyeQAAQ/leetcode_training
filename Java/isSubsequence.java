/**
 * @author Linh
 * @class solution check if string t is the substring of string s
 */
class Solution {

    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0)  
            return true;

        int IndexS = 0;
        int IndexT = 0;
        
        while(IndexT < t.length()) {

            if (t.charAt(IndexT) == s.charAt(IndexS)) {
                IndexS++;

            // when IndexS equals the len of fomer string, break the loop
            if (IndexS == s.length())  
                return true;

            }
            // tell first, and then IndexT++
            IndexT++;
        }

        return false;
        
    }
}