package Calculer_Distance;

public class Test {

	public static void main(String[] args) {
		/*Point p1 = new Point(2, 1);
		Point p2 = new Point(3, 1);
		Line l1 = new Line(3, -4);
		Line l2 = new Line(3, 5);
		Circle c1 = new Circle(3, p1);
		Circle c2 = new Circle(4, p2);
		
		double distance = Calcul.distanceFromPointToPoint(p1, p2);
		System.out.println("la distance entre p1 et p2 est : " + distance);
		double distance2 = Calcul.distanceFromPointToLine(p1, l1);
		System.out.println("la distance entre l1 et p1 est : " + distance2);
		double distance3 = Calcul.distanceFromLineToLine(l2, l1);
		System.out.println("la distance entre l1 et l2 est : " + distance3);
		double distance4 = Calcul.distanceFromPointToCercle(p2, c1);
		System.out.println("la distance entre c1 et p2 est : " + distance4);
		
		 Point A = new Point(1, 1);
	        double length = 4.0;
	        Square square = new Square(A, length);

	        // Point pour lequel on veut calculer la distance
	        Point point = new Point(0, 0);

	        // Calcul de la distance
	        double distance5 = Calcul.distanceFromPointToSquare(point, square);

	        // Affichage de la distance
	        System.out.println("Distance entre le point et le carré : " + distance5);
*/
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


	}

