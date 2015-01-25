package com.zhdan.algorithms.geometry3D;

/**
 * Final class with static methods
 *
 * @author Egor Zhdan
 */
public final class Geometry3D {

    private Geometry3D() {
    }

    /**
     * Accuracy used when comparing numbers with floating point
     */
    public static double ACCURACY = 10e-9;

    /**
     * Compare numbers with floating point with ACCURACY
     *
     * @param d1 1st number to compare
     * @param d2 2nd number to compare
     * @return true if d1 equals d2, otherwise false
     */
    public static boolean equals(double d1, double d2) {
        return Math.abs(d1 - d2) < ACCURACY;
    }

}
