package Calcul_Distance;

import java.util.ArrayList;
import java.util.List;

public  class Rectangle extends Polygon {
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
        this.add(upper_left);
        this.bottom_right = new Point();
        this.add(bottom_right);
        this.upper_left = new Point();
        this.add(upper_left);
        this.bottom_left = new Point();
        this.add(bottom_left);
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

    @Override
    public boolean add(Point point) throws NoCoordException {

        if(super.size() ==4) throw new NoCoordException("Limite de points atteint");
        return super.add(point);
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

        /*
        Point p1 = new Point(2, 1);
		Point p2 = new Point(3, 1);
		Line l1 = new Line(3, -4);
		Line l2 = new Line(3, 5);
		Circle c1 = new Circle(3, p1);
		Circle c2 = new Circle(4, p2);

		double distance = Calcul.distanceFromPointToPoint(p1, p2);
		System.out.println("la distance entre p1 et p2 est : " + distance);
		double distance2 = Calcul.distanceFromPointToLine(p1, l1);
		System.out.println("la distance entre l1 et p1 est : " + distance2);
		double distance3 = Calcul.distanceFromLineToLine(l2, l1);
		System.out.println("la distance entre l1 et l2 est : " + distance3);
		double distance4 = Calcul.distanceFromPointToCercle(p2, c1);
		System.out.println("la distance entre c1 et p2 est : " + distance4);

		 Point A = new Point(1, 1);
	        double length = 4.0;
	        Square square = new Square(A, length);

	        // Point pour lequel on veut calculer la distance
	        Point point = new Point(0, 0);

	        // Calcul de la distance
	        double distance5 = Calcul.distanceFromPointToSquare(point, square);

	        // Affichage de la distance
	        System.out.println("Distance entre le point et le carré : " + distance5);
*/
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 5);
        Line line = new Line(3, 27); // Droite : x - y = 0 (x = y)
        Rectangle r1 = new Rectangle();
        r1.add(new Point(0,0));
        r1.setData(4,2);
        Polygon polygon = new Polygon();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(4, 0));
        polygon.add(new Point(4, 3));
        polygon.add(new Point(0, 3));

        double distance = Calcul.distanceFromLineToPolygon(line, polygon);
        System.out.println("Distance minimale entre la droite et le polygone : " + distance);

        /*Line l1 = new Line(0, 2);
        Rectangle r1 = new Rectangle();
        r1.setX(2);
        r1.setY(2);
        r1.setData(2, 2);
         System.out.println("rectangle coordinates:");
         System.out.println("Top left corner: " + r1.getUpper_left().toString());
         System.out.println("Top right corner: " + r1.getUpper_right().toString());
         System.out.println("Bot left corner: " + r1.getBottom_left().toString());
         System.out.println("Bot right corner: " + r1.getBottom_right().toString());
         System.out.println("---------------------------");
        r1.calculPointToRectangle(l1);
        for (Segment segment : r1.getSegments()) {
            if(r1.calculDist(l1, segment)){
                r1.setDist(0);
            }
        }*/
    }
}
