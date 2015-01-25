package com.zhdan.algorithms;

/**
 * Class for storing segment trees
 * <p>
 * Segment tree is a tree data structure for storing intervals, or segments.
 * It allows querying which of the stored segments contain a given point.
 *
 * @author Egor Zhdan
 */
public class SegmentTree<E> {

    private int itemsCount = 0;
    private boolean initialized = false;
    private E[] tree;
    private DataProcessor<E> processor;

    /**
     * Constructs a new segment tree with given data processor
     *
     * @param dataProcessor data processor
     */
    public SegmentTree(DataProcessor<E> dataProcessor) {
        this.processor = dataProcessor;
    }

    /**
     * Returns data processor of this segment tree
     *
     * @return data processor
     */
    public DataProcessor<E> dataProcessor() {
        return processor;
    }

    /**
     * Builds segment tree using given array
     *
     * @param array values
     * @throws AlgorithmException when segment tree is already built
     */
    public void build(E[] array) throws AlgorithmException {
        if (initialized) throw new AlgorithmException(this, "already built");

        itemsCount = array.length;
        tree = (E[]) new Object[itemsCount * 4];
        build(array, 1, 0, itemsCount - 1);
        initialized = true;
    }

    private void build(E[] array, int vertex, int treeLeftIndex, int treeRightIndex) throws AlgorithmException {
        if (treeLeftIndex == treeRightIndex)
            tree[vertex] = array[treeLeftIndex];
        else {
            int treeMidIndex = (treeLeftIndex + treeRightIndex) / 2;
            build(array, vertex * 2, treeLeftIndex, treeMidIndex);
            build(array, vertex * 2 + 1, treeMidIndex + 1, treeRightIndex);
            tree[vertex] = processor.process(tree[vertex * 2], tree[vertex * 2 + 1]);
        }
    }

    /**
     * Returns count of items in segment tree
     *
     * @return items count
     */
    public int size() {
        return itemsCount;
    }

    /**
     * Updates value at given index
     * <p>
     * <strong>Complexity</strong>: log n
     *
     * @param index index at which to update value
     * @param value value
     * @throws AlgorithmException when index is out of bounds
     */
    public void update(int index, E value) throws AlgorithmException {
        if (!initialized) throw new SegmentTreeNotBuiltException();
        if (index >= itemsCount) throw new AlgorithmException(this, "index out of bounds");

        update(1, 0, itemsCount - 1, index, value);
    }

    private void update(int vertex, int treeLeftIndex, int treeRightIndex, int index, E value) throws AlgorithmException {
        if (treeLeftIndex == treeRightIndex) {
            tree[vertex] = value;
        } else {
            int treeMidIndex = (treeLeftIndex + treeRightIndex) / 2;
            if (index <= treeMidIndex) {
                update(vertex * 2, treeLeftIndex, treeMidIndex, index, value);
            } else {
                update(vertex * 2 + 1, treeMidIndex + 1, treeRightIndex, index, value);
            }
            tree[vertex] = processor.process(tree[vertex * 2], tree[vertex * 2 + 1]);
        }
    }

    /**
     * Returns value on segment
     * <p>
     * <strong>Complexity</strong>: log n
     *
     * @param leftIndex  segment left index (inclusive)
     * @param rightIndex segment right index (inclusive)
     * @return value
     * @throws AlgorithmException when index is out of bounds
     */
    public E get(int leftIndex, int rightIndex) throws AlgorithmException {
        if (!initialized) throw new SegmentTreeNotBuiltException();
        if (leftIndex < 0 || leftIndex >= itemsCount) {
            throw new AlgorithmException(this, "left index exceeds bounds");
        }
        if (rightIndex < 0 || rightIndex >= itemsCount) {
            throw new AlgorithmException(this, "right index exceeds bounds");
        }

        return get(1, 0, itemsCount - 1, leftIndex, rightIndex);
    }

    private E get(int vertex, int treeLeftIndex, int treeRightIndex, int leftIndex, int rightIndex) throws AlgorithmException {
        if (leftIndex > rightIndex) {
            return (E) (Number) 0;
        }
        if (leftIndex == treeLeftIndex && rightIndex == treeRightIndex) {
            return tree[vertex];
        }
        int treeMidIndex = (treeLeftIndex + treeRightIndex) / 2;
        return processor.process(get(vertex * 2, treeLeftIndex, treeMidIndex, leftIndex, Math.min(rightIndex, treeMidIndex)),
                get(vertex * 2 + 1, treeMidIndex + 1, treeRightIndex, Math.max(leftIndex, treeMidIndex + 1), rightIndex));
    }

    /**
     * Checks whether segment tree is built
     *
     * @return true is already built, otherwise false
     */
    public boolean isInitialized() {
        return initialized;
    }


    /**
     * Interface which segment tree uses to process data
     */
    public static interface DataProcessor<E> {

        /**
         * Processes two given values
         *
         * @param a 1st given value
         * @param b 2nd given value
         * @return processing result
         */
        public E process(E a, E b);


        public static final DataProcessor MAX = (a, b) -> {
            try {
                return NumberUtils.max((Number) a, (Number) b);
            } catch (AlgorithmException e) {
                e.printStackTrace();
                return 0;
            }
        };

        public static final DataProcessor MIN = (a, b) -> {
            try {
                return NumberUtils.min((Number) a, (Number) b);
            } catch (AlgorithmException e) {
                e.printStackTrace();
                return 0;
            }
        };

        public static final DataProcessor SUM = (a, b) -> {
            try {
                return NumberUtils.sum((Number) a, (Number) b);
            } catch (AlgorithmException e) {
                e.printStackTrace();
                return 0;
            }
        };

        public static final DataProcessor GCD = (a, b) -> {
            try {
                return NumberUtils.GCD((Number) a, (Number) b);
            } catch (AlgorithmException e) {
                e.printStackTrace();
                return 0;
            }
        };

        public static final DataProcessor LCM = (a, b) -> {
            try {
                return NumberUtils.LCM((Number) a, (Number) b);
            } catch (AlgorithmException e) {
                e.printStackTrace();
                return 0;
            }
        };

    }

}
