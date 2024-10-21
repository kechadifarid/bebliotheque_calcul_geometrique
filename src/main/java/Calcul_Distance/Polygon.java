package Calcul_Distance;

import java.util.ArrayList;

class Polygon {
    private ArrayList<Point> points;

    // Constructeur pour initialiser un polygone vide
    public Polygon() {
        points = new ArrayList<Point>();
    }

    // Constructeur pour créer un polygone régulier avec un nombre de côtés
    public Polygon(int numberOfSides, double radius, Point center) {
        points = new ArrayList<Point>();

        // Générer les points du polygone régulier
        for (int i = 0; i < numberOfSides; i++) {
            // Calculer l'angle pour chaque sommet
            double angle = 2 * Math.PI * i / numberOfSides;
            // Calculer les coordonnées du point en fonction de l'angle et du rayon
            double x = center.getX() + radius * Math.cos(angle);
            double y = center.getY() + radius * Math.sin(angle);
            // Ajouter le point au polygone
            points.add(new Point(x, y));
        }
    }

    // Méthode pour ajouter un point (sommet) au polygone
    public void addPoint(Point p) {
        points.add(p);
    }

    // Méthode pour obtenir le nombre de sommets du polygone
    public int getNumberOfPoints() {
        return points.size();
    }

    // Méthode pour calculer la longueur de chaque côté du polygone
    public ArrayList<Double> getSideLengths() {
        ArrayList<Double> sideLengths = new ArrayList<>();

        if (points.size() < 2) {
            return sideLengths; // Pas assez de points pour calculer des côtés
        }

        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size()); // Boucle avec le premier point
            double distance = Calcul.distanceFromPointToPoint(p1, p2);
            sideLengths.add(distance);
        }

        return sideLengths;
    }
    public ArrayList<Point> getPoints() {
        return points;
    }

}