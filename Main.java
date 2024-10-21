package Calculer_Distance;

public class Main {
    public static void main(String[] args) {

        /*
        Point A = new Point(1,2);
        Carre c = new Carre(A,3);
        c.getPoints();
        */



        //TEST distance entre un point et un polygant

        Polygon polygon = new Polygon();
        polygon.addPoint(new Point(1, 1)); // Point 1
        polygon.addPoint(new Point(4, 1)); // Point 2
        polygon.addPoint(new Point(4, 4)); // Point 3
        polygon.addPoint(new Point(1, 4)); // Point 4

        Point p1 = new Point(5, 6);

        System.out.println(polygon.isPointInside(p1));// Point à tester 1

        System.out.println(polygon.distanceToPolygon(p1));    }
}
