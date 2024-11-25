package bibliotheque;

/**
 * La classe Triangle représente un polygone avec exactement trois sommets.
 * Elle hérite de la classe Polygon.
 */
class Triangle extends Polygon {

    /**
     * Constructeur pour créer un triangle à partir de trois sommets.
     *
     * @param p1 le premier sommet du triangle
     * @param p2 le deuxième sommet du triangle
     * @param p3 le troisième sommet du triangle
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(); // Appelle le constructeur par défaut de Polygon

        /*
        //affichage de point
        System.out.println("Point p1 : ("+p1.getX()+","+p1.getY()+") \n"
                +"Point p2 : ("+p2.getX()+","+p2.getY()+") \n"+
                "Point p3 : ("+p3.getX()+","+p3.getY()+") \n"
        );
        */

        addPoint(p1);
        addPoint(p2);
        addPoint(p3);
    }

    /**
     * Vérifie si le triangle est valide (les trois sommets ne sont pas colinéaires).
     *
     * @return true si le triangle est valide, false sinon
     */
    public boolean isValid() {
        if (getNumberOfPoints() != 3) {
            return false; // Un triangle doit avoir exactement 3 sommets
        }

        Point p1 = getPoints().get(0);
        Point p2 = getPoints().get(1);
        Point p3 = getPoints().get(2);

        // Calcul du déterminant pour vérifier la colinéarité
        double determinant = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) -
                (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
        return Math.abs(determinant) > 1e-10; // Si proche de 0, les points sont colinéaires
    }
}
