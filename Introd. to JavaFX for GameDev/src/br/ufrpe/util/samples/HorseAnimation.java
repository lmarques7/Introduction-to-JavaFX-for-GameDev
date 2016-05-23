package br.ufrpe.util.samples;

import br.ufrpe.util.SpriteAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HorseAnimation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpriteAnimation animation = new SpriteAnimation(
                "horse_in_motion.jpg", Duration.millis(1000), 
                10, 4, 18, 25, 374, 243);
        
        Group root = new Group();
        root.getChildren().add(animation.getImageView());
        
        Scene scene = new Scene(root);
        
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
