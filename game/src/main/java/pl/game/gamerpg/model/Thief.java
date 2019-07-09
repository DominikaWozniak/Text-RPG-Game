package pl.game.gamerpg.model;

import org.springframework.stereotype.Component;
import pl.game.gamerpg.components.JavaUtilObjectsDI;

@Component
public class Thief extends Person {

    private JavaUtilObjectsDI javaUtilObjectsDI;
    private CharacterAttackEnemy[] attackThiefArray;

    public Thief(JavaUtilObjectsDI javaUtilObjectsDI) {
        this.javaUtilObjectsDI = javaUtilObjectsDI;
    }

    public void setStatsForThief(){
        setName("Eustachy");
        setLifePoints(120);
        setCharacterType(CharacterType.ZŁODZIEJ);
    }

    public CharacterAttackEnemy drawAttack(){
        attackThiefArray = new CharacterAttackEnemy[3];
        attackThiefArray[0] = CharacterAttackEnemy.KOPNIĘCIE;
        attackThiefArray[1] = CharacterAttackEnemy.CIĘCIE_SZTYLETEM;
        attackThiefArray[2] = CharacterAttackEnemy.UDERZENIE_PIĘŚCIĄ;
        int i;
        i = javaUtilObjectsDI.random().nextInt(3) + 1;
        if (i == 1) {
            return attackThiefArray[0];
        } else if (i==2) {
            return attackThiefArray[1];
        } else{
            return attackThiefArray[2];
        }
    }

}
