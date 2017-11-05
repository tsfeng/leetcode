package com.tsfeng.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * 罗马数转化成数字问题，我们需要对于罗马数字很熟悉才能完成转换
 * @author tsfeng
 * @version 创建时间 2017/11/5 10:13
 */
public class Question013 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        int result = 0;
        if (s.contains("IV")) {
            result -= 2;
        }
        if (s.contains("IX")) {
            result -= 2;
        }
        if (s.contains("XL")) {
            result -= 20;
        }
        if (s.contains("XC")) {
            result -= 20;
        }
        if (s.contains("CD")) {
            result -= 200;
        }
        if (s.contains("CM")) {
            result -= 200;
        }

        char[] c = s.toCharArray();
        int count = 0;
        for (; count < s.length(); count++) {
            if (c[count] == 'M') {
                result += 1000;
            }
            if (c[count] == 'D') {
                result += 500;
            }
            if (c[count] == 'C') {
                result += 100;
            }
            if (c[count] == 'L') {
                result += 50;
            }
            if (c[count] == 'X') {
                result += 10;
            }
            if (c[count] == 'V') {
                result += 5;
            }
            if (c[count] == 'I') {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question013 question013 = new Question013();
//        String s = "DCXXI";
        String s = "MCCXXXIV";
        long t1 = System.nanoTime();
        int result = question013.romanToInt(s);
        long t2 = System.nanoTime();
        System.out.println(result + "=====" + (t2 - t1));
        long t3 = System.nanoTime();
        result = question013.romanToInt2(s);
        long t4 = System.nanoTime();
        System.out.println(result + "=====" + (t4 - t3));
    }
}
