
package Calculer_Distance;

import java.util.List;

public class Calcul {

	/**
	 * Calculates the shortest distance from a point to a line segment.
	 *
	 * @param p1     The point from which the distance is calculated.
	 * @param p2   The ending point from which the distance is calculated.
	 * @return The distance between the two points
	 */
	public static double distanceFromPointToPoint(Point p1, Point p2) {
		double distance;
		distance = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
		return distance;
	}

	/**
	 * Calculates the shortest distance from a point to a line segment.
	 *
	 * @param p     The point from which the distance is calculated.
	 * @param l   The line from which we will calculate the distance
	 * @return The shortest distance between the point and the line
	 */
	public static double distanceFromPointToLine(Point p, Line l) {
		double distance;
		if (l.belongsToTheLine(p)) {
			distance = 0;
		}
		distance = Math.abs((l.getA() * p.getX()) - p.getY() + l.getB()) / Math.sqrt(Math.pow(l.getA(), 2) + 1);
		return distance;
	}

	/**
	 * Calculates the shortest distance from a point to a line segment.
	 *
	 * @param l1     The line  from which the distance is calculated.
	 * @param l2   The line from which we will calculate the distance
	 * @return The shortest distance between both lines.
	 */
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
	 * @param  p   The point from which the distance is calculated.
	 * @param c   The circle from which we will calculate the distance
	 * @return The shortest distance between the circle and the point. (from the CIRCLE, not from its center)
	 */
	public static double distanceFromPointToCercle(Point p, Circle c) {
		double distance;
		if (c.getRadius() <= Calcul.distanceFromPointToPoint(p, c.getOrgin())) {
			distance = Calcul.distanceFromPointToPoint(p, c.getOrgin()) - c.getRadius();
			return distance;
		} else
			return Calcul.distanceFromPointToPoint(p, c.getOrgin());

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
	public static double distanceFromPointToSquare(Point p, Square square) {
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

	// Method to check if a point belongs to the rectangle
	public static boolean isPointInRectangle(Point P, Rectangle r) {
		// Coordinates of the upper-left corner and bottom-right corner of the rectangle
		double x1 = r.getUpper_left().getX();
		double y1 = r.getUpper_left().getY();
		double x2 = r.getBottom_right().getX();
		double y2 = r.getBottom_right().getY();

		// Coordinates of point P
		double px = P.getX();
		double py = P.getY();

		// Check if the point is within the bounds of the rectangle
		return (px >= x1 && px <= x2 && py <= y1 && py >= y2);
	}

	// Method to calculate the distance between a point and a segment
	public static double distancePointToSegment(Point P, Point A, Point B) {
		double px = P.getX();
		double py = P.getY();
		double ax = A.getX();
		double ay = A.getY();
		double bx = B.getX();
		double by = B.getY();

		double ABx = bx - ax;
		double ABy = by - ay;
		double APx = px - ax;
		double APy = py - ay;

		// Calculate the projection scalar t
		double t = (APx * ABx + APy * ABy) / (ABx * ABx + ABy * ABy);

		// Clamp t to the range [0, 1]
		t = Math.max(0, Math.min(1, t));

		// Find the closest point on the segment to P
		double closestX = ax + t * ABx;
		double closestY = ay + t * ABy;

		// Calculate the distance between P and the closest point
		double dx = px - closestX;
		double dy = py - closestY;

		return Math.sqrt(dx * dx + dy * dy);
	}

	// Method to calculate the distance between a point and a rectangle
	public static double distancePointRectangle(Point P, Rectangle r) {
		if (isPointInRectangle(P, r)) {
			return 0;
		}

		// Calculate the distances to each side of the rectangle
		double d1 = distancePointToSegment(P, r.getUpper_left(), r.getUpper_right());  // Top side
		double d2 = distancePointToSegment(P, r.getUpper_right(), r.getBottom_right()); // Right side
		double d3 = distancePointToSegment(P, r.getBottom_right(), r.getBottom_left()); // Bottom side
		double d4 = distancePointToSegment(P, r.getBottom_left(), r.getUpper_left());   // Left side

		// Return the minimum distance
		return Math.min(Math.min(d1, d2), Math.min(d3, d4));
	}



	public static double distanceCarreCercle(Square carre, Circle cercle) {
		Point origineCercle = cercle.getOrgin();
		double rayonCercle = cercle.getRadius();
		Point A = carre.getA();
		Point B = carre.getB();
		Point C = carre.getC();
		Point D = carre.getD();

		double xCercle = origineCercle.getX();
		double yCercle = origineCercle.getY();

		double xClosest = clamp(xCercle, A.getX(), B.getX());
		double yClosest = clamp(yCercle, A.getY(), D.getY());

		double distanceCentreToClosest = distance(origineCercle, new Point(xClosest, yClosest));
		double distanceSurfaceToSurface = distanceCentreToClosest - rayonCercle;

		return Math.max(0, distanceSurfaceToSurface);
	}
	// Méthode auxiliaire pour restreindre une valeur entre un minimum et un maximum
	private static double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(value, max));
	}

	// Méthode pour calculer la distance entre deux points
	private static double distance(Point p1, Point p2) {
		double deltaX = p1.getX() - p2.getX();
		double deltaY = p1.getY() - p2.getY();
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}
	public static double distancePolygonCircle(Polygon polygon, Circle circle) {
		// Récupérer les points du polygone
		List<Point> vertices = polygon.getVertices();
		Point circleCenter = circle.getOrgin();
		double circleRadius = circle.getRadius();

		// Initialiser la distance minimale avec un très grand nombre
		double minDistance = Double.MAX_VALUE;

		// Parcourir tous les segments du polygone
		for (int i = 0; i < vertices.size(); i++) {
			// Obtenir le point de départ et de fin de chaque segment
			Point start = vertices.get(i);
			Point end = vertices.get((i + 1) % vertices.size()); // Utilisation du modulo pour boucler

			// Calculer la distance entre le centre du cercle et le segment du polygone
			double distanceToSegment = distanceFromPointToSegment(circleCenter, start, end);

			// Trouver la distance entre la surface du cercle et le segment
			double distanceToSurface = distanceToSegment - circleRadius;

			// Mettre à jour la distance minimale
			minDistance = Math.min(minDistance, distanceToSurface);
		}

		// Si le cercle touche ou chevauche le polygone, la distance est 0
		return Math.max(0, minDistance);
	}




}
