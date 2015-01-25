package com.zhdan.algorithms.geometry3D;

/**
 * Class for storing vectors
 *
 * @author Egor Zhdan
 */
public class Vector3D extends GeometryObject3D implements Cloneable {

    private Point3D point;

    public Vector3D() {
        this.point = new Point3D();
    }

    public Vector3D(Point3D point) {
        this.point = point;
    }

    public Vector3D(Point3D point1, Point3D point2) {
        this.point = new Point3D();
        this.setX(point2.x() - point1.x());
        this.setY(point2.y() - point1.y());
        this.setZ(point2.z() - point1.z());
    }

    public Vector3D(double x, double y, double z) {
        this.point = new Point3D(x, y, z);
    }

    public Point3D point() {
        return this.point;
    }

    public void setPoint(Point3D point) {
        this.point = point;
    }

    public double x() {
        return point.x();
    }

    public void setX(double x) {
        point.setX(x);
    }

    public double y() {
        return point.y();
    }

    public void setY(double y) {
        point.setY(y);
    }

    public double z() {
        return point.z();
    }

    public void setZ(double z) {
        point.setZ(z);
    }

    public double length() {
        return Math.sqrt(this.x() * this.x() + this.y() * this.y() + this.z() * this.z());
    }

    public double norm() {
        return Math.hypot(Math.hypot(this.x(), this.y()), this.z());
    }

    public void normalize() {
        double r = this.norm();
        setX(this.x() / r);
        setY(this.y() / r);
        setZ(this.z() / r);
    }

    public double dotProduct(Vector3D v2) {
        return dotProduct(this, v2);
    }

    public void crossProduct(Vector3D v2) {
        this.setPoint(new Point3D(this.y() * v2.z() - this.z() * v2.y(), this.z() * v2.x() - this.x() * v2.z(), this.x() * v2.y() - this.y() * v2.x()));
    }

    public boolean isOrthogonal(Vector3D v2) {
        return Math.abs(dotProduct(this, v2)) < Geometry3D.ACCURACY;
    }

    public void reverse() {
        this.setX(-this.x());
        this.setY(-this.y());
        this.setZ(-this.z());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D)) return false;

        Vector3D vector3D = (Vector3D) o;

        if (!point.equals(vector3D.point)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }

    @Override
    public String toString() {
        return "Vector3D{" + point.x() + "; " + point.y() + "; " + point.z() + '}';
    }


    /* Static methods: */

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.y() * v2.z() - v1.z() * v2.y(), v1.z() * v2.x() - v1.x() * v2.z(), v1.x() * v2.y() - v1.y() * v2.x());
    }

    public static Angle3D angle(Vector3D v1, Vector3D v2) {
        return new Angle3D(Math.atan2(crossProduct(v1, v2).length(), dotProduct(v1, v2)));
    }

}
