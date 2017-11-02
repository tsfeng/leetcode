package com.tsfeng.cn;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * @author tsfeng
 * @version 创建时间 2017/11/3 10:15
 */
public class Question001 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Question001 question001 = new Question001();
        int[] result = question001.twoSum(nums, target);
        System.out.println(JSON.toJSONString(result));
        System.out.println("=========================");
        result = question001.twoSum2(nums, target);
        System.out.println(JSON.toJSONString(result));
        System.out.println("=========================");
        result = question001.twoSum3(nums, target);
        System.out.println(JSON.toJSONString(result));
    }


    /**
     * Time complexity :  O(n^2)
     * Space complexity : O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    /**
     * Time complexity :  O(n)
     * Space complexity : O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Time complexity :  O(n)
     * Space complexity : O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
