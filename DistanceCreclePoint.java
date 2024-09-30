package Calculer_distance;

public class DistanceCreclePoint {
	
	public static double calculerDistance(Line ligne, Cercle cercle, Point centreCercle) {
        double a = ligne.getA();
        double b = ligne.getB();
        
        double x0 = centreCercle.getX();
        double y0 = centreCercle.getY();
        
        double distancePointDroite = Math.abs(a * x0 - y0 + b) / Math.sqrt(a * a + 1);
        
        double distanceCercleDroite = distancePointDroite - cercle.getRayon();
        
        return Math.max(0, distanceCercleDroite);
    }

}
