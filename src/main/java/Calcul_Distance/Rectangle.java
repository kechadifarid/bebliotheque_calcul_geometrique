package Calcul_Distance;

import java.util.ArrayList;
import java.util.List;

public  class Rectangle {
    private double lenght;
    private double width;
    private Point upper_left;
    private Point upper_right;
    private Point bottom_left;
    private Point bottom_right;

    private double x;
    private double y;
    private double dist;
    private List<Segment> segments;

    private Segment top;
    private Segment bot;
    private Segment left;
    private Segment right;



    public Rectangle(){
        this.upper_right = new Point();
        this.bottom_right = new Point();
        this.upper_left = new Point();
        this.bottom_left = new Point();
        segments = new ArrayList<>();
    }

    public double getLenght() {
        return lenght;
    }

    public void calculPointToRectangle(Line l){
        System.out.println(Math.abs(l.getA() * upper_left.getX() - upper_left.getY() + l.getB()) / Math.sqrt(l.getA() *l.getA() +1));
        System.out.println("-----------------------------");
        System.out.println(Math.abs(l.getA() * upper_right.getX() - upper_right.getY() + l.getB()) / Math.sqrt(l.getA() *l.getA() +1));
        System.out.println("-----------------------------");
        System.out.println(Math.abs(l.getA() * bottom_left.getX() - bottom_left.getY() + l.getB()) / Math.sqrt(l.getA() *l.getA() +1));
        System.out.println("-----------------------------");
        System.out.println(Math.abs(l.getA() * bottom_right.getX() - bottom_right.getY() + l.getB()) / Math.sqrt(l.getA() *l.getA() +1));
        System.out.println("-----------------------------");
    }

    public boolean calculDist(Line l, Segment segment) {
        System.out.println("Vérification du segment: " + segment.toString());
        System.out.println("Équation de la ligne: y = " + l.getA() + "x + " + l.getB());

        double segmentSlope = (segment.getP2().getY() - segment.getP1().getY()) / (segment.getP2().getX() - segment.getP1().getX());
        double denominator = l.getA() - segmentSlope;

        System.out.println("Pente du segment: " + segmentSlope);
        System.out.println("Dénominateur: " + denominator);

        if (Math.abs(denominator) < 1e-10) {
            System.out.println("Lignes parallèles ou coïncidentes");
            return false;
        }

        double x_intersect = (segment.getP1().getY() - segment.getP2().getY() + (l.getA() * segment.getP2().getX()) - (l.getA() * segment.getP1().getX())) / denominator;
        double y_intersect = l.getA() * x_intersect + l.getB();

        System.out.println("Point d'intersection calculé: (" + x_intersect + ", " + y_intersect + ")");

        boolean isOnSegment = (Math.min(segment.getP1().getX(), segment.getP2().getX()) <= x_intersect &&
                x_intersect <= Math.max(segment.getP1().getX(), segment.getP2().getX())) &&
                (Math.min(segment.getP1().getY(), segment.getP2().getY()) <= y_intersect &&
                        y_intersect <= Math.max(segment.getP1().getY(), segment.getP2().getY()));

        System.out.println("Le point est sur le segment: " + isOnSegment);
        System.out.println("--------------------");

        return isOnSegment;

    }


    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setData(double lenght, double width) throws NoCoordException {
        this.lenght = lenght;
        this.width = width;
        //if(getX() == null || getY()=null)  throw new NoCoordException("Renseignez les coordonnées");
        upper_right.setX(getX()+lenght);
        upper_right.setY(getY());
        bottom_left.setY(getY() - width);
        bottom_left.setX(getX());
        bottom_right.setX(upper_right.getX());
        bottom_right.setY(bottom_left.getY());
        top = new Segment(upper_left,upper_right);
        left = new Segment(upper_left,bottom_left);
        bot = new Segment(bottom_left,bottom_right);
        right = new Segment(upper_right,bottom_right);
        segments.add(top);
        segments.add(bot);
        segments.add(right);
        segments.add(left);

    }

    public Segment getBot() {
        return bot;
    }

    public Segment getLeft() {
        return left;
    }

    public Segment getRight() {
        return right;
    }

    public Segment getTop() {
        return top;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Point getUpper_left() {
        return upper_left;
    }

    public Point getBottom_right() {
        return bottom_right;
    }

    public Point getBottom_left() {
        return bottom_left;
    }

    public Point getUpper_right() {
        return upper_right;
    }

    public void setX(double x) {
        this.x = x;
        upper_left.setX(x);
    }
    public void setDist(double dist) {
        this.dist=dist;
    }

    public void setY(double y) {
        this.y = y;
        upper_left.setY(y);
    }
    public static void main(String[] args) {
        Line l1 = new Line(0, 2);
        Rectangle r1 = new Rectangle();
        r1.setX(2);
        r1.setY(2);
        r1.setData(2, 2);
         /*System.out.println("rectangle coordinates:");
         System.out.println("Top left corner: " + r1.getUpper_left().toString());
         System.out.println("Top right corner: " + r1.getUpper_right().toString());
         System.out.println("Bot left corner: " + r1.getBottom_left().toString());
         System.out.println("Bot right corner: " + r1.getBottom_right().toString());
         System.out.println("---------------------------");*/
        r1.calculPointToRectangle(l1);
        for (Segment segment : r1.getSegments()) {
            if(r1.calculDist(l1, segment)){
                r1.setDist(0);
            }
        }
    }
}
