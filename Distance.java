package Calculer_Distance;

public class Distance {

    // Method to check if a point belongs to the rectangle
    public boolean isPointInRectangle(Point P, Rectangle r) {
        // Coordinates of the upper-left corner and bottom-right corner of the rectangle
        double x1 = r.getUpper_left().getX();
        double y1 = r.getUpper_left().getY();
        double x2 = r.getBottom_right().getX();
        double y2 = r.getBottom_right().getY();

        // Coordinates of point P
        double px = P.getX();
        double py = P.getY();

        // Check if the point is within the bounds of the rectangle
        return (px >= x1 && px <= x2 && py <= y1 && py >= y2);
    }

    // Method to calculate the distance between a point and a segment
    public double distancePointToSegment(Point P, Point A, Point B) {
        double px = P.getX();
        double py = P.getY();
        double ax = A.getX();
        double ay = A.getY();
        double bx = B.getX();
        double by = B.getY();

        double ABx = bx - ax;
        double ABy = by - ay;
        double APx = px - ax;
        double APy = py - ay;

        // Calculate the projection scalar t
        double t = (APx * ABx + APy * ABy) / (ABx * ABx + ABy * ABy);

        // Clamp t to the range [0, 1]
        t = Math.max(0, Math.min(1, t));

        // Find the closest point on the segment to P
        double closestX = ax + t * ABx;
        double closestY = ay + t * ABy;

        // Calculate the distance between P and the closest point
        double dx = px - closestX;
        double dy = py - closestY;

        return Math.sqrt(dx * dx + dy * dy);
    }

    // Method to calculate the distance between a point and a rectangle
    public double distancePointRectangle(Point P, Rectangle r) {
        if (isPointInRectangle(P, r)) {
            return 0;
        }

        // Calculate the distances to each side of the rectangle
        double d1 = distancePointToSegment(P, r.getUpper_left(), r.getUpper_right());  // Top side
        double d2 = distancePointToSegment(P, r.getUpper_right(), r.getBottom_right()); // Right side
        double d3 = distancePointToSegment(P, r.getBottom_right(), r.getBottom_left()); // Bottom side
        double d4 = distancePointToSegment(P, r.getBottom_left(), r.getUpper_left());   // Left side

        // Return the minimum distance
        return Math.min(Math.min(d1, d2), Math.min(d3, d4));
    }



}