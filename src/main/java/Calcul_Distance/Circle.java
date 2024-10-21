package Calcul_Distance;

public class Circle {
    private double radius;
    private Point orgin;

    public Circle(double rayon, Point origin) {
        this.radius = rayon;
        this.orgin = origin;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

	public Point getOrgin() {
		return orgin;
	}

	public void setOrgin(Point orgin) {
		this.orgin = orgin;
	}
}

