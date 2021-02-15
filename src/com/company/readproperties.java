package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.*;

public class readproperties {
    
    // 11ab1668240fac76811026b4f3280bb5dcd11870

    static Map way1 = new HashMap();
    static Map way2 = new HashMap();
    static Map way3 = new HashMap();
    public static void main(String[] args) {
        readProperties(System.getProperty("user.dir")+"\\test1.property");
    }

    public static void readProperties(String path) {
        Properties properties = new Properties();
        String key;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            Enumeration enumeration = properties.propertyNames();

            long start1 = System.currentTimeMillis();
            while(enumeration.hasMoreElements()) {
                key = (String) enumeration.nextElement();
                way1.put(key, properties.getProperty(key));
            }
            System.out.println(System.currentTimeMillis()-start1);

            start1 = System.currentTimeMillis();
            Iterator iterator = properties.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                way2.put(entry.getKey(), entry.getValue());
            }
            System.out.println(System.currentTimeMillis()-start1);

            start1 = System.currentTimeMillis();
            Set<String> keySet = properties.stringPropertyNames();
            Iterator<String> iterSet = keySet.iterator();
            for(String s : keySet) {
                way3.put(s, properties.getProperty(s));
            }
            System.out.println(System.currentTimeMillis()-start1);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getEntries(String entry) {
        String[] entries = entry.split("[:]");
        for (String s : entries) {

        }
    }

    public static void getClassMethod(String entry) {

    }
}
