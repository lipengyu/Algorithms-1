package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing points
 *
 * @author Egor Zhdan
 */
public class Point2D extends GeometryObject2D {

    /**
     * Horizontal axe coordinate
     */
    private double x;

    /**
     * Vertical axe coordinate
     */
    private double y;

    /**
     * Constructs a new Point with zero coordinates
     */
    public Point2D() {
        setX(0.0);
        setY(0.0);
    }

    /**
     * Constructs a new Point with given coordinates
     *
     * @param x horizontal axe coordinate
     * @param y vertical axe coordinate
     */
    public Point2D(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Returns the horizontal axe coordinate of the point
     *
     * @return horizontal axe coordinate
     */
    public double x() {
        return x;
    }

    /**
     * Sets the horizontal axe coordinate to the given value
     *
     * @param x horizontal axe coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Returns the vertical axe coordinate of the point
     *
     * @return vertical axe coordinate
     */
    public double y() {
        return y;
    }

    /**
     * Sets the vertical axe coordinate to the given value
     *
     * @param y vertical axe coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns Euclidean distance between two points
     *
     * @param point2 second point
     * @return distance between two points
     */
    public double distance(Point2D point2) {
        return Math.sqrt(Math.pow(point2.x - x, 2) +
                Math.pow(point2.y - y, 2));
    }

    /**
     * Returns Euclidean distance between the point and the line
     *
     * @param line line
     * @return distance between point and line
     */
    public double distance(Line2D line) {
        return Math.abs(
                (line.a() * x + line.b() * y + line.c()) /
                        Math.sqrt(Math.pow(line.a(), 2) + Math.pow(line.b(), 2))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point2D)) {
            return false;
        } else {
            Point2D point2 = (Point2D) o;
            return Geometry2D.equals(x, point2.x) && Geometry2D.equals(y, point2.y);
        }
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point2D{" + x + "; " + y + '}';
    }

}
