package Calculer_Distance;

public class DistanceCreclePoint {
	
	public static double calculerDistance(Line ligne, Cercle cercle, Point centreCercle) {
	    double a = ligne.getA();
	    double b = ligne.getB();
	    
	    double x0 = centreCercle.getX();
	    double y0 = centreCercle.getY();
	    
	    double distancePointDroite = Math.abs(a * x0 - y0 + b) / Math.sqrt(a * a + 1);
	    
	    System.out.println("Distance du centre du cercle à la droite : " + distancePointDroite);
	    
	    if (distancePointDroite <= cercle.getRayon()) {
	        return 0;  
	    }
	    if (distancePointDroite < cercle.getRayon()) {
	        return 0;  
	    }
	    
	    double distanceCercleDroite = distancePointDroite - cercle.getRayon();
	    
	    return Math.max(0, distanceCercleDroite);
	}



    

}
