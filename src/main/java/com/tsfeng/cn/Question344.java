package com.tsfeng.cn;

/**
 * 344. Reverse String
 * @author tsfeng
 * @version 创建时间 2017/11/5 11:43
 */
public class Question344 {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString3(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        String s = "hello";
        Question344 question344 = new Question344();
        long t1 = System.nanoTime();
        String result = question344.reverseString(s);
        long t2 = System.nanoTime();
        System.out.println(result + "=====" + (t2 - t1));
        long t3 = System.nanoTime();
        result = question344.reverseString2(s);
        long t4 = System.nanoTime();
        System.out.println(result + "=====" + (t4 - t3));
        long t5 = System.nanoTime();
        result = question344.reverseString3(s);
        long t6 = System.nanoTime();
        System.out.println(result + "=====" + (t6 - t5));
    }
}
