package Calculer_Distance;

public class Rectangle {
    private double lenght;
    private double width;

    public Point getUpper_left() {
        return upper_left;
    }

    public void setUpper_left(Point upper_left) {
        this.upper_left = upper_left;
    }

    public Point getUpper_right() {
        return upper_right;
    }

    public void setUpper_right(Point upper_right) {
        this.upper_right = upper_right;
    }

    public Point getBottom_left() {
        return bottom_left;
    }

    public void setBottom_left(Point bottom_left) {
        this.bottom_left = bottom_left;
    }

    public Point getBottom_right() {
        return bottom_right;
    }

    public void setBottom_right(Point bottom_right) {
        this.bottom_right = bottom_right;
    }

    public Point upper_left;
    public Point upper_right;
    public Point bottom_left;
    public Point bottom_right;

    private double x;
    private double y;


    public Rectangle(){
        this.upper_right = new Point();
        this.bottom_right = new Point();
        this.upper_left = new Point();
        this.bottom_left = new Point();
    }

    public double getLenght() {
        return lenght;
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
        if(getX()==0 || getY()==0)  throw new NoCoordException("Renseignez les coordonnées");
        upper_right.setX(getX()+lenght);
        upper_right.setY(getY());
        bottom_left.setY(getY() - width);
        bottom_left.setX(getX());
        bottom_right.setX(upper_right.getX());
        bottom_right.setY(bottom_left.getY());
        Segment s1 = new Segment(upper_left,upper_right);
        Segment s2 = new Segment(upper_left,bottom_left);
        Segment s3 = new Segment(bottom_left,bottom_right);
        Segment s4 = new Segment(upper_right,bottom_right);



    }

    public void setX(double x) {
        this.x = x;
        upper_left.setX(x);
    }

    public void setY(double y) {
        this.y = y;
        upper_left.setY(y);
    }
     public static void main(String[] args) {

    }
}
