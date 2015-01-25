package com.zhdan.algorithms.geometry3D;

/**
 * Class which all geometry objects extend
 *
 * @author Egor Zhdan
 */
public class GeometryObject3D implements Cloneable {

    @Override
    public GeometryObject3D clone() {
        try {
            return (GeometryObject3D) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
