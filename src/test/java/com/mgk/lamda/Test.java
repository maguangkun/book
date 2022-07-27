package com.mgk.lamda;

public class Test {
    public static void main(String[] args) {
        TestLamda testLamda = (s)->{
            System.out.println(s);
        };
        testLamda.xifu("999");
    }
}
