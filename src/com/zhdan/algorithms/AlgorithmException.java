package com.zhdan.algorithms;

/**
 * Generic exception
 *
 * @author Egor Zhdan
 */
public class AlgorithmException extends Exception {

    private AlgorithmException(String message) {
        super(message);
    }

    public AlgorithmException(Object object, String reason) {
        this("\nAlgorithm: " + object.getClass().getSimpleName() + "\nReason: " + reason);
    }

    public AlgorithmException(String algorithm, String reason) {
        this("\nAlgorithm: " + algorithm + "\nReason: " + reason);
    }

}
