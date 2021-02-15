package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchMethod {

    private static final String mode = "^([0-9,a-z,A-Z])+([\\|][0-9])*";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String key = scanner.next();
            System.out.println(isMatch(key));
        }

    }

    public static boolean isMatch(String key) {
        Pattern pattern = Pattern.compile(mode);
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }
}
