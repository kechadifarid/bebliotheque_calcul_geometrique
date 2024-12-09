package bibliotheque;
import java.sql.SQLOutput;
import java.util.Random;
import bibliotheque.*;

public class Main {

	public static void main(String[] args) {
		Point p = new Point(0, 0);

		Rectangle rectangle = new Rectangle(8,4,p);
		Random random = new Random();
		double x1= rectangle.getBottom_left().getX()+ random.nextDouble()*rectangle.getWidth();
		double x2= rectangle.getBottom_left().getX()+ random.nextDouble()*rectangle.getWidth();
		double y1 =rectangle.getBottom_left().getY() + random.nextDouble()* rectangle.getLength();
		double y2 =rectangle.getBottom_left().getY() + random.nextDouble()* rectangle.getLength();
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(y1);
		System.out.println(y2);
		Point a = new Point(2,-1);

		Point b = new Point(4,-2);


		Point d =new Point(2,-1);
		System.out.println("la distance est "+ Calcul.distancePointToSegment(d,rectangle.getUpper_left(),rectangle.getUpper_right()));
		System.out.println(Probabilité.findClosestSide(a,rectangle).getP2().getY());
		System.out.println(Calcul.distancePointToSegment(a,rectangle.getUpper_left(),rectangle.getUpper_right()));
		System.out.println(Probabilité.findIntersectionWithPerpendicularBisector(a,b,Probabilité.findClosestSide(a,rectangle)).getX());
	}
}

