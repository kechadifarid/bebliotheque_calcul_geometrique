package Calculer_Distance;

import static Calculer_Distance.Carre.distanceCarreCercle;

public class Main {
    public static void main(String[] args) {
        Point pointA = new Point(0, 0);
        Carre monCarre = new Carre(pointA, 5);
        monCarre.getPoints();

        Point centreCercle = new Point(10, 10);
        Cercle monCercle = new Cercle(2, centreCercle);

        double distance = Carre.distanceCarreCercle(monCarre, monCercle);
        System.out.println("La distance entre le carré et le cercle est : " + distance);

        monCarre.setA(new Point(20, 20));
        monCarre.getPoints(); // Recalculer les autres points
        distance = Carre.distanceCarreCercle(monCarre, monCercle);
        System.out.println("Nouvelle distance après déplacement : " + distance);

    }
}



