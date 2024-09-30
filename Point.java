package Calculer_Distance;

public class Point {
	private double x, y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
		super();
		this.x = 0;
		this.y = 0;
	}

	public Point(){};

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
