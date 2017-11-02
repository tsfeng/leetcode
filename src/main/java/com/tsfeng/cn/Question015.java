package com.tsfeng.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 15. 3Sum
 * @author tsfeng
 * @version 创建时间 2017/11/3 14:50
 */
public class Question015 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        Question015 question015 = new Question015();
        long t1 = System.nanoTime();
        List<List<Integer>> result = question015.threeSum(nums);
        long t2 = System.nanoTime();
        System.out.println(JSON.toJSONString(result) + "=====" + (t2 - t1));
        long t3 = System.nanoTime();
        result = question015.threeSum2(nums);
        long t4 = System.nanoTime();
        System.out.println(JSON.toJSONString(result) + "=====" + (t4 - t3));
    }

    /**
     *  Time limit Exceeded
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!result.contains(temp)) {
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip same result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1, sum = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip same result
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // skip same result
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
