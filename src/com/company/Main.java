package com.company;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class Main {

    static Map<String, Method> methodCache = new HashMap<>();

    public static <T> void main(String[] args) throws UnsupportedEncodingException {
        // write your code here
        Map<Integer, Integer> fv=new HashMap<>();
        Map<Integer, Stack<Integer>> fs=new HashMap<>();

        fs.computeIfAbsent(0, z-> new Stack()).push(1);

        T instance = null;
        try {
            Class<?> z = Class.forName("com.company.AccountInfo");
            instance = (T) z.newInstance();
            Field[] fields = z.getDeclaredFields();
            List<Method> getMethods = new ArrayList<>();
            for (Field field : fields) {
                System.out.print(field.getName() + "-");
                field.setAccessible(true);
                String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method getMethod = z.getMethod(getMethodName);
                methodCache.put(getMethodName, getMethod);
                getMethods.add(getMethod);
            }
            System.out.println();
            for (Method method : getMethods) {
                System.out.print(method.getName() + "-");
            }
            System.out.println();
            List<Method> setMethods = new ArrayList<>();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + ":");
                String setMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Class type = field.getType();
                Method setMethod = z.getMethod(setMethodName, type);
                methodCache.put(setMethodName, setMethod);
                String value = Math.round(Math.random()) + "";
                if (field.getName().equals("id")) {
                    setMethod.invoke(instance, Integer.valueOf(value));
                } else {
                    setMethod.invoke(instance, value);
                }
                String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method getMethod1 = getMethod(getMethodName, z);
                System.out.print(getMethod1.invoke(instance)+" ");
                setMethods.add(setMethod);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String demo = "00010000000000000000";
//        long start = System.currentTimeMillis();
//        System.out.println(start);
//        byte[] b = new byte[demo.getBytes("UTF-8").length];
//        try {
//            b = demo.getBytes("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        b[2] = 49;
//        demo = new String(b, "utf-8");
//        System.out.println(System.currentTimeMillis()-start+" "+demo);
//        long start2 = System.currentTimeMillis();
//        System.out.println(start2 );
//        StringBuffer s = new StringBuffer(demo);
//        s.setCharAt(2, '0');
//        System.out.println(System.currentTimeMillis()-start2+" "+demo);
    }

    public static Method getMethod(String method, Class clazz) {
        try {
            if (methodCache.containsKey(method)) {
                return methodCache.get(method);
            }
            return clazz.getMethod(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
