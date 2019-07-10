package pl.game.gamerpg.model;

import org.springframework.stereotype.Component;
import pl.game.gamerpg.components.JavaUtilObjectsDI;

@Component
public class Guard extends Person {

    private CharacterAttackEnemy[] attackGuardArray;
    private JavaUtilObjectsDI javaUtilObjectsDI;


    public void setStatsForGuard(){
        setName("Wiesław");
        setLifePoints(150);
        setCharacterType(CharacterType.STRAŻNIK);

    }

   /* public CharacterAttackEnemy drawAttack(){








        attackGuardArray = new CharacterAttackEnemy[3];
        attackGuardArray[0] = CharacterAttackEnemy.UDERZENIE_TARCZĄ;
        attackGuardArray[1] = CharacterAttackEnemy.POTĘŻNY_CIOS_MIECZEM;
        attackGuardArray[2] = CharacterAttackEnemy.BLOKADA_CIOSU;

        int i;
        i = javaUtilObjectsDI.random().nextInt(3)+1;

        if (i==1){
            return attackGuardArray[0];
        } else if (i==2) {
            return attackGuardArray[1];
        } else return attackGuardArray[2];
    }*/
}
