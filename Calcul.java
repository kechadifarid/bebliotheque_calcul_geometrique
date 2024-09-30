package Calculer_Distance;

public class Calcul {
	public static double distanceFromPointToPoint(Point p1, Point p2) {
		double distance;
		distance = Math.sqrt(Math.pow(p1.getX() + p2.getX(), 2) + Math.pow(p1.getY() + p2.getY(), 2));
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
		distance= Calcul.distanceFromPointToPoint(p,c.getOrgin()) - c.getRadius();
		return distance;
	}


}
