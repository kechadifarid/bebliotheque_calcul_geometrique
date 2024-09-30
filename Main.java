package Calculer_distance;

public class Main {

	public static void main(String[] args) {
        Cercle cercle = new Cercle(3.0);
        Point centreCercle = new Point(1, 2);

        Line ligne = new Line(0.5, 6);

        double distance = DistanceCreclePoint.calculerDistance(ligne, cercle, centreCercle);

        System.out.println("Distance entre la droite et le cercle : " + distance);
	}

}
