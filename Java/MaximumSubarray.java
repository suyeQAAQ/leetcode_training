/**
 * @author Linh
 * @class solution find the subarray which has the largest sum
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    public int maxSumBasedOnMid(int[] nums, int l, int mid, int r) {

        // calculate the left part max sum of subarrays ending with nums[mid]
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= l; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        // calculate the right part max sum of subarrays starting with nums[mid + 1]
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }

    public int maxSubArraySum(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        return maxOfThree(maxSubArraySum(nums, l, mid),
                maxSubArraySum(nums, mid + 1, r),
                maxSumBasedOnMid(nums, l, mid, r));
    }

    public int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
    