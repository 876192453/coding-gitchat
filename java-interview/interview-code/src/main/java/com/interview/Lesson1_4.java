package com.interview;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Lesson1_4 {
    static int count = 0;

    // 方式一，跳出多重循环
    @Test
    public void breakFor1() {
        myfor:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("J:" + j);
                if (j == 10) {
                    // 跳出多重循环
                    break myfor;
                }
            }
        }
    }

    // 方式二，跳出多重循环
    @Test
    public void breakFor2() {
        boolean flag = true;
        for (int i = 0; i < 100 && flag; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("J:" + j);
                if (j == 10) {
                    // 跳出多重循环
                    flag = false;
                    break;
                }
            }
        }
    }


    // 循环永远无法停下来
    @Test
    public void forever() {
        for (float i = 0; i != 1; i += 0.1) {
            System.out.println(i);
        }
    }

    // ++i 在多线程下产生的混乱
    @Test
    public void thread_plusplus() throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    System.out.println("thread:" + this.getName() + ",count=" + (++count));
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    System.out.println("thread:" + this.getName() + ",count=" + (++count));
                }
            }
        }.start();
        TimeUnit.MINUTES.sleep(5);
    }

    // ++i 基本使用
    @Test
    public void thread_plusplus2() {
        int i = 1;
        int i2 = ++i; // ++i 同等于 i=n+i;
        System.out.println(i);  // 2
        System.out.println(i2); // 2
    }

    // 条件运算符
    @Test
    public void condition() {
        String s = 3 > 1 ? "三大于一" : "三小于一";
        System.out.println(s);
    }

    // if 基础用法
    @Test
    public void testIf() {
        int num1 = 1;
        if (num1 > 1) {
            System.out.println("大于一");
        } else if (num1 == 1) {
            System.out.println("等于一");
        } else {
            System.out.println("其他");
        }
    }

    //while 使用 *
    @Test
    public void testWhile() {
        int w = 0;
        while (w < 3) {
            if (w == 2) {
                return;
            }
            System.out.println(++w);
        }
    }

    //do/while 使用 *
    @Test
    public void doWhile() {
        int d = 0;
        do {
            System.out.println(++d);
        } while (d < 3);
    }

    // for 使用
    @Test
    public void testFor() {
        for (int j = 0; j < 10; j++) {
            System.out.println("j：" + j);
        }
    }

    // continue 使用
    @Test
    public void testContinue() {
        for (int j = 1; j < 4; j++) {
            if (j == 2) continue;
            System.out.println("j：" + j);
        }
    }

    //switch 无 break 代码
    @Test
    public void testSwitch() {
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("等于1");
            case 2:
                System.out.println("等于2");
            case 3:
                System.out.println("等于3");
            default:
                System.out.println("其他");
        }
    }

    @Test
    public void testFor2() {
        for (float i = 0; i != 10; i += 0.1) {
            System.out.println("hi");
        }
    }
}
