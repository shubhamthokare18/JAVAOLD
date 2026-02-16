package com.example.brickbreaker;


public class Utils {
    // simple rectangle-circle collision
    public static boolean rectCircleCollision(double rx, double ry, double rw, double rh,
                                              double cx, double cy, double cr) {
// find closest point to circle center within rectangle
        double closestX = clamp(cx, rx, rx + rw);
        double closestY = clamp(cy, ry, ry + rh);


        double dx = cx - closestX;
        double dy = cy - closestY;


        return (dx * dx + dy * dy) <= (cr * cr);
    }


    private static double clamp(double val, double min, double max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }
}