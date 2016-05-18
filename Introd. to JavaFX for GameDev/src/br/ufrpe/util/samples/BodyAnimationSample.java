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
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int FRAME_WIDTH    = 64;
    private static final int FRAME_HEIGHT   = 60;
    
    private final SpriteAnimation animation;
    
    public BodyAnimationSample() {
        animation = new SpriteAnimation("body.png", Duration.millis(1000), 
                COUNT, COLUMNS, OFFSET_X, OFFSET_Y, FRAME_WIDTH, FRAME_HEIGHT);
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
        Scene mainScene = new Scene(root);
        mainScene.setOnKeyPressed(this);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        animation.play();
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.RIGHT)) {
            animation.setSpriteX(animation.getSpriteX() + 1);
        }
    }
}