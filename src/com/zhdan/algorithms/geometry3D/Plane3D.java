package com.zhdan.algorithms.geometry3D;

/**
 * Class for storing planes
 *
 * @author Egor Zhdan
 */
public class Plane3D extends GeometryObject3D implements Cloneable {

    private Point3D point0;
    private Vector3D vector1;
    private Vector3D vector2;

    public Plane3D() {
        this.point0 = new Point3D();
        this.vector1 = new Vector3D();
        this.vector2 = new Vector3D();
    }

    public Plane3D(Point3D point0, Vector3D vector1, Vector3D vector2) {
        this.point0 = point0;
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    public Vector3D normal() {
        Vector3D crossProduct = Vector3D.crossProduct(this.vector1, this.vector2);
        crossProduct.reverse();
        return crossProduct;
    }

    public Point3D intersection(Line3D line) {
        Vector3D n = this.normal();
        Vector3D dp = new Vector3D(line.point0(), this.point0);
        double t = Vector3D.dotProduct(n, dp) / Vector3D.dotProduct(n, line.vector());
        return line.point(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane3D)) return false;

        Plane3D plane3D = (Plane3D) o;

        if (!point0.equals(plane3D.point0)) return false;
        if (!vector1.equals(plane3D.vector1)) return false;
        if (!vector2.equals(plane3D.vector2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = point0.hashCode();
        result = 31 * result + vector1.hashCode();
        result = 31 * result + vector2.hashCode();
        return result;
    }

}
