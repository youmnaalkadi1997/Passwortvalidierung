package org.example;

import java.util.Set;

/**
 * Hello world!
 *
 */


public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    private static final Set<String> COMMON_PASSWORDS = Set.of(
            "password", "passwort1", "12345678", "aa345678"
    );

    public static boolean hasMinLength(String password, int min){
        return password != null && password.length() >= min;
    }

    public static boolean containsNumber(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                hasUpper = true;
            } else if (ch >= 'a' && ch <= 'z') {
                hasLower = true;
            }

            if (hasUpper && hasLower) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCommonPassword(String password) {
        if (password == null || password.isEmpty()) return false;
        return COMMON_PASSWORDS.contains(password.trim().toLowerCase());
    }

    public static boolean isValid(String password) {
        return hasMinLength(password, 8)
                && containsNumber(password)
                && containsUpperAndLower(password)
                && !isCommonPassword(password);
    }

    public static boolean containsSpecialChar(String password, String allowedSpecials) {
        if (password == null || allowedSpecials == null) return false;

        for (char c : password.toCharArray()) {
            if (allowedSpecials.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }
}
