package com.example.brickbreaker;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Paddle {
    private double x;
    private final double y;
    private final double width;
    private final double height;
    private final double worldWidth;


    private boolean movingLeft = false;
    private boolean movingRight = false;
    private final double speed = 400; // px per second


    public Paddle(double x, double y, double width, double height, double worldWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.worldWidth = worldWidth;
    }


    public void update(double dt) {
        if (movingLeft && !movingRight) {
            x -= speed * dt;
        } else if (movingRight && !movingLeft) {
            x += speed * dt;
        }


// clamp
        if (x < 0) x = 0;
        if (x + width > worldWidth) x = worldWidth - width;
    }


    public void render(GraphicsContext gc) {
        gc.setFill(Color.web("#ffcc00"));
        gc.fillRect(x, y, width, height);
    }


    // getters / setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public void setMovingLeft(boolean m) { movingLeft = m; }
    public void setMovingRight(boolean m) { movingRight = m; }
}