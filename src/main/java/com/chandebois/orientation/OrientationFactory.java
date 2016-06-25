package com.chandebois.orientation;

/**
 * Created by nonok on 25/06/2016.
 */
public class OrientationFactory {

    public static Orientation getOrientation(char orientationCode) {
        Orientation orientation = null;
        switch (orientationCode) {
            case 'N':
                orientation = new OrientationNorth();
                break;
            case 'E':
                orientation = new OrientationEast();
                break;
            case 'S':
                orientation = new OrientationSouth();
                break;
            case 'W':
                orientation = new OrientationWest();
                break;
            default:
                orientation = null;
        }
        return orientation;
    }
}
