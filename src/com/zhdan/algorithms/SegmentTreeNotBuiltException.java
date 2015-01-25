package com.zhdan.algorithms;

/**
 * Thrown by Segment Tree when trying to send requests to a not built tree
 *
 * @author Egor Zhdan
 */
public class SegmentTreeNotBuiltException extends AlgorithmException {

    private SegmentTreeNotBuiltException(String algorithm, String reason) {
        super(algorithm, reason);
    }

    public SegmentTreeNotBuiltException() {
        this("Segment Tree", "Segment Tree not built yet. Call .build() method before making requests to Segment Tree");
    }

}
