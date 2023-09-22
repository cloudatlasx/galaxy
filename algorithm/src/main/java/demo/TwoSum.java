package demo;

import java.util.HashSet;

/**
 * @Description: 找出目标数的两数之和
 * @Author liuming
 * @Date 2023/8/28
 * @Version V1.0
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,7};
        int target = 13;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " + " + result[1] + " = " + target);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                result[0] = target - nums[i];
                result[1] = nums[i];
                return result;
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }
}
