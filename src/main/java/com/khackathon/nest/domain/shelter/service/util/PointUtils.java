package com.khackathon.nest.domain.shelter.service.util;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public final class PointUtils {

    private final static int COORDINATE_SYSTEM = 4326;

    private PointUtils() {

    }

    public static Point getPoint(
        double longitude,
        double latitude
    ) {
        GeometryFactory geometryFactory = new GeometryFactory(
            new PrecisionModel(),
            COORDINATE_SYSTEM
        );
        Coordinate coordinate = new Coordinate(
            longitude,
            latitude
        );
        return geometryFactory.createPoint(coordinate);
    }

}
