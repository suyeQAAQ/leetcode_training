//Leetcode 35 search rotated array

// first version
class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while(begin <= end) {
            int mid = (begin + end) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            else if(target < nums[mid]){
                if(nums[begin] < nums[mid]){
                if(nums[begin] > target){
                    begin = mid + 1;
                } else if(nums[begin] <= target){
                    end = mid - 1;   
                }
                }
                else if(nums[begin] > nums[mid])                {
                    end = mid - 1;
                }else if(nums[begin] == nums[mid]){
                    begin = mid + 1;
                }
            } else if(target > nums[mid]) {
                if(nums[begin] > nums[mid]) {
                    if(nums[begin] > target) {
                        begin = mid + 1;
                    } else if(nums[begin] <= target) {
                        end = mid - 1;
                    }
                } else if(nums[begin] < nums[mid]){
                    begin = mid + 1;
                } else if(nums[begin] == nums[mid]){
                    begin = mid + 1;
                }
            }
        }
        return -1;
    }
}


// final version

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else right = mid -1;
            }
            else {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}