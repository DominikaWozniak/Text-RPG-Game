package pl.game.gamerpg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String name;
    private CharacterType characterType;
    private Integer lifePoints;
    private Integer attackPoints;
    private Integer lifePointsAfterAttack;


}
