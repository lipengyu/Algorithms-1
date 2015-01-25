package com.zhdan.algorithms;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class MathUtilsTest {

    @Test(timeout = 500)
    public void testFactorize() {
        Random r = new Random();
        int n = Math.abs(r.nextInt());

        List<Integer> result = MathUtils.factorize(n);

        System.out.println("n = " + n + ":");
        result.forEach(System.out::println);
    }

    @Test(timeout = 1000)
    public void testCountRelativelyPrime() {
        Random r = new Random();
        int n = Math.abs(r.nextInt(100));

        int result = MathUtils.countRelativelyPrime(n);

        System.out.println("n = " + n + ": " + result);
    }

    @Test
    public void testPrimesTo() {
        Random r = new Random();
        int n = Math.abs(r.nextInt(1000));

        boolean[] result = MathUtils.primesTo(n);

        System.out.println("n = " + n + ":");
        for (int i = 0; i < n; i++) {
            if (result[i]) {
                System.out.println(i);
            }
        }
    }

}