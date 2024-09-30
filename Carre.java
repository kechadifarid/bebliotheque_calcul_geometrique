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
}
