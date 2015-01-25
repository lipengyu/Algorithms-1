package com.zhdan.algorithms.geometry2D;

/**
 * Class which all geometry objects extend
 *
 * @author Egor Zhdan
 */
public class GeometryObject2D implements Cloneable {

    @Override
    public GeometryObject2D clone() {
        try {
            return (GeometryObject2D) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
