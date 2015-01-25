package com.zhdan.algorithms;

/**
 * Class for working with numbers
 *
 * @author Egor Zhdan
 */
public final class NumberUtils {

    private NumberUtils() {
    }

    public static <T extends Number> T min(T x, T y) throws AlgorithmException {
        if (x instanceof Integer && y instanceof Integer) {
            return (T) (Integer) Math.min((Integer) x, (Integer) y);
        } else if (x instanceof Double && y instanceof Double) {
            return (T) (Double) Math.min((Double) x, (Double) y);
        } else if (x instanceof Long && y instanceof Long) {
            return (T) (Long) Math.min((Long) x, (Long) y);
        } else if (x instanceof Float && y instanceof Float) {
            return (T) (Float) Math.min((Float) x, (Float) y);
        } else {
            throw new AlgorithmException("NumberUtils", "illegal number type");
        }
    }

    public static <T extends Number> T max(T x, T y) throws AlgorithmException {
        if (x instanceof Integer && y instanceof Integer) {
            return (T) (Integer) Math.max((Integer) x, (Integer) y);
        } else if (x instanceof Double && y instanceof Double) {
            return (T) (Double) Math.max((Double) x, (Double) y);
        } else if (x instanceof Long && y instanceof Long) {
            return (T) (Long) Math.max((Long) x, (Long) y);
        } else if (x instanceof Float && y instanceof Float) {
            return (T) (Float) Math.max((Float) x, (Float) y);
        } else {
            throw new AlgorithmException("NumberUtils", "illegal number type");
        }
    }

    public static <T extends Number> T sum(T x, T y) throws AlgorithmException {
        if (x instanceof Integer && y instanceof Integer) {
            return (T) (Integer) ((Integer) x + (Integer) y);
        } else if (x instanceof Double && y instanceof Double) {
            return (T) (Double) ((Double) x + (Double) y);
        } else if (x instanceof Long && y instanceof Long) {
            return (T) (Long) ((Long) x + (Long) y);
        } else if (x instanceof Float && y instanceof Float) {
            return (T) (Float) ((Float) x + (Float) y);
        } else {
            throw new AlgorithmException("NumberUtils", "illegal number type");
        }
    }

    public static <T extends Number> T GCD(T x, T y) throws AlgorithmException {
        if (x instanceof Integer && y instanceof Integer) {
            return (T) (Integer) MathUtils.GCD((Integer) x, (Integer) y);
        } else if (x instanceof Long && y instanceof Long) {
            return (T) (Long) MathUtils.GCD((Long) x, (Long) y);
        } else {
            throw new AlgorithmException("NumberUtils", "illegal number type");
        }
    }

    public static <T extends Number> T LCM(T x, T y) throws AlgorithmException {
        if (x instanceof Integer && y instanceof Integer) {
            return (T) (Integer) MathUtils.LCM((Integer) x, (Integer) y);
        } else if (x instanceof Long && y instanceof Long) {
            return (T) (Long) MathUtils.LCM((Long) x, (Long) y);
        } else {
            throw new AlgorithmException("NumberUtils", "illegal number type");
        }
    }

}
