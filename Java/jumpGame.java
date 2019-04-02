/**
 * @author Linh
 * @function Given an array of non-negative integers, 
 *           each element in the array represents your maximum jump length at that position,
 *           determine if you are able to reach the last index.
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = 0;
        int flag = 0; // used to check if index changed
        int temp = 0;
        
        // the break of the loop is that for current element is that its value is more than or equals to length of array
        // minus its index + 1
        while (nums[index] < n - (index + 1)) {
            flag = index;
            temp = nums[index];
            
            // for one element in array, find the better next element
            for (int i = 1; i <= temp && i < n - index - 1; i++) {
                if (nums[i + index] >= temp - i) {
                    index += i; // find a better index
                    break;
                }
            }
            
            // if index never changed, return false
            if (index == flag) {
                return false;
            }
        }
        return true;
    }
}