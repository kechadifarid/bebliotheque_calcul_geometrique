package Calculer_Distance;

import java.util.ArrayList;
import java.util.List;

class Polygon {
    // Liste des points du polygone
    private ArrayList<Point> points;
    Distance distance = new Distance();

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

    // Méthode pour vérifier si un point est à l'intérieur du polygone
    public boolean isPointInside(Point p) {
        int n = points.size();
        boolean inside = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            Point current = points.get(i);
            Point previous = points.get(j);
            // Vérifier si le segment entre current et previous intersecte le segment entre le point p et une ligne imaginaire
            if ((current.getY() > p.getY()) != (previous.getY() > p.getY()) &&
                    (p.getX() < (previous.getX() - current.getX()) * (p.getY() - current.getY()) / (previous.getY() - current.getY()) + current.getX())) {
                inside = !inside;
            }
        }
        return inside;
    }
    // Méthode pour calculer la distance minimale entre un point et le polygone
    public double distanceToPolygon(Point p) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("Un polygone doit avoir au moins 2 sommets.");
        }
        if (isPointInside(p)) {
            // Si le point est à l'intérieur, retourner la distance négative
            return -1 * minDistanceToEdge(p);
        }
        return minDistanceToEdge(p);
    }
    // Méthode pour calculer la distance minimale au segment
    private double minDistanceToEdge(Point p) {
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % points.size()); // Pour boucler au premier point
            double dist = distance.distancePointToSegment(p, current, next);
            // Vérifier si le point est sur le segment
            if (isPointOnSegment(p, current, next)) {
                return 0.0; // La distance est zéro si le point est sur le segment
            }
            minDistance = Math.min(minDistance, dist);
        }
        return minDistance;
    }
    // Méthode pour vérifier si un point est sur un segment
    private boolean isPointOnSegment(Point p, Point a, Point b) {
        double crossProduct = (p.getY() - a.getY()) * (b.getX() - a.getX()) - (p.getX() - a.getX()) * (b.getY() - a.getY());
        if (Math.abs(crossProduct) > 1e-10) return false; // Vérification de la colinéarité
        double dotProduct = (p.getX() - a.getX()) * (b.getX() - a.getX()) + (p.getY() - a.getY()) * (b.getY() - a.getY());
        if (dotProduct < 0) return false; // p est avant a
        double squaredLengthBA = (b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY());
        if (dotProduct > squaredLengthBA) return false; // p est après b
        return true; // p est sur le segment
    }

}