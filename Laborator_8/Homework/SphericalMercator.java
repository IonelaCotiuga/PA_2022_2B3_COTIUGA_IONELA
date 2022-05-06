package lab8;

import java.awt.*;

public class SphericalMercator extends Mercator{
    @Override
    double xAxisProjection(double latitude) {
        return Math.toRadians(latitude) * RADIUS_MAJOR /10000;
    }

    @Override
    double yAxisProjection(double longitude) {
        return Math.log(Math.tan(Math.PI / 4 + Math.toRadians(longitude) / 2)) * RADIUS_MAJOR / 10000;
    }


}

