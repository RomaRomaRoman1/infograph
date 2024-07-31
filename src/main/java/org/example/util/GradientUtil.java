package org.example.util;

public class GradientUtil {

    public static int calculateGradient(double percentage) {
        if (percentage < 40) {
            return 1;
        } else if (percentage < 60) {
            return 2;
        } else if (percentage < 70) {
            return 3;
        } else if (percentage < 80) {
            return 4;
        } else {
            return 5;
        }
    }
}
