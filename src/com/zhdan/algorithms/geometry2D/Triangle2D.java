package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing triangles
 *
 * @author Egor Zhdan
 */
public class Triangle2D extends GeometryObject2D implements GeometryShape2D {

    /**
     * First vertex
     */
    private Point2D point1;

    /**
     * Second vertex
     */
    private Point2D point2;

    /**
     * Third vertex
     */
    private Point2D point3;

    /**
     * Segment between 1st and 2nd vertices
     */
    private Segment2D segment12;

    /**
     * Segment between 2st and 3rd vertices
     */
    private Segment2D segment23;

    /**
     * Segment between 3rd and 1st vertices
     */
    private Segment2D segment31;

    /**
     * Constructs a new Triangle with given vertices
     *
     * @param point1 1st vertex
     * @param point2 2nd vertex
     * @param point3 3rd vertex
     */
    public Triangle2D(Point2D point1, Point2D point2, Point2D point3) {
        this.point1 = (Point2D) point1.clone();
        this.point2 = (Point2D) point2.clone();
        this.point3 = (Point2D) point3.clone();
        segment12 = new Segment2D(this.point1, this.point2);
        segment23 = new Segment2D(this.point2, this.point3);
        segment31 = new Segment2D(this.point3, this.point1);
    }

    /**
     * Returns first vertex of the triangle
     *
     * @return 1st vertex
     */
    public Point2D point1() {
        return point1;
    }

    /**
     * Returns second vertex of the triangle
     *
     * @return 2nd vertex
     */
    public Point2D point2() {
        return point2;
    }

    /**
     * Returns third vertex of the triangle
     *
     * @return 3rd vertex
     */
    public Point2D point3() {
        return point3;
    }

    /**
     * Returns the segment between the first and the second vertices
     *
     * @return 1st segment between 1st and 2nd vertices
     */
    public Segment2D segment12() {
        return segment12;
    }

    /**
     * Returns the segment between the second and the third vertices
     *
     * @return 1st segment between 2nd and 3rd vertices
     */
    public Segment2D segment23() {
        return segment23;
    }

    /**
     * Returns the segment between the third and the first vertices
     *
     * @return 1st segment between 3rd and 1st vertices
     */
    public Segment2D segment31() {
        return segment31;
    }

    /**
     * Returns the largest angle in the triangle
     *
     * @return largest angle
     */
    public Angle2D largestAngle() {
        double length12 = segment12.length();
        double length23 = segment23.length();
        double length31 = segment31.length();

        if (length12 > length23) {
            if (length12 > length31) {
                // largest is point3
                Vector2D vector32 = new Vector2D((Point2D) point3.clone(), (Point2D) point2.clone());
                Vector2D vector31 = new Vector2D((Point2D) point3.clone(), (Point2D) point1.clone());
                return vector32.angle(vector31);
            } else {
                // largest is point2
                Vector2D vector21 = new Vector2D((Point2D) point2.clone(), (Point2D) point1.clone());
                Vector2D vector23 = new Vector2D((Point2D) point2.clone(), (Point2D) point3.clone());
                return vector21.angle(vector23);
            }
        } else {
            if (length23 > length31) {
                // largest is point1
                Vector2D vector12 = new Vector2D((Point2D) point1.clone(), (Point2D) point2.clone());
                Vector2D vector13 = new Vector2D((Point2D) point1.clone(), (Point2D) point3.clone());
                return vector12.angle(vector13);
            } else {
                // largest is point2
                Vector2D vector21 = new Vector2D((Point2D) point2.clone(), (Point2D) point1.clone());
                Vector2D vector23 = new Vector2D((Point2D) point2.clone(), (Point2D) point3.clone());
                return vector21.angle(vector23);
            }
        }
    }

    /**
     * Returns area of triangle calculated using Heron's formula
     *
     * @return area of triangle
     */
    @Override
    public double area() {
        double p2 = perimeter() / 2;
        return Math.sqrt(p2 * (p2 - segment12.length()) * (p2 - segment23.length()) * (p2 - segment31.length()));
    }

    /**
     * Returns sum of all edges
     *
     * @return sum of edges
     */
    @Override
    public double perimeter() {
        return segment12.length() + segment23.length() + segment31.length();
    }

}
