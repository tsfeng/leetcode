package com.tsfeng.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tsfeng
 * @version 创建时间 2017/11/4 10:29
 */
public class Question018 {

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int target = 0;
        int target = -1;
        Question018 question018 = new Question018();
        long t1 = System.nanoTime();
        List<List<Integer>> result = question018.fourSum(nums, target);
        long t2 = System.nanoTime();
        System.out.println(JSON.toJSONString(result) + "=====" + (t2 - t1));
    }

    /**
     * 参考 3Sum 思路
     * 第一次：wrong anwser {0,0,0,0} 0； j>0修改为j>1
     * 第一次：wrong anwser {-1,0,1,2,-1,-4} -1;Output:[[-4,0,1,2]];Expected:[[-4,0,1,2],[-1,-1,0,1]]; j>1修改为j>i+1
     * 第三次通过，问题的关键在去重时，考虑的不够严谨
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int n = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while (k < n) {
                    if (nums[k] + nums[n] == sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[n]));
                        k++;
                        n--;
                        while (k < n && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (nums[k] + nums[n] < sum) {
                        k++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return result;
    }
}
