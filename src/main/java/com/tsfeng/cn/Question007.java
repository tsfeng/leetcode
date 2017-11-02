package com.tsfeng.cn;

/**
 * 7. Reverse Integer
 * @author tsfeng
 * @version 创建时间 2017/11/3 11:45
 */
public class Question007 {
    public static void main(String[] args) {
        Question007 question007 = new Question007();
        int x = -123;
        int reverse = question007.reverse(x);
        System.out.println("" + reverse);
    }


    /**
     * Time complexity :  O(n)
     * Space complexity : O(1)
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            result *= 10;
            result += x % 10;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
