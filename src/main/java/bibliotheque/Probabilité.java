package bibliotheque;

public class Probabilité {

    // Trouver le côté le plus proche du rectangle à partir du point a
    public static Segment findClosestSide(Point a, Rectangle rect) {
        Point ul = rect.getUpper_left();
        Point ur = rect.getUpper_right();
        Point bl = rect.getBottom_left();
        Point br = rect.getBottom_right();

        Segment[] sides = {
                new Segment(ul, ur), // Haut
                new Segment(ur, br), // Droite
                new Segment(bl, br), // Bas
                new Segment(ul, bl)  // Gauche
        };

        double minDistance = Double.MAX_VALUE;
        Segment closestSide = null;

        for (Segment side : sides) {
            double distance = Calcul.distancePointToSegment(a, side.getP1(), side.getP2());
            if (distance < minDistance) {
                minDistance = distance;
                closestSide = side;
            }
        }

        return closestSide;
    }

    public static Point findIntersectionWithPerpendicularBisector(Point a, Point b, Segment side) {
        // Calculer la médiatrice entre a et b
        double midX = (a.getX() + b.getX()) / 2;
        double midY = (a.getY() + b.getY()) / 2;
        Point midpoint = new Point(midX, midY);
        System.out.println(midpoint.getX() + " " + midpoint.getY());
        double perpendicularSlope;
        double slopeAB = (b.getY() - a.getY()) / (b.getX() - a.getX());

        if (slopeAB != 0) {
            System.out.println(slopeAB);
            perpendicularSlope = -1 / slopeAB;
        } else {
            perpendicularSlope = Double.POSITIVE_INFINITY; // La médiatrice est verticale si la ligne est horizontale
        }

        // Equation de la médiatrice: y = perpendicularSlope * x + intercept
        double intercept = midY - perpendicularSlope * midX;

        // Equation du segment (côté du rectangle)
        Point sideStart = side.getP1();
        Point sideEnd = side.getP2();
        double sideSlope = (sideEnd.getY() - sideStart.getY()) / (sideEnd.getX() - sideStart.getX());
        double sideIntercept = sideStart.getY() - sideSlope * sideStart.getX();

        // Résoudre l'intersection des deux lignes
        double intersectX = midX;
        double intersectY;

        if (perpendicularSlope != Double.POSITIVE_INFINITY) {
            // Résoudre l'intersection des deux lignes (cas général)
            intersectX = (sideIntercept - intercept) / (perpendicularSlope - sideSlope);
            intersectY = perpendicularSlope * intersectX + intercept;
        } else {
            // Si la médiatrice est verticale, on utilise directement le x de la médiatrice
            intersectY = sideSlope * intersectX + sideIntercept;
        }

        // Vérifier si l'intersection est dans les limites du segment
        if (intersectX >= Math.min(sideStart.getX(), sideEnd.getX()) &&
                intersectX <= Math.max(sideStart.getX(), sideEnd.getX()) &&
                intersectY >= Math.min(sideStart.getY(), sideEnd.getY()) &&
                intersectY <= Math.max(sideStart.getY(), sideEnd.getY())) {
            return new Point(intersectX, intersectY);
        }

        return null;
    }

    // Calculer la probabilité qu'un point sur le côté soit équidistant de a et b
    public static double calculateProbability(Point a, Point b, Rectangle rect) {
        Segment closestSide = findClosestSide(a, rect);
        Point intersection = findIntersectionWithPerpendicularBisector(a, b, closestSide);

        // Si le point d'intersection existe, la probabilité est 1
        if (intersection != null) {
            return 1.0;
        }

        // Sinon, la probabilité est 0
        return 0.0;
    }
}
