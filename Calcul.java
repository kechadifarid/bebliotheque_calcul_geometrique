
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

	public static double distanceFromPointToCercle(Point p, Circle c) {
		double distance;
		if (c.getRadius() <= Calcul.distanceFromPointToPoint(p, c.getOrgin())) {
			distance = Calcul.distanceFromPointToPoint(p, c.getOrgin()) - c.getRadius();
			return distance;
		} else
			return Calcul.distanceFromPointToPoint(p, c.getOrgin());

	}

	// Méthode pour calculer la distance entre un point et un segment de ligne
	public static double distanceFromPointToSegment(Point p, Point start, Point end) {
		double ABx = end.getX() - start.getX();
		double ABy = end.getY() - start.getY();
		double APx = p.getX() - start.getX();
		double APy = p.getY() - start.getY();

		double produitScalaire = APx * ABx + APy * ABy;
		double longueurABCarre = ABx * ABx + ABy * ABy;

		double t = produitScalaire / longueurABCarre;

		if (t < 0) {
			// Projection avant le début du segment (start), distance entre P et start
			return distanceFromPointToPoint(p, start);
		} else if (t > 1) {
			// Projection après la fin du segment (end), distance entre P et end
			return distanceFromPointToPoint(p, end);
		} else {
			// Projection sur le segment
			double x_proj = start.getX() + t * ABx;
			double y_proj = start.getY() + t * ABy;
			return distanceFromPointToPoint(p, new Point(x_proj, y_proj));
		}
	}

	// Méthode pour calculer la distance entre un point et un carré
	public static double distanceFromPointToSquare(Point p, Square square) {
		// Les points du carré doivent être calculés
		square.getPoints();

		// Récupérer les sommets du carré
		Point A = square.getA();
		Point B = square.getB();
		Point C = square.getC();
		Point D = square.getD();

		// Calculer la distance entre le point et chaque segment du carré
		double distAB = distanceFromPointToSegment(p, A, B);
		double distBC = distanceFromPointToSegment(p, B, C);
		double distCD = distanceFromPointToSegment(p, C, D);
		double distDA = distanceFromPointToSegment(p, D, A);

		// Retourner la distance la plus courte
		return Math.min(Math.min(distAB, distBC), Math.min(distCD, distDA));
	}

}
