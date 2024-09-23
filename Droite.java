package Calculer_Distance;

public class Droite {
	private double a, b;

	public Droite(double a, double b) {
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

	public boolean appertientALaDroite(Point p) {
		if(p.getY()==a*p.getX()+b)
		return true;
		else 
			return false;
	}
}
