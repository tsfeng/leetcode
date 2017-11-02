package com.tsfeng.cn;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * @author tsfeng
 * @version 创建时间 2017/11/3 16:34
 */
public class Question016 {

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
        int[] nums = {0, 0, 0};
//        int[] nums = {0, 2, 1, -3};
        int target = 1;
        Question016 question016 = new Question016();
        int result = question016.threeSumClosest(nums, target);
        System.out.println(result);
        result = question016.threeSumClosest2(nums, target);
        System.out.println(result);
    }


    public int threeSumClosest(int[] nums, int target) {
        int result = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1, sum = target - nums[i];
            if (i == 0) {
                result = nums[i] + nums[j] + nums[k];
            } else {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result - target)) {
                    result = nums[i] + nums[j] + nums[k];
                }
            }
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    result = target;
                    return result;
                } else if (nums[j] + nums[k] < sum) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result - target)) {
                        result = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                } else {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result - target)) {
                        result = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }

            }
        }
        return result;
    }


    public int threeSumClosest2(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
