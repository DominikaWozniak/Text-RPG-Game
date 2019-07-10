package pl.game.gamerpg.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.game.gamerpg.components.JavaUtilObjectsDI;
import pl.game.gamerpg.model.*;

@Service
@AllArgsConstructor
public class GameLogicServiceImpl implements GameLogicService {

    private Player player;
    private Thief thief;
    private Guard guard;
    private Dragon dragon;
    private JavaUtilObjectsDI javaUtilObjectsDI;



    @Override
    public void storyAboutAdventure() {
        System.out.println("Gra rozpoczęta.");
        System.out.println("Podróżujesz przez tajemnicze krainy by uwolnić księżniczkę.");
        System.out.println("Na swojej drodze spotykasz pierwszego wroga. Musisz z nim walczyć.");
    }

    @Override
    public void battleWithThief() {
        thief.setStatsForThief();
        thief.setDataToArrayEnemiesAttacks();

        System.out.println("Okazuje się, że jest to okoliczny: " + thief.getCharacterType());
        System.out.println("o imieniu: " + thief.getName());
        System.out.println(thief.getName() + " atakuje Cię jako pierwszy.");

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));
            thief.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));


            System.out.println(thief.getCharacterType() + " użył ataku: "
                                                                    + thief.enemyChooseAction()
                                                            + " DAMAGE: " + thief.getAttackPoints());

            player.setLifePointsAfterAttack(player.getLifePoints() - thief.getAttackPoints());
            player.setLifePoints(player.getLifePointsAfterAttack());



                System.out.println("Twoja energia po ataku: "
                        + player.getLifePointsAfterAttack()
                        + " Wybierz atak: ");


            player.playerChooseAction();

            System.out.println("Twoje punkty ataku: " + player.getAttackPoints());

            thief.setLifePointsAfterAttack(thief.getLifePoints() - player.getAttackPoints());
            thief.setLifePoints(thief.getLifePointsAfterAttack());

            System.out.println("Energia " + thief.getCharacterType() + " po ataku: "
                                                                + thief.getLifePointsAfterAttack());

            System.out.println("Wynik walkii: " + player.resultBattle());

            if (player.getLifePointsAfterAttack() <= 0 || thief.getLifePointsAfterAttack() <= 0) {
                break;
            }
        }

    }

    @Override
    public void battleWithGuard() {
        //not implement yet
    }

    @Override
    public void battleWithDragon() {
        //not implement yet
    }
}
