package com.zhdan.algorithms.geometry2D;

/**
 * Class for storing rectangles
 *
 * @author Egor Zhdan
 */
public class Rectangle2D extends GeometryObject2D implements GeometryShape2D {

    /**
     * Corner point, opposite to point2
     */
    private Point2D point1;

    /**
     * Corner point, opposite to point1
     */
    private Point2D point2;

    /**
     * Width
     */
    private double width;

    /**
     * Height
     */
    private double height;

    /**
     * Constructs a new Rectangle with given corner points
     *
     * @param point1 corner point, opposite to point2
     * @param point2 corner point, opposite to point1
     */
    public Rectangle2D(Point2D point1, Point2D point2) {
        this.point1 = (Point2D) point1.clone();
        this.point2 = (Point2D) point2.clone();

        width = Math.abs(point2.x() - point1.x());
        height = Math.abs(point2.y() - point1.y());
    }

    /**
     * Constructs a new Rectangle with given corner point, height and width
     *
     * @param point1 left down corner point
     * @param width  width
     * @param height height
     */
    public Rectangle2D(Point2D point1, double width, double height) {
        this.width = width;
        this.height = height;

        this.point1 = (Point2D) point1.clone();
        this.point2 = (Point2D) point1.clone();
        point2.setY(height + point2.y());
        point2.setX(width + point2.x());
    }

    /**
     * Constructs a new Rectangle with given height and width, and left down corner point (0, 0)
     *
     * @param width  width
     * @param height height
     */
    public Rectangle2D(double width, double height) {
        this(new Point2D(-width / 2.0, -height / 2.0), width, height);
    }

    /**
     * Returns height of the rectangle
     *
     * @return height
     */
    public double height() {
        return height;
    }

    /**
     * Returns width of the rectangle
     *
     * @return width
     */
    public double width() {
        return width;
    }

    /**
     * Returns 1st corner point
     *
     * @return corner point
     */
    public Point2D point1() {
        return point1;
    }

    /**
     * Returns 2nd corner point
     *
     * @return corner point
     */
    public Point2D point2() {
        return point2;
    }

    /**
     * Returns multiplication of height and width
     *
     * @return area of rectangle
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Returns doubled sum of width and height
     *
     * @return perimeter of rectangle
     */
    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

}
