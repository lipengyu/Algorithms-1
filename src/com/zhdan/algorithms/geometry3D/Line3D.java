package com.zhdan.algorithms.geometry3D;

/**
 * Class for storing lines
 *
 * @author Egor Zhdan
 */
public class Line3D extends GeometryObject3D implements Cloneable {

    private Point3D point0;
    private Vector3D vector;

    public Line3D() {
        this.point0 = new Point3D();
        this.vector = new Vector3D();
    }

    public Line3D(Point3D point0, Vector3D vector) {
        this.point0 = point0;
        this.vector = vector;
    }

    public Line3D(Point3D point1, Point3D point2) {
        this(point1, new Vector3D(point2.x() - point1.x(), point2.y() - point1.x(), point2.z() - point1.z()));
    }

    public Line3D(double x0, double y0, double z0, double xD, double yD, double zD) {
        this.point0 = new Point3D(x0, y0, z0);
        this.vector = new Vector3D(xD, yD, zD);
    }

    public Point3D point0() {
        return point0;
    }

    public Vector3D vector() {
        return vector;
    }

    public void setPoint0(Point3D point0) {
        this.point0 = point0;
    }

    public void setVector(Vector3D vector) {
        this.vector = vector;
    }

    public Point3D point(double t) {
        return new Point3D(this.point0.x() + t * this.vector.x(), this.point0.y() + t * this.vector.y(), this.point0.z() + t * this.vector.z());
    }

    public double distance(Point3D p) {
        Vector3D vl = this.vector;
        Vector3D vp = new Vector3D(this.point0, p);
        return Vector3D.crossProduct(vl, vp).norm() / vl.norm();
    }

    public boolean contains(Point3D point) {
        return this.distance(point) < Geometry3D.ACCURACY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line3D)) return false;

        Line3D line3D = (Line3D) o;

        if (!point0.equals(line3D.point0)) return false;
        if (!vector.equals(line3D.vector)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = point0.hashCode();
        result = 31 * result + vector.hashCode();
        return result;
    }

}
