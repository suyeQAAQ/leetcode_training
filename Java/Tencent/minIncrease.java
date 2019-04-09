/**
 * @author Linh
 * @desciption Given an array, it allows you to operate one element (increase by one) every time, find the minimum operate
 * time to make the array without repeat elements.
 * @example Input: 1, 2, 3, 3, 4   Output: 2
 */


import java.util.Arrays;

public class solution {
    public static int minIncrease(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += (nums[i - 1] - nums[i]) + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        main m = new main();
        int[] t = {1, 1, 1, 1, 1};
        System.out.println(minIncrease(t));
    }
}
