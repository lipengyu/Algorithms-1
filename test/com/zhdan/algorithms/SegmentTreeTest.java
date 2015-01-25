package com.zhdan.algorithms;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SegmentTreeTest {

    @Test
    public void testSumSegmentTree() throws AlgorithmException {
        SegmentTree<Integer> sumSegmentTree = new SegmentTree<>(SegmentTree.DataProcessor.SUM);

        final int SIZE = 100;
        final int TEST_COUNT = 1000;

        Integer[] array = new Integer[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt(100000);
        }
        sumSegmentTree.build(array);

        for (int i = 0; i < TEST_COUNT; i++) {
            int index1 = r.nextInt(SIZE);
            int index2 = r.nextInt(SIZE);

            int left = Math.min(index1, index2);
            int right = Math.max(index1, index2);

            int answerTree = sumSegmentTree.get(left, right);
            int answerRight = 0;
            for (int j = left; j <= right; j++) {
                answerRight += array[j];
            }
            assertEquals(answerRight, answerTree);
        }
    }

    @Test
    public void testMinSegmentTree() throws AlgorithmException {
        SegmentTree<Integer> minSegmentTree = new SegmentTree<>(SegmentTree.DataProcessor.MIN);

        final int SIZE = 100;
        final int TEST_COUNT = 1000;

        Integer[] array = new Integer[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt();
        }
        minSegmentTree.build(array);

        for (int i = 0; i < TEST_COUNT; i++) {
            int index1 = r.nextInt(SIZE);
            int index2 = r.nextInt(SIZE);

            int left = Math.min(index1, index2);
            int right = Math.max(index1, index2);

            int answerTree = minSegmentTree.get(left, right);
            int answerRight = 0;
            for (int j = left; j <= right; j++) {
                answerRight = Math.min(answerRight, array[j]);
            }
            assertEquals(answerRight, answerTree);
        }
    }

}