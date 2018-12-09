package com.university.app.helpers;

public class StudentNameValidator {
    public static boolean isFirstLetterInStringEqualToX(String str, char x) {
        // Match case
        return str != null && str.length() > 0 && str.toCharArray()[0] == x;
    }
}
