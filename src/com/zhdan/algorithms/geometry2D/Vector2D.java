package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing vectors
 *
 * @author Egor Zhdan
 */
public class Vector2D extends GeometryObject2D implements Cloneable {

    /**
     * End point
     */
    private Point2D end;

    /**
     * Constructs a new Vector with zero length
     */
    public Vector2D() {
        end = new Point2D();
    }

    /**
     * Constructs a new Vector with given end
     *
     * @param end end point
     */
    public Vector2D(Point2D end) {
        this.end = (Point2D) end.clone();
    }

    /**
     * Constructs a new Vector with given begin and end
     *
     * @param start begin point
     * @param end   end point
     */
    public Vector2D(Point2D start, Point2D end) {
        this.end = (Point2D) end.clone();
        this.end.setX(this.end.x() - start.x());
        this.end.setY(this.end.y() - start.y());
    }

    /**
     * Returns the end of the vector
     *
     * @return end point
     */
    public Point2D getEnd() {
        return end;
    }

    /**
     * Returns the length of the vector
     *
     * @return length
     */
    public double length() {
        return Math.sqrt(Math.pow(end.x(), 2) + Math.pow(end.y(), 2));
    }

    /**
     * Makes the length equal to 1 with saving proportions
     */
    public void normalize() {
        double l = length();
        end.setX(end.x() / l);
        end.setY(end.y() / l);
    }

    /**
     * Sets the vector length to the given value with saving proportions
     *
     * @param length length
     */
    public void setLength(double length) {
        double k = length() / length;
        end.setX(end.x() / k);
        end.setY(end.y() / k);
    }

    /**
     * Adds another vector coordinates to this
     *
     * @param vector2 2nd vector
     */
    public void add(Vector2D vector2) {
        this.end.setX(this.end.x() + vector2.end.x());
        this.end.setY(this.end.y() + vector2.end.y());
    }

    /**
     * Returns sum of two vectors
     *
     * @param vector2 2nd vector
     * @return sum
     */
    public Vector2D sum(Vector2D vector2) {
        Vector2D answer = (Vector2D) this.clone();
        answer.add(vector2);
        return answer;
    }

    /**
     * Reverses the vector
     */
    public void reverse() {
        end.setX(-end.x());
        end.setY(-end.y());
    }

    /**
     * Returns the dot product of two vectors
     *
     * @param vector2 2nd vector
     * @return dot product
     */
    public double dotProduct(Vector2D vector2) {
        return dotProduct(this, vector2);
    }

    /**
     * Returns the mixed product of two vectors
     *
     * @param vector2 2nd vector
     * @return mixed product
     */
    public double mixedProduct(Vector2D vector2) {
        return mixedProduct(this, vector2);
    }

    /**
     * Returns angle between two vectors
     *
     * @param vector2 2nd vector
     * @return angle
     */
    public Angle2D angle(Vector2D vector2) {
        return angle(this, vector2);
    }

    /**
     * Checks whether angle between two vectors is equal to 90
     *
     * @param vector2 2nd vector
     * @return true if angle is equal to 90
     */
    public boolean isAngleEqualTo90(Vector2D vector2) {
        return Geometry2D.equals(dotProduct(vector2), 0.0);
    }

    /**
     * Checks whether angle between two vectors is less than 90
     *
     * @param vector2 2nd vector
     * @return true if angle is less than 90
     */
    public boolean isAngleLessThan90(Vector2D vector2) {
        return dotProduct(vector2) > -Geometry2D.ACCURACY;
    }

    /**
     * Checks whether angle between two vectors is more than 90
     *
     * @param vector2 2nd vector
     * @return true if angle is more than 90
     */
    public boolean isAngleMoreThan90(Vector2D vector2) {
        return dotProduct(vector2) < Geometry2D.ACCURACY;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector2D)) {
            return false;
        } else {
            Vector2D vector2 = (Vector2D) o;
            return end.equals(vector2.end);
        }
    }

    @Override
    public int hashCode() {
        return end.hashCode();
    }

    @Override
    public String toString() {
        return "Vector2D{" + end + '}';
    }


    /* Static methods: */

    /**
     * Returns the dot product of two vectors
     *
     * @param v1 1st vector
     * @param v2 2nd vector
     * @return dot product
     */
    public static double dotProduct(Vector2D v1, Vector2D v2) {
        return v1.end.x() * v2.end.x() + v1.end.y() * v2.end.y();
    }

    /**
     * Returns the mixed product of two vectors
     *
     * @param v1 1st vector
     * @param v2 2nd vector
     * @return mixed product
     */
    public static double mixedProduct(Vector2D v1, Vector2D v2) {
        return v1.end.x() * v2.end.y() - v1.end.y() * v2.end.x();
    }

    /**
     * Returns angle between two vectors
     *
     * @param v1 1st vector
     * @param v2 2nd vector
     * @return angle
     */
    public static Angle2D angle(Vector2D v1, Vector2D v2) {
        return new Angle2D(Math.atan2(v1.mixedProduct(v2), v1.dotProduct(v2)));
    }

}
