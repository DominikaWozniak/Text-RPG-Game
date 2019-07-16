package pl.game.gamerpg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
@Getter
public class Enemy extends Person {

    private CharacterAttackEnemy[] characterAttackEnemies;


    public void setStatsForGuard(){
        setName("Wiesław");
        setLifePoints(150);
        setCharacterType(CharacterType.STRAŻNIK);

    }

    public void setStatsForDragon(){
        setName("Drogon");
        setLifePoints(200);
        setCharacterType(CharacterType.SMOK);

    }

    public void setStatsForThief(){
        setName("Eustachy");
        setLifePoints(120);
        setCharacterType(CharacterType.ZŁODZIEJ);
    }

    public void setDataToArrayEnemiesAttacks(){


        if (getCharacterType() == CharacterType.ZŁODZIEJ) {
            characterAttackEnemies = new CharacterAttackEnemy[3];
            characterAttackEnemies[0] = CharacterAttackEnemy.KOPNIĘCIE;
            characterAttackEnemies[1] = CharacterAttackEnemy.CIĘCIE_SZTYLETEM;
            characterAttackEnemies[2] = CharacterAttackEnemy.UDERZENIE_PIĘŚCIĄ;
        } else if (getCharacterType() == CharacterType.STRAŻNIK) {
            characterAttackEnemies = new CharacterAttackEnemy[3];
            characterAttackEnemies[0] = CharacterAttackEnemy.UDERZENIE_TARCZĄ;
            characterAttackEnemies[1] = CharacterAttackEnemy.POTĘŻNY_CIOS_MIECZEM;
            characterAttackEnemies[2] = CharacterAttackEnemy.BLOKADA_CIOSU;
        } else if (getCharacterType() == CharacterType.SMOK) {
            characterAttackEnemies = new CharacterAttackEnemy[3];
            characterAttackEnemies[0] = CharacterAttackEnemy.BLOKADA;
            characterAttackEnemies[1] = CharacterAttackEnemy.ZIONIĘCIE_OGNIEM;
            characterAttackEnemies[2] = CharacterAttackEnemy.POTĘŻNY_CIOS_ŁAPĄ;
        }

    }

    public CharacterAttackEnemy enemyChooseAction(){
        Random random = new Random();
        int i;
        i = random.nextInt(3) + 1;
        if (i == 1) {
            return characterAttackEnemies[0];
        } if (i == 2) {
            return characterAttackEnemies[1];
        } else {
            return characterAttackEnemies[2];}
    }


}
