package com.zhdan.algorithms.geometry3D;

/**
 * Class for storing angles (in radians)
 *
 * @author Egor Zhdan
 */
public class Angle3D {

    /**
     * Value in radians
     */
    private double value;

    /**
     * Constructs a new Angle
     */
    public Angle3D() {
        setValue(0);
    }

    /**
     * Constructs a new Angle with given value
     *
     * @param value angle value in radians
     */
    public Angle3D(double value) {
        setValue(value);
    }

    /**
     * Angle value (in radians)
     *
     * @return angle value in radians
     */
    public double value() {
        return value;
    }

    /**
     * Sets new angle value (in radians)
     *
     * @param value new angle value in radians
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Angle value (in degrees)
     *
     * @return angle value in degrees
     */
    public double degreeValue() {
        return Math.toDegrees(value);
    }

    /**
     * Sets new angle value (in degrees)
     *
     * @param degreeValue new angle value in degrees
     */
    public void setDegreeValue(double degreeValue) {
        this.value = Math.toRadians(degreeValue);
    }

}
