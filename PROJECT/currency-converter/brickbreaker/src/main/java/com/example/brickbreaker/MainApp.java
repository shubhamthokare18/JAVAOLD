package com.example.brickbreaker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainApp extends Application {


    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;


    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        Game game = new Game(WIDTH, HEIGHT, gc);


        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);


// Input handling
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
                game.getPaddle().setMovingLeft(true);
            } else if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
                game.getPaddle().setMovingRight(true);
            } else if (e.getCode() == KeyCode.SPACE) {
                game.togglePause();
            }
        });


        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
                game.getPaddle().setMovingLeft(false);
            } else if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
                game.getPaddle().setMovingRight(false);
            }
        });


        primaryStage.setTitle("Brick Breaker - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


        game.start();
    }


    public static void main(String[] args) {
        launch(args);