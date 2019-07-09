package pl.game.gamerpg.model;

import org.springframework.stereotype.Component;

@Component
public class Dragon extends Person {

    public void setStatsForDragon(){
        setName("Drogon");
        setLifePoints(200);
        setCharacterType(CharacterType.SMOK);

    }
}
