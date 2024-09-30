package Calculer_distance;

public class DistanceDroiteCarr {

	 public static double calculerDistance(Line ligne, Carre carre) {
	        double a = ligne.getA();
	        double b = ligne.getB();
	        
	        Point[] sommets = new Point[]{carre.getA(), carre.getB(), carre.getC(), carre.getD()};

	        double distanceMinimale = Double.MAX_VALUE;

	        for (Point sommet : sommets) {
	            double x = sommet.getX();
	            double y = sommet.getY();
	            double distance = Math.abs(a * x - y + b) / Math.sqrt(a * a + 1);
	            distanceMinimale = Math.min(distanceMinimale, distance);
	        }

	        return distanceMinimale;
	    }
}
