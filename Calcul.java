
package Calculer_Distance;

public class Calcul {
    public static double distanceFromPointToPoint(Point p1, Point p2) {
        double distance;
        distance = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        return distance;
    }

    public static double distanceFromPointToLine(Point p, Line l) {
        double distance;
        if (l.belongsToTheLine(p)) {
            distance = 0;
        }
        distance = Math.abs((l.getA() * p.getX()) - p.getY() + l.getB()) / Math.sqrt(Math.pow(l.getA(), 2) + 1);
        return distance;
    }

    public static double distanceFromLineToLine(Line l1, Line l2) {
        double distance;
        if (l1.getA() != l2.getA()) {
            distance = 0;
        } else {
            distance = Math.abs(l1.getB() - l2.getB()) / Math.sqrt(Math.pow(l1.getA(), 2) + 1);
        }
        return distance;
    }



    /**
     * Calculates the shortest distance from a point to a line segment.
     *
     * @param p     The point from which the distance is calculated.
     * @param start The starting point of the segment.
     * @param end   The ending point of the segment.
     * @return The shortest distance from the point to the segment.
     */
    public static double distanceFromPointToSegment(Point p, Point start, Point end) {
        double ABx = end.getX() - start.getX();
        double ABy = end.getY() - start.getY();
        double APx = p.getX() - start.getX();
        double APy = p.getY() - start.getY();

        double produitScalaire = APx * ABx + APy * ABy;
        double longueurABCarre = ABx * ABx + ABy * ABy;

        double t = produitScalaire / longueurABCarre;

        if (t < 0) {
            return distanceFromPointToPoint(p, start);
        } else if (t > 1) {
            return distanceFromPointToPoint(p, end);
        } else {
            double x_proj = start.getX() + t * ABx;
            double y_proj = start.getY() + t * ABy;
            return distanceFromPointToPoint(p, new Point(x_proj, y_proj));
        }
    }
    /**
     * Calculates the shortest distance from a point to a square.
     * This method calculates the distance between the point and each side of the square,
     * then returns the smallest distance.
     *
     * @param p      The point from which the distance is calculated.
     * @param square The square to which the distance is calculated.
     * @return The shortest distance from the point to the square.
     */
    public static double distanceFromPointToSquare(Point p, Carre square) {
        square.getPoints();

        Point A = square.getA();
        Point B = square.getB();
        Point C = square.getC();
        Point D = square.getD();

        double distAB = distanceFromPointToSegment(p, A, B);
        double distBC = distanceFromPointToSegment(p, B, C);
        double distCD = distanceFromPointToSegment(p, C, D);
        double distDA = distanceFromPointToSegment(p, D, A);

        return Math.min(Math.min(distAB, distBC), Math.min(distCD, distDA));
    }

}