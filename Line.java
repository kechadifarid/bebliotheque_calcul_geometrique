package Calculer_distance;

public class Line {

	private double a, b;

	public Line(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public boolean belongsToTheLine(Point p) {
		if(p.getY()==a*p.getX()+b)
		return true;
		else 
			return false;
	}
}
