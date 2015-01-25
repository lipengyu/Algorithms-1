package com.zhdan.algorithms.geometry2D;

import java.util.Comparator;

/**
 * Comparators for geometry objects
 *
 * @author Egor Zhdan
 */
public final class GeometryComparators2D {

    private GeometryComparators2D() {
    }

    public static class PointComparator implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            if (o1.x() > o2.x()) {
                return -1;
            } else if (o1.x() < o2.x()) {
                return 1;
            } else {
                if (o1.y() > o2.y()) {
                    return -1;
                } else if (o1.y() < o2.y()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static class AngleComparator implements Comparator<Angle2D> {
        @Override
        public int compare(Angle2D o1, Angle2D o2) {
            return Double.compare(o1.value(), o2.value());
        }
    }

}
