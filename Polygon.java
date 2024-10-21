package Calculer_Distance;

import java.util.ArrayList;
import java.util.List;

class Polygon {
    // Liste des points du polygone
    private ArrayList<Point> points;

    // Constructeur pour initialiser un polygone vide
    public Polygon() {
        points = new ArrayList<Point>();
    }

    // Méthode pour ajouter un point (sommet) au polygone
    public void addPoint(Point p) {
        points.add(p);
    }
    public List<Point> getVertices() {
        return points;
    }

    // Méthode pour obtenir le nombre de sommets du polygone
    public int getNumberOfPoints() {
        return points.size();
    }
}