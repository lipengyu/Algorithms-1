package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing lines
 *
 * @author Egor Zhdan
 */
public class Line2D extends GeometryObject2D {

    /**
     * Horizontal axe coordinate coefficient
     */
    private double a;

    /**
     * Vertical axe coordinate coefficient
     */
    private double b;

    /**
     * Constant
     */
    private double c;

    /**
     * Constructs a new Line with a, b, c equal to 0
     */
    public Line2D() {
        a = 0.0;
        b = 0.0;
        c = 0.0;
    }

    /**
     * Constructs a new Line with given a, b, c
     *
     * @param a horizontal axe coordinate coefficient
     * @param b vertical axe coordinate coefficient
     * @param c constant
     */
    public Line2D(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Constructs a new Line which contains two given points
     *
     * @param point1 1st point
     * @param point2 2nd point
     */
    public Line2D(Point2D point1, Point2D point2) {
        a = point2.y() - point1.y();
        b = point1.x() - point2.x();
        c = point2.x() * point1.y() - point1.x() * point2.y();
    }

    /**
     * Returns horizontal axe coordinate coefficient
     *
     * @return horizontal axe coordinate coefficient
     */
    public double a() {
        return a;
    }

    /**
     * Sets horizontal axe coordinate coefficient to the given value
     *
     * @param a new horizontal axe coordinate coefficient
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Returns vertical axe coordinate coefficient
     *
     * @return vertical axe coordinate coefficient
     */
    public double b() {
        return b;
    }

    /**
     * Sets vertical axe coordinate coefficient to the given value
     *
     * @param b new vertical axe coordinate coefficient
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Returns constant
     *
     * @return constant
     */
    public double c() {
        return c;
    }

    /**
     * Sets constant to the given value
     *
     * @param c new constant
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Returns intersection of two lines
     *
     * @param line2 2nd line
     * @return common point
     */
    public Point2D intersection(Line2D line2) {
        Point2D common = new Point2D();
        common.setX((b * line2.c - line2.b * c) / (a * line2.b - line2.a * b));
        common.setY(-(a * common.x() + c) / b);
        return common;
    }

    /**
     * Checks it the line contains point
     *
     * @param point point
     * @return true if the line contains point, otherwise false
     */
    public boolean contains(Point2D point) {
        return Geometry2D.equals(a * point.x() + b * point.y() + c, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line2D)) return false;

        Line2D line2D = (Line2D) o;

        if (Double.compare(line2D.a, a) != 0) return false;
        if (Double.compare(line2D.b, b) != 0) return false;
        if (Double.compare(line2D.c, c) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
