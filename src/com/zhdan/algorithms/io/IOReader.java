package com.zhdan.algorithms.io;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Fast scanner
 *
 * @author Egor Zhdan
 */
public class IOReader {

    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    public int[] readIntArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public double[] readDoubleArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public long[] readLongArray(int count) {
        long[] array = new long[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public BigInteger[] readBigIntegerArray(int count) {
        BigInteger[] array = new BigInteger[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextBigInteger();
        }
        return array;
    }

    private IOReader(BufferedReader bufferedReader) {
        reader = bufferedReader;
    }

    public IOReader(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public IOReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

}
