package Calculer_Distance;

public class Test {

	public static void main(String[] args) {
		{

			Point p1 = new Point(2, 1);
			Point p2 = new Point(3, 1);
			Line l1 = new Line(3, -4);
			Line l2 = new Line(3, 5);
			Circle c1 = new Circle(3, p1);
			Circle c2 = new Circle(4, p2);

			double distance = Calcul.distanceFromPointToPoint(p1, p2);
			System.out.println("The distance between p1 and p2 is: " + distance);
			double distance2 = Calcul.distanceFromPointToLine(p1, l1);
			System.out.println("The distance between l1 and p1 is: " + distance2);
			double distance3 = Calcul.distanceFromLineToLine(l2, l1);
			System.out.println("The distance between l1 and l2 is: " + distance3);
			double distance4 = Calcul.distanceFromPointToCercle(p2, c1);
			System.out.println("The distance between c1 and p2 is: " + distance4);

			Point A = new Point(1, 1);
			double length = 4.0;
			Square square = new Square(A, length);

			// Point for which we want to calculate the distance
			Point point = new Point(0, 0);

			// Calculating the distance
			double distance5 = Calcul.distanceFromPointToSquare(point, square);

			// Displaying the distance
			System.out.println("Distance between the point and the square: " + distance5);

			// Point A = new Point(1, 1);
			Point B = new Point(1, 3);
			Point C = new Point(4, 3);
			Point D = new Point(4, 1);
			Point P = new Point(5, 0);

			Rectangle r = new Rectangle();
			r.setBottom_left(A);
			r.setUpper_left(B);
			r.setUpper_right(C);
			r.setBottom_right(D);
			System.out.println("Is it true or false: " + Calcul.isPointInRectangle(P, r));
			System.out.println("The distance is: " + Calcul.distancePointRectangle(P, r));

			Point pointA = new Point(0, 0);
			Square mySquare = new Square(pointA, 5);
			mySquare.getPoints();

			Point circleCenter = new Point(10, 10);
			Circle myCircle = new Circle(2, circleCenter);

			distance = Calcul.distanceCarreCercle(mySquare, myCircle);
			System.out.println("The distance between the square and the circle is: " + distance);

			mySquare.setA(new Point(20, 20));
			mySquare.getPoints(); // Recalculate the other points
			distance = Calcul.distanceCarreCercle(mySquare, myCircle);
			System.out.println("New distance after moving: " + distance);
		}

		{
			Point p1 = new Point(0, 0);
			Point p2 = new Point(5, 5);
			Line line = new Line(3, 27); // Droite : x - y = 0 (x = y)
			Polygon polygon = new Polygon();
			polygon.addPoint(new Point(0, 0));
			polygon.addPoint(new Point(4, 0));
			polygon.addPoint(new Point(4, 3));
			polygon.addPoint(new Point(0, 3));
			double distance = Calcul.distanceFromLineToPolygon(line, polygon);
			System.out.println("Distance minimale entre la droite et le polygone : " + distance);
		}

		{
			//TEST distance entre un point et un polygant
			Polygon polygon = new Polygon();
			polygon.addPoint(new Point(1, 1)); // Point 1
			polygon.addPoint(new Point(4, 1)); // Point 2
			polygon.addPoint(new Point(4, 4)); // Point 3
			polygon.addPoint(new Point(1, 4)); // Point 4
			Point p1 = new Point(5, 6);
			System.out.println(polygon.isPointInside(p1));// Point à tester 1
		}

		{
			Polygon polygon0 = new Polygon();
			polygon0.addPoint(new Point(1, 2));
			polygon0.addPoint(new Point(3, 4));
			polygon0.addPoint(new Point(5, 6));
			Polygon polygon00 = new Polygon();
			polygon00.addPoint(new Point(7, 8));
			polygon00.addPoint(new Point(9, 10));
			polygon00.addPoint(new Point(11, 12));
			// Utilisation de la classe PolygonDistanceCalculator pour calculer la distance minimale
			double distanc = PolygonDistanceCalculator.calculateMinDistance(polygon0, polygon00);
			System.out.println("La distance minimale entre les deux polygones est : " + distanc);
			// Créer le premier polygone (triangle)
			Polygon polygon1 = new Polygon();
			polygon1.addPoint(new Point(0, 0));
			polygon1.addPoint(new Point(4, 0));
			polygon1.addPoint(new Point(2, 3));
			// Créer le deuxième polygone (quadrilatère)
			Polygon polygon2 = new Polygon();
			polygon2.addPoint(new Point(5, 1));
			polygon2.addPoint(new Point(7, 1));
			polygon2.addPoint(new Point(6, 4));
			polygon2.addPoint(new Point(4, 4));
			// Calculer la distance minimale entre les deux polygones
			double minDistance = PolygonDistanceCalculator.calculateMinDistance(polygon1, polygon2);
			// Afficher le résultat
			if (minDistance == 0) {
				System.out.println("Les deux polygones se chevauchent.");
			} else {
				System.out.println("La distance minimale entre les deux polygones est : " + minDistance);
			}
			// Test supplémentaire : Deux polygones qui se chevauchent
			Polygon polygon3 = new Polygon();
			polygon3.addPoint(new Point(1, 1));
			polygon3.addPoint(new Point(3, 1));
			polygon3.addPoint(new Point(2, 2));
			double overlapDistance = PolygonDistanceCalculator.calculateMinDistance(polygon1, polygon3);
			if (overlapDistance == 0) {
				System.out.println("Les polygones 1 et 3 se chevauchent.");
			} else {
				System.out.println("La distance minimale entre les polygones 1 et 3 est : " + overlapDistance);
			}
		}


	}
}

