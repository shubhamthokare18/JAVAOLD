import com.example.brickbreaker.Brick;
import javafx.scene.paint.Color;

private void resetGame() {

}

private void resetBallAndPaddle() {
}

private void buildBricks() {
}


private void render() {
// clear
    gc.setFill(Color.web("#0b2545"));
    gc.fillRect(0, 0, width, height);


// HUD
    gc.setFill(Color.WHITE);
    gc.fillText("Score: " + score, 10, 20);
    gc.fillText("Lives: " + lives, width - 80, 20);
    if (paused) {
        gc.fillText("PAUSED - press SPACE to resume", width / 2.0 - 80, height / 2.0);
    }


// Draw paddle
    paddle.render(gc);


// Draw ball
    ball.render(gc);


// Draw bricks
    for (Brick b : bricks) {
        b.render(gc);
    }
}


public Paddle getPaddle() {
    return paddle;
}
}

void main() {
}