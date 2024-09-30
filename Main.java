package Calculer_distance;

public class Main {

    public static void main(String[] args) {
    	
        Cercle cercle1 = new Cercle(3.0);
        Point centreCercle1 = new Point(1, 2);
        Line ligne1 = new Line(0.5, 3);

        double distance1 = DistanceCreclePoint.calculerDistance(ligne1, cercle1, centreCercle1);
        System.out.println("Test 1 - La droite traverse le cercle : " + distance1);

        Cercle cercle2 = new Cercle(2.0);
        Point centreCercle2 = new Point(0, 0);
        Line ligne2 = new Line(1, 5);

        double distance2 = DistanceCreclePoint.calculerDistance(ligne2, cercle2, centreCercle2);
        System.out.println("Test 2 - La droite est à l'extérieur du cercle : " + distance2);

        Cercle cercle3 = new Cercle(1.0);
        Point centreCercle3 = new Point(2, 2);
        Line ligne3 = new Line(1, -1);

        double distance3 = DistanceCreclePoint.calculerDistance(ligne3, cercle3, centreCercle3);
        System.out.println("Test 3 - La droite est tangente au cercle : " + distance3);

        Cercle cercle4 = new Cercle(4.0);
        Point centreCercle4 = new Point(0, 0);
        Line ligne4 = new Line(1, 0);

        double distance4 = DistanceCreclePoint.calculerDistance(ligne4, cercle4, centreCercle4);
        System.out.println("Test 4 - La droite passe par le centre du cercle : " + distance4);
        
        //////////////////////////////////////////////////////////////////////////////////////////
        Line ligne = new Line(0.5, 3);

        Point A = new Point(0, 0);
        Carre carre = new Carre(A, 4);
        carre.getPoints();  
        
        double distance = DistanceDroiteCarr.calculerDistance(ligne, carre);

        System.out.println("Distance minimale entre la droite et le carré : " + distance);
        
        
        Line lig = new Line(-1, 0);

        Point B = new Point(0, 0);
        Carre carre1 = new Carre(B, 4);
        carre1.getPoints();  

        double dis = DistanceDroiteCarr.calculerDistance(lig, carre1);

        System.out.println("Distance minimale entre la droite et le carré : " + dis);
        
      
        
    }
}

