package com.zhdan.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Additional math methods
 *
 * @author Egor Zhdan
 */
public final class MathUtils {

    private MathUtils() {
    }

    private static void assertNatural(int n) {
        if (n <= 0) throw new IllegalArgumentException("number must be > 0");
    }

    private static void assertNatural(long n) {
        if (n <= 0) throw new IllegalArgumentException("number must be > 0");
    }

    public static int GCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (min == 0) return max;
        max %= min;
        return GCD(max, min);
    }

    public static long GCD(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        if (min == 0) return max;
        max %= min;
        return GCD(max, min);
    }

    public static int LCM(int a, int b) {
        int m = a * b;
        return m / GCD(a, b);
    }

    public static long LCM(long a, long b) {
        long m = a * b;
        return m / GCD(a, b);
    }

    public static boolean isPrime(int x) {
        if (x <= 1) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime(long x) {
        if (x <= 1) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    /**
     * Returns factorization of given number
     * <p>
     * <strong>Complexity</strong>: sqrt(n)
     *
     * @param n natural number
     * @return list of prime dividers of n
     */
    public static List<Integer> factorize(int n) {
        assertNatural(n);

        List<Integer> dividers = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                dividers.add(i);
                n /= i;
            }
        }
        return dividers;
    }

    /**
     * Returns factorization of given number
     * <p>
     * <strong>Complexity</strong>: sqrt(n)
     *
     * @param n natural number
     * @return list of prime dividers of n
     */
    public static List<Long> factorize(long n) {
        assertNatural(n);

        List<Long> dividers = new ArrayList<>();
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                dividers.add(i);
                n /= i;
            }
        }
        return dividers;
    }

    /**
     * Returns count of relatively prime numbers with given which are less than given
     * <p>
     * Uses Euler's function (https://en.wikipedia.org/wiki/Euler%27s_totient_function)
     * <p>
     * <strong>Complexity</strong>: sqrt(n)
     *
     * @param n natural number
     * @return count of relatively prime with n in segment [1; n]
     */
    public static int countRelativelyPrime(int n) {
        assertNatural(n);

        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    /**
     * Returns count of relatively prime numbers with given which are less than given
     * <p>
     * Uses Euler's function (https://en.wikipedia.org/wiki/Euler%27s_totient_function)
     * <p>
     * <strong>Complexity</strong>: sqrt(n)
     *
     * @param n natural number
     * @return count of relatively prime with n in segment [1; n]
     */
    public static long countRelativelyPrime(long n) {
        assertNatural(n);

        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    /**
     * Returns all prime numbers less than n
     * <p>
     * <strong>Complexity</strong>: n * log n * log n
     *
     * @param n natural number
     * @return array of booleans, where ith item is true if i is prime, otherwise false
     */
    public static boolean[] primesTo(int n) {
        assertNatural(n);

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                if ((long) i * (long) i <= (long) n) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
    }

}
