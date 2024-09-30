package Calculer_Distance;

public class Test {

	public static void main(String[] args) {

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
}

