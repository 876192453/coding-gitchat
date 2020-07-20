package com.interview;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 深入了解 Java 中的异常处理
 */
public class Lesson1_5 {
    // try-catch-finally 基本使用
    @Test
    public void tryCatchFinally() {
        try {
            int i = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }

    // 多 catch 使用
    @Test
    public void multiCatch() {
        try {
            int i = Integer.parseInt(null);
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException");
        } catch (NullPointerException ne) {
            System.out.println("NullPointerException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    // 使用 try-catch 处理业务
    // 引用 com.alibaba.fastjson
    @Test
    public void tryCatchCase() {
        JSONArray array = new JSONArray();
        String jsonStr = "{'name':'laowang'}";

        try {
            array = JSONArray.parseArray(jsonStr);
        } catch (Exception e) {
            array.add(JSONObject.parse(jsonStr));
        }
        System.out.println(array.size());
    }

    // ry-catch 处理业务的正确使用方式
    @Test
    public void tryCatchCaseSucc() {
        JSONArray array = new JSONArray();
        String jsonStr = "{'name':'laowang'}";

        if (null != jsonStr && !jsonStr.equals("")) {
            String firstChar = jsonStr.substring(0, 1);
            if (firstChar.equals("{")) {
                array.add(JSONObject.parse(jsonStr));
            } else if (firstChar.equals("[")) {
                array = JSONArray.parseArray(jsonStr);
            }
        }
        System.out.println(array.size());
        try {
            array = JSONArray.parseArray(jsonStr);
        } catch (Exception e) {
            array.add(JSONObject.parse(jsonStr));
        }
        System.out.println(array.size());
    }

    // Integer.parseInt 和 Double.parseDouble 的异常类型
    @Test
    public void parseNumException() {
        try {
            Integer.parseInt(null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Double.parseDouble(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // try-with-resources 和 multiple catch
    @Test
    public void tryWithResources() {
        try (FileReader fileReader = new FileReader("");
             FileWriter fileWriter = new FileWriter("")) { // Try-with-resources
            System.out.println("try");
        } catch (IOException | NullPointerException e) { // Multiple catch
            System.out.println(e);
        }
    }

    // finally 中发生的异常
    @Test
    public void finallyException() {
        try {
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            int k = 3 / 0;
            System.out.println("finally");
        }
    }

    // fiannly 返回值演示
    @Test
    public void finallyReturn() {
        System.out.println(getNumber());
    }

    public static int getNumber() {
        try {
            int number = 0 / 1;
            return 2;
        } finally {
            return 3;
        }
    }
}
