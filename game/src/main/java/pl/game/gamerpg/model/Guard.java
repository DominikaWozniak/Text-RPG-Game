package pl.game.gamerpg.model;

import org.springframework.stereotype.Component;

@Component
public class Guard extends Person {

    public void setStatsForGuard(){
        setName("Wiesław");
        setLifePoints(150);
        setCharacterType(CharacterType.STRAŻNIK);

    }
}
