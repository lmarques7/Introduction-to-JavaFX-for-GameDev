package br.ufrpe.util.samples;

import br.ufrpe.util.SpriteAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BodyAnimationSample extends Application implements EventHandler<KeyEvent> {

    private static final int COLUMNS  =   9;
    private static final int COUNT    =   9;
    private static final int FRAME_WIDTH    = 64;
    private static final int FRAME_HEIGHT   = 64;
    
    private final SpriteAnimation animation;
    
    public BodyAnimationSample() {
        animation = new SpriteAnimation("body_full.png", Duration.millis(1000), 
                COUNT, COLUMNS, 0, FRAME_HEIGHT*3, FRAME_WIDTH, FRAME_HEIGHT);
        animation.setCycleCount(Animation.INDEFINITE);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("The body in motion");

        final Canvas canvas = new Canvas(800, 600);

        Group root = new Group(canvas);
        root.getChildren().add(animation.getImageView());
        animation.getImageView().setY(100);
        animation.getImageView().setX(100);
        animation.getImageView().setScaleX(3);
        animation.getImageView().setScaleY(3);
        Scene mainScene = new Scene(root);
        mainScene.setOnKeyPressed(this);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        animation.play();
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.RIGHT)) {
            animation.setOffsetY(FRAME_HEIGHT * 3);
            animation.setSpriteX(animation.getSpriteX() + 3);
        } else if (event.getCode().equals(KeyCode.LEFT)) {
            animation.setOffsetY(FRAME_HEIGHT);
            animation.setSpriteX(animation.getSpriteX() - 3);
        } else if (event.getCode().equals(KeyCode.UP)) {
            animation.setOffsetY(0);
            animation.setSpriteY(animation.getSpriteY() - 3);
        } else if (event.getCode().equals(KeyCode.DOWN)) {
            animation.setOffsetY(FRAME_HEIGHT * 2);
            animation.setSpriteY(animation.getSpriteY() + 3);
        }
    }
}