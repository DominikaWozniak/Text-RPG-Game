package pl.game.gamerpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.game.gamerpg.controllers.GameController;

@SpringBootApplication
public class GameRpgApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GameRpgApplication.class, args);

        GameController gameController = (GameController) ctx.getBean("gameController");

        gameController.start();


    }

}
