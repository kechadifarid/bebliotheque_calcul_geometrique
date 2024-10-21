package Calculer_Distance;

import java.util.ArrayList;

public class PolygonDistanceCalculator {

    // Méthode pour calculer la distance minimale entre deux polygones
    public static double calculateMinDistance(Polygon polygon1, Polygon polygon2) {
        double minDistance = Double.MAX_VALUE;  // On initialise la distance minimale à un maximum possible

        // Vérifier si l'un des polygones contient un point de l'autre
        for (Point p1 : polygon1.getPoints()) {
            if (polygon2.isPointInside(p1)) {
                return 0;  // Les polygones se chevauchent
            }
        }

        for (Point p2 : polygon2.getPoints()) {
            if (polygon1.isPointInside(p2)) {
                return 0;  // Les polygones se chevauchent
            }
        }

        // Si les polygones ne se chevauchent pas, calculer la distance minimale
        for (Point p1 : polygon1.getPoints()) {
            for (Point p2 : polygon2.getPoints()) {
                // Calculer la distance entre les deux points à l'aide de la classe Calcul
                double distance = Calcul.distanceFromPointToPoint(p1, p2);
                // Si la distance est plus petite que la distance minimale actuelle, on la met à jour
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }
}