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
        System.out.println("Na swojej drodze spotykasz pierwszego wroga, który chce Cię zabić");
        System.out.println("Musisz z nim walczyć.");
    }

    @Override
    public void battleWithThief() {
        thief.setStatsForThief();
        thief.setDataToArrayEnemiesAttacks();

        System.out.println("Okazuje się, że jest to okoliczny: " + thief.getCharacterType());
        System.out.println("o imieniu: " + thief.getName());

        while (true) {
            player.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));
            thief.setAttackPoints(javaUtilObjectsDI.random().nextInt(50));

                System.out.println("Wybierz atak: ");

                player.playerChooseAction();
                System.out.println("Twoje punkty ataku: " + player.getAttackPoints());

                thief.setLifePointsAfterAttack(thief.getLifePoints() - player.getAttackPoints());
                thief.setLifePoints(thief.getLifePointsAfterAttack());

                if (thief.getLifePointsAfterAttack() > 0) {
                    System.out.println("Energia " + thief.getCharacterType()
                                                            + " po ataku: "
                                                            + thief.getLifePointsAfterAttack());
                }

                System.out.println(thief.getCharacterType() + " atakuje. Korzysta z: "
                                                                            + thief.enemyChooseAction());

                System.out.println(thief.getCharacterType() + " zadaje punkty obrażeń: "
                                                                            + thief.getAttackPoints());

                player.setLifePointsAfterAttack(player.getLifePoints() - thief.getAttackPoints());
                player.setLifePoints(player.getLifePointsAfterAttack());

                if (player.getLifePointsAfterAttack() > 0) {
                    System.out.println("Twoja energia po ataku: " + player.getLifePointsAfterAttack());
                }

                if (player.getLifePoints() <= 0
                        || thief.getLifePoints() <= 0
                        || player.getLifePoints() == thief.getLifePoints()) {
                    System.out.println(player.resultBattle());
                }

            if (player.getLifePoints() <= 0 || thief.getLifePoints() <= 0) {
                break;
            }
        }

        if (player.resultBattle() == ResultBattle.YOU_LOSE) {
            System.out.println("MIAŁEŚ MNIEJ PUNKTÓW ŻYCIA OD"
                                                    + thief.getCharacterType()
                                                    + "Zaczynamy od początku: ");
            player.setLifePoints(150);
            storyAboutAdventure();
            battleWithThief();
        }

    }

    @Override
    public void battleWithGuard() {
        player.setLifePoints(160);
        System.out.println("Posiadasz teraz " + player.getLifePoints() +" punktów energii.");

    }

    @Override
    public void battleWithDragon() {
        //not implement yet
    }
}
