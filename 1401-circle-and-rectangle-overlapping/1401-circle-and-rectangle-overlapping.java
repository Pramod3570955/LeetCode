class Solution {
    public boolean checkOverlap(
            int radius,
            int xCenter,
            int yCenter,
            int x1,
            int y1,
            int x2,
            int y2) {

        // Find the closest point on the rectangle to the circle center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance between circle center and closest rectangle point
        long dx = (long) xCenter - closestX;
        long dy = (long) yCenter - closestY;

        long distanceSquared = dx * dx + dy * dy;
        long radiusSquared = (long) radius * radius;

        // Touching the rectangle also counts as overlap
        return distanceSquared <= radiusSquared;
    }
}