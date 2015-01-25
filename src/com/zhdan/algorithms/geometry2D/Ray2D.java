package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing rays
 *
 * @author Egor Zhdan
 */
public class Ray2D extends GeometryObject2D {

    /**
     * First point
     */
    private Point2D firstPoint;

    /**
     * Vector
     */
    private Vector2D vector;

    /**
     * Constructs a new Ray with zero first point and zero vector
     */
    public Ray2D() {
        setFirstPoint(new Point2D());
        setVector(new Vector2D());
    }

    /**
     * Constructs a new Ray with given first point and vector
     *
     * @param firstPoint first point
     * @param vector vector
     */
    public Ray2D(Point2D firstPoint, Vector2D vector) {
        setFirstPoint((Point2D) firstPoint.clone());
        setVector((Vector2D) vector.clone());
    }

    /**
     * Returns the first point of the ray
     *
     * @return first point
     */
    public Point2D firstPoint() {
        return firstPoint;
    }

    /**
     * Sets the first point of the ray to the given value
     *
     * @param firstPoint first point
     */
    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    /**
     * Returns the vector of the ray
     *
     * @return vector
     */
    public Vector2D getVector() {
        return vector;
    }

    /**
     * Sets the vector of the ray to the given value
     *
     * @param vector first point
     */
    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

}
