package pl.game.gamerpg.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.game.gamerpg.components.JavaUtilObjectsDI;
import pl.game.gamerpg.model.*;

@Service
@AllArgsConstructor
public class GameLogicServiceImpl implements GameLogicService {

    private Player player;
    private Enemy enemy;
    private JavaUtilObjectsDI javaUtilObjectsDI;

    @Override
    public void storyAboutAdventure() {
        System.out.println("Gra rozpoczęta.");
        System.out.println("Podróżujesz przez tajemnicze krainy by uwolnić księżniczkę.");
        System.out.println("Na swojej drodze spotykasz pierwszego wroga, który chce Cię zabić");
        System.out.println("Musisz z nim walczyć.");
    }

    @Override
    public void battleWithThief() {
        enemy.setStatsForThief();
        enemy.setDataToArrayEnemiesAttacks();

        System.out.println("Okazuje się, że jest to okoliczny: " + enemy.getCharacterType());
        System.out.println("o imieniu: " + enemy.getName());

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));
            enemy.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));

                System.out.println("Wybierz atak: ");

                player.playerChooseAction();
                System.out.println("Twoje punkty ataku: " + player.getAttackPoints());

                player.battleMethodForAllEnemies();

            if (player.getLifePoints() <= 0 || enemy.getLifePoints() <= 0) {
                break;
            }
        }

        if (player.resultBattle() == ResultBattle.YOU_LOSE) {
            System.out.println("MIAŁEŚ MNIEJ PUNKTÓW ŻYCIA OD"
                                                    + enemy.getCharacterType()
                                                    + " ZACZYNAMY OD POCZĄTKU: ");
            player.setLifePoints(150);
            storyAboutAdventure();
            battleWithThief();
        }

    }

    @Override
    public void battleWithGuard() {
        player.setLifePoints(160);
        enemy.setStatsForGuard();
        enemy.setDataToArrayEnemiesAttacks();

        System.out.println("Posiadasz teraz " + player.getLifePoints() +" punktów energii.");
        System.out.println("Jesteś w połowie drogi do celu.");
        System.out.println("Zmierzasz w kierunku mostu na którym stoi strażnik, który nie chce Cię przepuścić.");
        System.out.println("A więc musisz walczyć: ");

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(60));
            enemy.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));

            System.out.println("Wybierz atak: ");
            player.playerChooseAction();

            System.out.println("Twoje punkty ataku: " + player.getAttackPoints());
            enemy.enemyChooseAction();

            if (enemy.enemyChooseAction() == CharacterAttackEnemy.BLOKADA) {
                player.setAttackPoints(0);
                enemy.setAttackPoints(0);
                System.out.println(enemy.getCharacterType() + " zablokował twój atak. "
                                                                                + " Twoje punkty ataku: "
                                                                                + player.getAttackPoints());
            }

            player.battleMethodForAllEnemies();

            if (player.getLifePoints() <= 0 || enemy.getLifePoints() <= 0) {
                break;
            }

            if (player.resultBattle() == ResultBattle.YOU_LOSE){
                System.out.println("MIAŁEŚ MNIEJ PUNKTÓW ŻYCIA OD: "
                                                    + enemy.getCharacterType()
                                                    + " ZACZYNAMY OD POCZĄTKU.");
                player.setLifePoints(160);
                battleWithGuard();
        }

        }
        
    }

    @Override
    public void battleWithDragon() {
        //not implement yet
    }
}
