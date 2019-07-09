package pl.game.gamerpg.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.game.gamerpg.components.JavaUtilObjectsDI;


@Getter
@Setter
public class Person {

    private String name;
    private CharacterType characterType;
    private Integer lifePoints;
    private Integer attackPoints;
    private Integer lifePointsAfterAttack;
    private JavaUtilObjectsDI javaUtilObjectsDI;


}
