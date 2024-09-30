package Calculer_Distance;

public class Carre {
    public Carre(Point A , double distance) {
        this.A = A;
        this.length = distance;
    }
    Point A;

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    public Point getD() {
        return D;
    }

    public void setD(Point d) {
        D = d;
    }

    Point B;
    Point C;
    Point D;
    double length;
    public Point getA() {
    return A;
    }
    public void setA(Point A) {
        this.A = A;
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public void getPoints()
    {

        //Point B
        double x1 = A.getX() + length;
        B = new Point(x1,A.getY());

        //Point C
        double y2 = B.getY() + length;

        C = new Point(B.getX(),y2);

        //Point D
        double x2 =  C.getX() - length;

        D = new Point(x2, C.getY());

        //affichage de point
        System.out.println("Point A : ("+A.getX()+","+A.getY()+") \n"
                +"Point B : ("+B.getX()+","+B.getY()+") \n"+
                "Point C : ("+C.getX()+","+C.getY()+") \n"+
                "Point D : ("+D.getX()+","+D.getY()+") \n"

        );

   ; }

    public static double distanceCarreCercle(Carre carre, Cercle cercle) {
        Point origineCercle = cercle.getOrigin();
        double rayonCercle = cercle.getRadius();
        Point A = carre.getA();
        Point B = carre.getB();
        Point C = carre.getC();
        Point D = carre.getD();

        double xCercle = origineCercle.getX();
        double yCercle = origineCercle.getY();

        double xClosest = clamp(xCercle, A.getX(), B.getX());
        double yClosest = clamp(yCercle, A.getY(), D.getY());

        double distanceCentreToClosest = distance(origineCercle, new Point(xClosest, yClosest));
        double distanceSurfaceToSurface = distanceCentreToClosest - rayonCercle;

        return Math.max(0, distanceSurfaceToSurface);
    }
    // Méthode auxiliaire pour restreindre une valeur entre un minimum et un maximum
    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }

    // Méthode pour calculer la distance entre deux points
    private static double distance(Point p1, Point p2) {
        double deltaX = p1.getX() - p2.getX();
        double deltaY = p1.getY() - p2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


}
