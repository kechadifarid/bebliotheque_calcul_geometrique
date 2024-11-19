package bibliotheque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculTest {

    @Test
    void testDistanceFromPointToPoint() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        double result = Calcul.distanceFromPointToPoint(p1, p2);
        assertEquals(5.0, result, 1e-9, "La distance entre (0,0) et (3,4) devrait être 5.");
    }

    @Test
    void testDistanceFromPointToLine() {
        Point p = new Point(1, 1);
        Line l = new Line(1, 0); // y = x
        double result = Calcul.distanceFromPointToLine(p, l);
        assertEquals(0.0, result, 1e-9, "Le point (1,1) appartient à la ligne y = x, la distance doit être 0.");
    }

    @Test
    void testDistanceFromLineToLine_Parallel() {
        Line l1 = new Line(1, 0); // y = x
        Line l2 = new Line(1, 2); // y = x + 2
        double result = Calcul.distanceFromLineToLine(l1, l2);
        assertEquals(2.0 / Math.sqrt(2), result, 1e-9, "La distance entre deux lignes parallèles doit être correcte.");
    }

    @Test
    void testDistanceFromPointToCercle_Outside() {
        Point p = new Point(5, 0);
        Circle c = new Circle(3, new Point(0, 0));
        double result = Calcul.distanceFromPointToCercle(p, c);
        assertEquals(2.0, result, 1e-9, "La distance entre le point (5,0) et le cercle de rayon 3 centré en (0,0) doit être 2.");
    }

    @Test
    void testDistanceFromPointToCercle_Inside() {
        Point p = new Point(1, 0);
        Circle c = new Circle(3, new Point(0, 0));
        double result = Calcul.distanceFromPointToCercle(p, c);
        assertEquals(2.0, result, 1e-9, "La distance entre le point (1,0) et l'intérieur du cercle de rayon 3 doit être 2.");
    }

    @Test
    void testDistanceFromPointToSegment_PointOnSegment() {
        Point p = new Point(2, 2);
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        double result = Calcul.distanceFromPointToSegment(p, start, end);
        //assertEquals(0.0, result, 1e-9, "La distance doit être 0 si le point est sur le segment.");
    }


    @Test
    public void testDistanceFromPointToSegment_PointOutsideSegment() {
        Point p = new Point(1, 1);
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);

        double expectedDistance = Math.sqrt(2); // 1.4142135623730951
        double actualDistance = Calcul.distanceFromPointToSegment(p, a, b);

        Assertions.assertEquals(expectedDistance, actualDistance, "La distance doit être correcte si le point est en dehors du segment.");
    }



    @Test
    void testDistanceFromPointToSegment_PointClosestToStart() {
        Point p = new Point(-1, -1);
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        double result = Calcul.distanceFromPointToSegment(p, start, end);
        assertEquals(Math.sqrt(2), result, 1e-9, "La distance doit être correcte pour le point le plus proche de l'extrémité start.");
    }

    @Test
    void testDistanceFromPointToSegment_PointClosestToEnd() {
        Point p = new Point(5, 5);
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        double result = Calcul.distanceFromPointToSegment(p, start, end);
        assertEquals(Math.sqrt(2), result, 1e-9, "La distance doit être correcte pour le point le plus proche de l'extrémité end.");
    }
}
