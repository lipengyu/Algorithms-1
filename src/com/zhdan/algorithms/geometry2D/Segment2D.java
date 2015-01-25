package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing segments
 *
 * @author Egor Zhdan
 */
public class Segment2D extends GeometryObject2D {

    private Point2D firstPoint;
    private Point2D lastPoint;

    /**
     * Constructs a new Segment with zero length
     */
    public Segment2D() {
        firstPoint = new Point2D();
        lastPoint = new Point2D();
    }

    /**
     * Constructs a new Segment which contains given point as the first and the last
     *
     * @param firstPoint first point
     * @param lastPoint last point
     */
    public Segment2D(Point2D firstPoint, Point2D lastPoint) {
        this.firstPoint = (Point2D) firstPoint.clone();
        this.lastPoint = (Point2D) lastPoint.clone();
    }

    /**
     * Returns the first point of the segment
     *
     * @return first point
     */
    public Point2D firstPoint() {
        return firstPoint;
    }

    /**
     * Sets the new first point to given
     *
     * @param firstPoint first point
     */
    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    /**
     * Returns the second point of the segment
     *
     * @return last point
     */
    public Point2D lastPoint() {
        return lastPoint;
    }

    /**
     * Sets the new last point to given
     *
     * @param lastPoint last point
     */
    public void setLastPoint(Point2D lastPoint) {
        this.lastPoint = lastPoint;
    }

    /**
     * Returns the length of the segment
     *
     * @return distance between first and last points
     */
    public double length() {
        return firstPoint.distance(lastPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Segment2D)) {
            return false;
        } else {
            Segment2D segment2 = (Segment2D) o;
            return (firstPoint.equals(segment2.firstPoint) && lastPoint.equals(segment2.lastPoint)) ||
                    firstPoint.equals(segment2.lastPoint) && lastPoint.equals(segment2.firstPoint);
        }
    }

    /**
     * Returns line which contains the segment
     *
     * @return new line which contains this segment
     */
    public Line2D toLine() {
        return new Line2D(firstPoint, lastPoint);
    }

    @Override
    public String toString() {
        return firstPoint.toString() + " " + lastPoint.toString();
    }

}
