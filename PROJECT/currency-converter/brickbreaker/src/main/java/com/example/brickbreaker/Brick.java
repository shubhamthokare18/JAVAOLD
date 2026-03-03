package com.example.brickbreaker;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Brick {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private int hp;


    public Brick(double x, double y, double width, double height, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
    }


    public void render(GraphicsContext gc) {
        if (!isAlive()) return;
        gc.setFill(Color.ORANGE);
        gc.fillRect(x, y, width, height);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, width, height);
    }


    public void hit() {
        hp--;
    }


    public boolean isAlive() {
        return hp > 0;
    }


    // getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}