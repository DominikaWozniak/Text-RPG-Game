package pl.game.gamerpg.model;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.game.gamerpg.components.JavaUtilObjectsDI;


@Component
@AllArgsConstructor
@Getter
public class Player extends Person {

    private JavaUtilObjectsDI javaUtilObjectsDI;
    private CharacterAttackPlayer[] attacksArray;
    private Enemy enemy;



    public void setDataToArrayPlayerAttack(){
        attacksArray = new CharacterAttackPlayer[3];

       if (getCharacterType() == CharacterType.CZARODZIEJ) {
           attacksArray[0] = CharacterAttackPlayer.FALA_UDERZENIOWA;
           attacksArray[1] = CharacterAttackPlayer.ELEKTRYCZNA_KULA;
           attacksArray[2] = CharacterAttackPlayer.MAGICZNY_OGIEŃ;
       } else if (getCharacterType() == CharacterType.BARBARZYŃCA) {
           attacksArray[0] = CharacterAttackPlayer.CIOS_TARCZĄ;
           attacksArray[1] = CharacterAttackPlayer.KOPNIAK;
           attacksArray[2] = CharacterAttackPlayer.CIOS_TOPOREM;
       } else if (getCharacterType() == CharacterType.RYCERZ){
           attacksArray[0] = CharacterAttackPlayer.PCHNIĘCIE_MIECZEM;
           attacksArray[1] = CharacterAttackPlayer.CIĘCIE_KLINGĄ;
           attacksArray[2] = CharacterAttackPlayer.UDERZENIE_TARCZĄ;
       }

    }

    public void playerChooseAction() {
        String z;
        z = javaUtilObjectsDI.scanner().nextLine();
        if (z.equalsIgnoreCase(String.valueOf(1))){
            System.out.println("Twój atak: " + attacksArray[0]);
        } else if (z.equalsIgnoreCase(String.valueOf(2))) {
            System.out.println("Twój atak: " + attacksArray[1]);
        } else {
            System.out.println("Twój atak: " + attacksArray[2]);
        }

    }

    public ResultBattle resultBattle(){
        if (getLifePoints() > enemy.getLifePoints()) {
            return  ResultBattle.YOU_WIN;
        } else if (getLifePoints() == enemy.getLifePoints()) {
            return ResultBattle.DRAW;
        } else return ResultBattle.YOU_LOSE;
    }

    public void battleMethodForAllEnemies(){
        enemy.setLifePointsAfterAttack(enemy.getLifePoints() - getAttackPoints());
        enemy.setLifePoints(enemy.getLifePointsAfterAttack());

        if (enemy.getLifePointsAfterAttack() > 0) {
            System.out.println("Energia " + enemy.getCharacterType()
                    + " po ataku: "
                    + enemy.getLifePointsAfterAttack());
        }

        System.out.println(enemy.getCharacterType() + " atakuje. Korzysta z: "
                + enemy.enemyChooseAction()
                + " zadaje punkty obrażeń: "
                + enemy.getLifePoints());

       setLifePointsAfterAttack(getLifePoints() - enemy.getAttackPoints());
        setLifePoints(getLifePointsAfterAttack());

        if (getLifePointsAfterAttack() > 0) {
            System.out.println("Twoja energia po ataku: " + getLifePointsAfterAttack());
        }

        if (getLifePoints() <= 0
                || enemy.getLifePoints() <= 0
                || getLifePoints() == enemy.getLifePoints()) {
            System.out.println(resultBattle());
        }
    }

}
