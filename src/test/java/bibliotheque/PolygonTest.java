package bibliotheque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void testPolygonWithNumberOfSides() {
        Point center = new Point(0, 0);
        Polygon polygon = new Polygon(4, 1.0, center); // Carré de rayon 1 centré à l'origine

        assertEquals(4, polygon.getNumberOfPoints(), "Le polygone doit avoir 4 sommets.");
    }

    @Test
    void testAddPoint() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(1, 0));

        assertEquals(2, polygon.getNumberOfPoints(), "Le polygone doit avoir 2 sommets.");
    }

    @Test
    void testGetSideLengths() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(1, 0));
        polygon.addPoint(new Point(1, 1));

        ArrayList<Double> sideLengths = polygon.getSideLengths();

        assertEquals(3, sideLengths.size(), "Le polygone doit avoir 3 côtés (fermé automatiquement).");
        assertEquals(1.0, sideLengths.get(0), 1e-10, "Le premier côté doit mesurer 1 unité.");
        assertEquals(1.0, sideLengths.get(1), 1e-10, "Le deuxième côté doit mesurer 1 unité.");
    }

    @Test
    void testIsPointInside() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(2, 0));
        polygon.addPoint(new Point(1, 2));

        Point insidePoint = new Point(1, 1);
        Point outsidePoint = new Point(3, 3);

        assertTrue(polygon.isPointInside(insidePoint), "Le point doit être à l'intérieur du polygone.");
        assertFalse(polygon.isPointInside(outsidePoint), "Le point doit être à l'extérieur du polygone.");
    }

    @Test
    void testDistanceToPolygon_InsidePoint() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(4, 0));
        polygon.addPoint(new Point(4, 4));
        polygon.addPoint(new Point(0, 4));

        Point insidePoint = new Point(2, 2);
        double distance = polygon.distanceToPolygon(insidePoint);

        assertTrue(distance < 0, "La distance doit être négative pour un point à l'intérieur.");
    }

    @Test
    void testDistanceToPolygon_OutsidePoint() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(4, 0));
        polygon.addPoint(new Point(4, 4));
        polygon.addPoint(new Point(0, 4));

        Point outsidePoint = new Point(5, 2);
        double distance = polygon.distanceToPolygon(outsidePoint);

        assertTrue(distance > 0, "La distance doit être positive pour un point à l'extérieur.");
        assertEquals(1.0, distance, 1e-10, "La distance doit être égale à 1 unité.");
    }

    @Test
    void testIsPointOnSegment() {
        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(0, 0));
        polygon.addPoint(new Point(4, 0));

        Point pointOnSegment = new Point(2, 0);
        Point pointOffSegment = new Point(2, 1);

        assertTrue(polygon.isPointOnSegment(pointOnSegment, new Point(0, 0), new Point(4, 0)),
                "Le point doit être sur le segment.");
        assertFalse(polygon.isPointOnSegment(pointOffSegment, new Point(0, 0), new Point(4, 0)),
                "Le point ne doit pas être sur le segment.");
    }
}
