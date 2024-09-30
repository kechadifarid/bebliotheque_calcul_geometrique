package Calculer_Distance;

import java.io.IOException;

public class Rectangle {
    private double lenght;
    private double width;
    private Point upper_left;
    private Point upper_right;
    private Point bottom_left;
    private Point bottom_right;

    private double x;
    private double y;


    public Rectangle(){
        this.upper_right = new Point();
        this.bottom_right = new Point();
        this.upper_left = new Point();
        this.bottom_left = new Point();
    };

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

    public void setLenght(double lenght) throws NoCoordException {
        this.lenght = lenght;
        if(getX()==0 || getY()==0)  throw new NoCoordException("Renseignez les coordonnées");

        upper_right.setX(getX()+lenght);
        upper_right.setY(getY());
    }

    public void setWidth(double width) throws NoCoordException {
        this.width = width;
        if(getX()==0 || getY()==0)  throw new NoCoordException("Renseignez les coordonnées");
            bottom_left.setY(getY() - width);
            bottom_left.setX(getX());
            bottom_right.setX(upper_right.getX());
            bottom_right.setY(bottom_left.getY());



    }

    public void setX(double x) {
        this.x = x;
        upper_left.setX(x);
    }

    public void setY(double y) {
        this.y = y;
        upper_left.setY(y);
    }
}
