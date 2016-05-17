package br.ufrpe.util.samples;

import br.ufrpe.util.SpriteAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HorseAnimationSample extends Application {

    private static final Image IMAGE = new Image("horse_in_motion.jpg");

    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  18;
    private static final int OFFSET_Y =  25;
    private static final int FRAME_WIDTH    = 374;
    private static final int FRAME_HEIGHT   = 243;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("The Horse in Motion");

        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, FRAME_WIDTH, FRAME_HEIGHT));

        long startTime = System.currentTimeMillis();
        final Animation animation = new SpriteAnimation(
                imageView, Duration.millis(1000), COUNT, COLUMNS, OFFSET_X, OFFSET_Y,
                FRAME_WIDTH, FRAME_HEIGHT);;
        new Thread (new Runnable() {
            public void run() {
                animation.setCycleCount(Animation.INDEFINITE);
                animation.play();
            }
        }).start();
        primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.show();
        
        
        new Thread (new Runnable() {
            public void run() {
                boolean waiting = true;
                while(waiting) {
                    long passedTime = System.currentTimeMillis() - startTime ;
                    if (passedTime > 4000) {
                        waiting = false;
                        animation.stop();
                    } 
                }
            }
        }).start();
        
    }
}