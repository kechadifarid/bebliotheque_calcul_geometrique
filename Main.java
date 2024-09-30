package Calculer_Distance;

public class Main {
    public static void main(String[] args) {
        Point A = new Point(1,1);
        Point B = new Point(1,3);
        Point C = new Point(4,3);
        Point D = new Point(4,1);
        Point P = new  Point(5,0);

        Rectangle  r= new Rectangle();
        r.setBottom_left(A);
        r.setUpper_left(B);
        r.setUpper_right(C);
        r.setBottom_right(D);
        Distance d = new Distance();

        System.out.println("c vrai ou non :"+d.isPointInRectangle(P,r));
        System.out.println("la distance est "+ d.distancePointRectangle(P,r));
       ;
    }
}
