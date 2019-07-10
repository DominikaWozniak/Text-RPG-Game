package pl.game.gamerpg.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
public class Person {

    private String name;
    private CharacterType characterType;
    private Integer lifePoints;
    private Integer attackPoints;
    private Integer lifePointsAfterAttack;
    private CharacterAttackEnemy[] characterAttackEnemies;


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
        } else return characterAttackEnemies[2];
    }



}
