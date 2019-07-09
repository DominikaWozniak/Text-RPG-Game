package pl.game.gamerpg.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.game.gamerpg.services.GameLogicService;
import pl.game.gamerpg.services.PlayerService;

@Controller
@AllArgsConstructor
public class GameController {

    private PlayerService playerService;
    private GameLogicService gameLogicService;


    public void start(){
        playerService.sayHelloToPlayer();
        playerService.getNamePlayerFromConsole();
        playerService.getCharacterTypeFromPlayer();
        playerService.statsInfo();
        gameLogicService.storyAboutAdventure();
        gameLogicService.battleWithThief();
    }


}
